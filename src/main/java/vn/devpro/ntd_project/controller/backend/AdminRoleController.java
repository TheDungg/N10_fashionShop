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
import vn.devpro.ntd_project.model.Role;
import vn.devpro.ntd_project.model.User;
import vn.devpro.ntd_project.service.RoleService;
import vn.devpro.ntd_project.service.UserService;


@Controller
public class AdminRoleController extends BaseController {

	//Su dung service de thao tac du lieu voi database
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	//-------------------------role list-----------------------------------
	@RequestMapping(value = "/admin/role-list", method = RequestMethod.GET)
	public String roleList(final Model model) throws IOException{
		//Lay danh sach user tu tbl_user trong database
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		return "backend/role-list";
	}
	
	//-----------------add new role----------------------------------
	@RequestMapping(value = "/admin/role-add", method = RequestMethod.GET)
	public String roleAdd(final Model model) throws IOException{
		//Lay danh sach user tu tbl_user trong database
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		
		
		Role role = new Role();
		role.setCreateDate(new Date());
		model.addAttribute("role", role);
		
		return "backend/role-add";
	}
	
	//-----------------save role to database---------------------
	@RequestMapping(value = "/admin/role-add-save", method = RequestMethod.POST)
	public String roleAddSave(final Model model,
			final HttpServletRequest request,
			@ModelAttribute("role") Role role) throws IOException{

		roleService.saveOrUpdate(role);
		
		return "backend/role-add";
	}
	
	//----------------edit role---------------------
	@RequestMapping(value = "/admin/role-edit/{roleId}", method = RequestMethod.GET)
	public String roleEdit(final Model model,
			@PathVariable("roleId") int roleId //lay category id khi click Edit
			) throws IOException{
		
		//Lay category tu tbl_category trong database
		Role role = roleService.getById(roleId);
		model.addAttribute("role", role);
		
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		
		return "backend/role-edit";
	}
	
	//-----------------save role-edit to database---------------------
	@RequestMapping(value = "/admin/role-edit-save", method = RequestMethod.POST)
	public String roleEditSave(final Model model,
			final HttpServletRequest request,
			@ModelAttribute("role") Role role) throws IOException{

		roleService.saveOrUpdate(role);
		
		return "redirect:/admin/role-list";
	}
}
