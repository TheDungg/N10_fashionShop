package vn.devpro.ntd_project.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.ntd_project.controller.BaseController;
import vn.devpro.ntd_project.dto.DuntoConstants;

@Controller
public class AdminHomeController extends BaseController implements DuntoConstants  {

	//=-----View trang admin home
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String homeAdmin() {
		return "backend/home";
	}
		
	
}
