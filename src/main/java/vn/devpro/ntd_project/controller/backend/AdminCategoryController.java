package vn.devpro.ntd_project.controller.backend;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.ntd_project.controller.BaseController;
import vn.devpro.ntd_project.model.Category;
import vn.devpro.ntd_project.service.CategoryService;



@Controller
public class AdminCategoryController extends BaseController {

	@Autowired
	private CategoryService categoryService;
	
	
	//-------------------------category list-----------------------------------
	@RequestMapping(value = "/admin/category-list", method = RequestMethod.GET)
	public String categoryList(final Model model) throws IOException{
		//Lay danh sach category tu tbl_category trong database
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "backend/category-list";
	}
	
	//-----------------add new category----------------------------------
	@RequestMapping(value = "/admin/category-add", method = RequestMethod.GET)
	public String categoryAdd(final Model model) throws IOException{
		//Lay danh sach user tu tbl_user trong database
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		
		
		Category category = new Category();
		category.setCreateDate(new Date());
		model.addAttribute("category", category);
		
		return "backend/category-add";
	}
	
	//-----------------save category to database---------------------
	@RequestMapping(value = "/admin/category-add-save", method = RequestMethod.POST)
	public String categoryAddSave(final Model model,
			final HttpServletRequest request,
			@ModelAttribute("category") Category category) throws IOException{

		categoryService.saveOrUpdate(category);
		return "backend/category-add";
	}
	
	//----------------edit category---------------------
	@RequestMapping(value = "/admin/category-edit/{categoryId}", method = RequestMethod.GET)
	public String categoryEdit(final Model model,
			@PathVariable("categoryId") int categoryId //lay category id khi click Edit
			) throws IOException{
		
		//Lay category tu tbl_category trong database
		Category category = categoryService.getById(categoryId);
		model.addAttribute("category", category);
		
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		
		return "backend/category-edit";
	}
	
	//-----------------save category-edit to database---------------------
	@RequestMapping(value = "/admin/category-edit-save", method = RequestMethod.POST)
	public String categoryEditSave(final Model model,
			final HttpServletRequest request,
			@ModelAttribute("category") Category category) throws IOException{

		categoryService.saveOrUpdate(category);
		
		return "redirect:/admin/category-list";
	}
}
