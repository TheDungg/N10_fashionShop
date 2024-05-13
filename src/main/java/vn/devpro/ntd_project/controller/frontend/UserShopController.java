package vn.devpro.ntd_project.controller.frontend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.ntd_project.controller.BaseController;
import vn.devpro.ntd_project.dto.SearchModel;
import vn.devpro.ntd_project.model.Category;
import vn.devpro.ntd_project.model.Product;
import vn.devpro.ntd_project.service.CategoryService;
import vn.devpro.ntd_project.service.ProductService;




@Controller
public class UserShopController extends BaseController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String bottom(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		
		List<Category> categories = categoryService.findAllActive();
		model.addAttribute("categories", categories);
		
		Category category = new Category();
		
		SearchModel productSearch = new SearchModel();
		productSearch.setKeyword(request.getParameter("keyword"));
		
		productSearch.setPrice(0);
		if(!StringUtils.isEmpty(request.getParameter("price"))){
			productSearch.setPrice(Integer.parseInt(request.getParameter("price")));
		}
		
		productSearch.setCategoryId(0);
		if(!StringUtils.isEmpty(request.getParameter("categoryId"))) {
			productSearch.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
			category = categoryService.getById(productSearch.getCategoryId());
		}
		
		productSearch.setPriceSort(0);
		if(!StringUtils.isEmpty(request.getParameter("priceSort"))) {
			productSearch.setPriceSort(Integer.parseInt(request.getParameter("priceSort")));
		}
		
		if(!StringUtils.isEmpty(request.getParameter("page"))) {
			productSearch.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}else {
			productSearch.setCurrentPage(1);
		}
		
		List<Product> listProducts = productService.listProducts(productSearch);
		List<Product> products = new ArrayList<Product>();
		
		int sizeOfPage = 9;
		
		int totalPages = listProducts.size() / sizeOfPage;
		if(listProducts.size() % sizeOfPage > 0) {
			totalPages++;
		}
		
		if(totalPages < productSearch.getCurrentPage()) {
			productSearch.setCurrentPage(1);
		}
		
		int firstIndex = (productSearch.getCurrentPage() - 1) * sizeOfPage;
		int index = firstIndex, count = 0;
		while(index < listProducts.size() && count < sizeOfPage) {
			products.add(listProducts.get(index));
			index++;
			count++;
		}
		
		productSearch.setTotalItems(listProducts.size());
		productSearch.setSizeOfPage(sizeOfPage);
		
		model.addAttribute("products", products);
		model.addAttribute("productSearch", productSearch); 
		model.addAttribute("category", category);
		
		return "frontend/shop";
		
	}
}
