package vn.devpro.ntd_project.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.ntd_project.controller.BaseController;
import vn.devpro.ntd_project.dto.DuntoConstants;
import vn.devpro.ntd_project.model.Product;
import vn.devpro.ntd_project.model.ProductImage;
import vn.devpro.ntd_project.service.ProductImageService;
import vn.devpro.ntd_project.service.ProductService;

@Controller
public class UserHomeController extends BaseController implements DuntoConstants {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductImageService productImageService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		
		
		
//		SearchModel productSearch = new SearchModel();
//		
//		//tìm với keyword
//		productSearch.setKeyword(request.getParameter("keyword"));	
		
		
		List<Product> products = productService.findAllActive();
		
		
		model.addAttribute("products", products);
//		model.addAttribute("productSearch", productSearch);
		model.addAttribute("totalProducts", products.size());
		

		
		return "frontend/index";	
	}
	
	@RequestMapping(value = "/shop-details/{productId}", method = RequestMethod.GET)
	public String productDetail(final Model model, final HttpServletRequest request,
			final HttpServletResponse response ,@PathVariable("productId") int productId) throws IOException{
		Product product = productService.getById(productId);
		model.addAttribute("product", product);
		
//		Category categories = product.getCategory();
//		model.addAttribute("categories", categories);
		
		List<ProductImage> productImages = productImageService.findAllImageByProduct(productId);
		model.addAttribute("productImages", productImages);
		
		int categoryId = product.getCategory().getId();
		List<Product> productInCategory = productService.findProductByCategory(categoryId);
		
		
		model.addAttribute("productInCategory", productInCategory);
		return "frontend/shop-details";
	}
}
