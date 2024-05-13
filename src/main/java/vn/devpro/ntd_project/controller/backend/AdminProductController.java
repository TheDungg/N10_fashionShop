package vn.devpro.ntd_project.controller.backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.devpro.ntd_project.controller.BaseController;
import vn.devpro.ntd_project.dto.DuntoConstants;
import vn.devpro.ntd_project.dto.SearchModel;
import vn.devpro.ntd_project.model.Category;
import vn.devpro.ntd_project.model.Product;
import vn.devpro.ntd_project.model.User;
import vn.devpro.ntd_project.service.CategoryService;
import vn.devpro.ntd_project.service.ProductService;
import vn.devpro.ntd_project.service.UserService;

@Controller
public class AdminProductController extends BaseController implements DuntoConstants {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private ProductImageService productImageService;
	
	//-------------------------product list-----------------------------------
	@RequestMapping(value = "/admin/product-list", method = RequestMethod.GET)
	public String productList(final Model model,
			final HttpServletRequest request) throws IOException{
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		
		SearchModel productSearch = new SearchModel();
		
		//tìm với status
		productSearch.setStatus(2);
		if(!StringUtils.isEmpty(request.getParameter("status"))) {
			productSearch.setStatus(Integer.parseInt(request.getParameter("status")));
		}
		
		//tìm với category
		productSearch.setCategoryId(0);
		if(!StringUtils.isEmpty(request.getParameter("categoryId"))) {
			productSearch.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
		}
		
		//tìm với keyword
		productSearch.setKeyword(request.getParameter("keyword"));
		
		//tìm kiếm với date
		productSearch.setBeginDate(request.getParameter("beginDate"));
		productSearch.setEndDate(request.getParameter("endDate"));
		
		//phân trang
		if(!StringUtils.isEmpty(request.getParameter("page"))) { //bấm nút chuyển trang
			productSearch.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}else {
			productSearch.setCurrentPage(1);
		}
				
		List<Product> allProducts = productService.searchProduct(productSearch);
				
		List<Product> products = new ArrayList<Product>();
		
		int totalPages = allProducts.size()/SIZE_OF_PAGE;
		if(allProducts.size()%SIZE_OF_PAGE >0) {
			totalPages++;
		}
		if(totalPages < productSearch.getCurrentPage()) {
			productSearch.setCurrentPage(1);
		}
		
		int firstIndex = (productSearch.getCurrentPage() - 1) * SIZE_OF_PAGE;
		int index = firstIndex, count = 0;
		while(index < allProducts.size() && count < SIZE_OF_PAGE ) {
			products.add(allProducts.get(index));
			index++;
			count++;
		}
		
		productSearch.setSizeOfPage(SIZE_OF_PAGE); //số bản ghi trên 1 trang
		productSearch.setTotalItems(allProducts.size()); // tổng số sản phẩm
		
		model.addAttribute("products", products);
		model.addAttribute("productSearch", productSearch);
		
		
		
		return "backend/product-list";
	}
	
	//-----------------add new product----------------------------------
	@RequestMapping(value = "/admin/product-add", method = RequestMethod.GET)
	public String productAdd(final Model model) throws IOException{
		//Lay danh sach user tu tbl_user trong database
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		
		Product product = new Product();
		product.setCreateDate(new Date());
		model.addAttribute("product", product);
		
		return "backend/product-add";
	}
	
	//-----------------save product to database---------------------
	@RequestMapping(value = "/admin/product-add-save", method = RequestMethod.POST)
	public String productAddSave(final Model model,
			final HttpServletRequest request,
			@ModelAttribute("product") Product product,
			@RequestParam("avatarFile") MultipartFile avatarFile,
			@RequestParam("imageFiles") MultipartFile[] imageFiles
			) throws IOException{

		productService.saveAddProduct(product, avatarFile, imageFiles);
		
		return "backend/product-add";
	}
	
	//----------------edit product---------------------
	@RequestMapping(value = "/admin/product-edit/{productId}", method = RequestMethod.GET)
	public String productEdit(final Model model,
			@PathVariable("productId") int productId 
			) throws IOException{
		
		
		Product product = productService.getById(productId);
		model.addAttribute("product", product);
		
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		
		return "backend/product-edit";
	}
	
	//-----------------save product-edit to database---------------------
	@RequestMapping(value = "/admin/product-edit-save", method = RequestMethod.POST)
	public String productEditSave(final Model model,
			final HttpServletRequest request,
			@ModelAttribute("product") Product product,
			@RequestParam("avatarFile") MultipartFile avatarFile,
			@RequestParam("imageFiles") MultipartFile[] imageFiles) throws IOException{


		productService.saveEditProduct(product, avatarFile, imageFiles);
		
		return "redirect:/admin/product-list";
	}
	
	//Delete user
	@RequestMapping(value = "/admin/product-delete/{productId}", method = RequestMethod.GET)
	public String productDelete(final Model model,
			@PathVariable("productId") int productId 
			) throws IOException{
				
		productService.deleteProductbyId(productId);
		
		return "redirect:/admin/product-list";
	}
	
}
