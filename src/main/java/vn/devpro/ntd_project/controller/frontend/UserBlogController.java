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
import vn.devpro.ntd_project.model.Blog;
import vn.devpro.ntd_project.service.BlogService;

@Controller
public class UserBlogController extends BaseController {

	@Autowired
	private BlogService blogService;
	
	
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public String index(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException{
		
		List<Blog> blogs = blogService.findAllActive();
		model.addAttribute("blogs", blogs);
		
		
		return "frontend/blog";
	}
	
	@RequestMapping(value = "/blog-details/{blogId}", method = RequestMethod.GET)
	public String blogDetails(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, 
			@PathVariable("blogId") int blogId
//			@RequestParam("blog_id") int blog_id
			) throws IOException{
		
		Blog blog = blogService.getById(blogId);
		model.addAttribute("blog", blog);	
		
		List<Blog> blogs = blogService.findAllActive();
		model.addAttribute("blogs", blogs);
		

		return "frontend/blog-details";
	}
	
}
