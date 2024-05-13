package vn.devpro.ntd_project.controller.frontend;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.ntd_project.controller.BaseController;
import vn.devpro.ntd_project.dto.Cart;
import vn.devpro.ntd_project.dto.CartProduct;
import vn.devpro.ntd_project.dto.Contact;
import vn.devpro.ntd_project.dto.DuntoConstants;
import vn.devpro.ntd_project.model.Product;
import vn.devpro.ntd_project.model.SaleOrder;
import vn.devpro.ntd_project.model.SaleOrderProduct;
import vn.devpro.ntd_project.model.User;
import vn.devpro.ntd_project.service.ProductService;
import vn.devpro.ntd_project.service.SaleOrderService;



@Controller
public class CartController extends BaseController implements DuntoConstants {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private SaleOrderService saleOrderService;
	
	@RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addToCart(
			final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@RequestBody CartProduct addedProduct) throws IOException{
		
		//lay session
		HttpSession session = request.getSession();
		
		Cart cart = null;
		//kiểm tra xem có giỏ hàng chưa
		if(session.getAttribute("cart") == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}else {
			cart = (Cart)session.getAttribute("cart");
		}
		
		//thêm hàng vào giỏ
		//lấy product trong db
		Product dbProduct = productService.getById(addedProduct.getProductId());
		//tạo mới 1 cartProduct
		int index = cart.findProductById(dbProduct.getId());
		if(index != -1) { //TH1: sp có trong giỏ -> tăng số lượng
			cart.getCartProducts().get(index).setQuantity(
					cart.getCartProducts().get(index).getQuantity() +
					addedProduct.getQuantity());
		}else { //TH2: sp chưa có trong giỏ -> thêm mới
			addedProduct.setAvatar(dbProduct.getAvatar());
			addedProduct.setProductName(dbProduct.getName());
			addedProduct.setPrice(dbProduct.getPrice());
			
			cart.getCartProducts().add(addedProduct);
		}
		
		//thiết lập biến session cho cart
		session.setAttribute("cart", cart);
		//trả về tổng số sản phẩm
		model.addAttribute("totalCartProducts", cart.totalCartProducts());
		
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("code", 404);
		jsonResult.put("message", "Đã thêm sản phẩm '" + dbProduct.getName() + "' vào giỏ hàng");
		jsonResult.put("totalCartProducts", cart.totalCartProducts());
		
		return ResponseEntity.ok(jsonResult);
	}
	
	//--------------cart display-------------
	@RequestMapping(value = "/shopping-cart", method = RequestMethod.GET)
	public String cartView(
			final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException{
		
		//lấy giỏ hàng
		HttpSession session = request.getSession();
		Cart cart = null;
		String message = null;
		
		if(session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
			message = "Có " + cart.totalCartProducts() + " trong giỏ hàng";
			model.addAttribute("totalCartPrice", cart.totalCartPrice());
		}else {
			message = "Không có sản phẩm nào trong giỏ hàng";
		}
		
		model.addAttribute("message", message);
//		model.addAttribute("message", message);
		
		if(isLogined()) {
			model.addAttribute("user", getLoginedUser());
		}else {
			model.addAttribute("user", new User());
		}
		
		return "frontend/shopping-cart";
	}
	
	//-----------delete product in cart---------
	@RequestMapping(value = "/product-cart-delete/{productId}", method = RequestMethod.GET)
	public String productCartDelete(@PathVariable("productId") int productId,
			final Model model,
			final HttpServletRequest request) {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		int index = cart.findProductById(productId);
		if(index != -1) {
			cart.getCartProducts().remove(index);
		}
		if(cart.totalCartProducts() == 0) {
			cart = null;
		}
		session.setAttribute("cart", cart);
		
		return "redirect:/shopping-cart";
	}
	
	//------------change the quantity of the item--------
	@RequestMapping(value = "/update-product-quantity", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> updateProductQuantity(
			final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@RequestBody CartProduct updateProduct) throws IOException{
		
		//lay gio hang
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		int index = cart.findProductById(updateProduct.getProductId());
		Integer newQuantity = cart.getCartProducts().get(index).getQuantity() + updateProduct.getQuantity();
		if(newQuantity.intValue() < 1) {
			newQuantity = 1;
		}
		cart.getCartProducts().get(index).setQuantity(newQuantity);
		
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		
		jsonResult.put("code", 200);
		jsonResult.put("stutus", "success");
		jsonResult.put("newQuantity", newQuantity);
		
		return ResponseEntity.ok(jsonResult);
				
	}
	//--------------place order-------------
	@RequestMapping(value = "/place-order", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> placeOrder(
			final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@RequestBody Contact customer)throws IOException{
		
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		
		//ktr thong tin bat buoc
		if(customer.getTxtName().isEmpty()) {
			jsonResult.put("code", 100);
			jsonResult.put("message", "ban chua nhap ho ten");
		}else if(customer.getTxtMobile().isEmpty()) {
			jsonResult.put("code", 101);
			jsonResult.put("message", "ban chua nhap so dien thoai");
		}else {
			//lay gio hang de luu danh sach vao tbl_sale_order_product
			HttpSession session = request.getSession();
			if(session.getAttribute("cart") != null) { //co gio hang
				Cart cart = (Cart)session.getAttribute("cart");
				if(cart.totalCartProducts().intValue() > 0) {//co hang trong gio
					//tao don hang
					SaleOrder saleOrder = new SaleOrder();
					saleOrder.setCustomerName(customer.getTxtName());
					saleOrder.setCustomerMobile(customer.getTxtMobile());
					saleOrder.setCustomerAddress(customer.getTxtAddress());
					saleOrder.setCustomerEmail(customer.getTxtEmail());
					saleOrder.setTotal(cart.totalCartPrice());
					saleOrder.setCode(customer.getTxtMobile());
					saleOrder.setCreateDate(new Date());
					saleOrder.setStatus(false);
					
					//set mqh voi user
					User user = new User();
					user.setId(1);
					saleOrder.setUser(user);
					//Duyet ds sp trong cart va luu vao tbl_sale_order_product
					for(CartProduct cartProduct : cart.getCartProducts()) {
						SaleOrderProduct saleOrderProduct = new SaleOrderProduct();
						saleOrderProduct.setQuantity(cartProduct.getQuantity().intValue());
						Product product = productService.getById(cartProduct.getProductId()); //lay product
						saleOrderProduct.setProduct(product);
						saleOrder.addRelationalSaleOrderProduct(saleOrderProduct);//luu vao tbl_sale_order_product
						
					}
					//luu don hang vao tbl_sale_order
					saleOrderService.saveOrUpdate(saleOrder);
					//xoa gio hang sau khi luu thanh cong
					cart = new Cart();
					session.setAttribute("cart", null);
					jsonResult.put("code", 200);
					jsonResult.put("message", "Ban da dat hang thanh cong!");
					
					session.setAttribute("checkout", true);
				}else {
					jsonResult.put("code", 103);
					jsonResult.put("message", "Co loi duong truyen internet");
				}
			}else {
				jsonResult.put("code", 104);
				jsonResult.put("message", "Co loi duong truyen internet");
			}
		}
		return ResponseEntity.ok(jsonResult);
	}

	
}
	
	
	














