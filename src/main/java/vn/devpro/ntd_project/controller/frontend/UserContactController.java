package vn.devpro.ntd_project.controller.frontend;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.ntd_project.controller.BaseController;
import vn.devpro.ntd_project.dto.Contact;
import vn.devpro.ntd_project.dto.DuntoConstants;
import vn.devpro.ntd_project.model.ContactMod;
import vn.devpro.ntd_project.service.ContactService;



@Controller
public class UserContactController extends BaseController implements DuntoConstants {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException{
		return "frontend/contact";
	}
	
	//--------------contact submit-------------
	@RequestMapping(value = "/contact-submit", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> contactSubmit(
			final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@RequestBody Contact customer)throws IOException{
		
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		
		//ktr thong tin bat buoc
		if(customer.getTxtName().isEmpty()) {
			jsonResult.put("code", 100);
			jsonResult.put("message", "ban chua nhap ho ten");
		}else if(customer.getTxtEmail().isEmpty()) {
			jsonResult.put("code", 101);
			jsonResult.put("message", "ban chua nhap email");
		}else {
			
					//tao list contact
					ContactMod contactMod = new ContactMod();
					contactMod.setCustomerName(customer.getTxtName());
					contactMod.setCustomerEmail(customer.getTxtEmail());
					contactMod.setCreateDate(new Date());
					contactMod.setStatus(false);
					contactMod.setCustomerMessage(customer.getTxtMessage());
					

					//luu contact vao tbl_contact
					contactService.saveOrUpdate(contactMod);
					
					
					jsonResult.put("code", 200);
					jsonResult.put("message", "Ban da submit thanh cong!");
					
					
			
		}
		return ResponseEntity.ok(jsonResult);
	}
	
//	@RequestMapping(value = "/contact-send", method = RequestMethod.POST)
//	public String contactSend(final Model model,
//			final HttpServletRequest request,
//			final HttpServletResponse response) throws IOException{
//		
//		Contact contact = new Contact();
//		
//		
//		contact.setTxtName(request.getParameter("txtName")); //Lấy dữ liệu từ form 
//		System.out.println("Name = " + contact.getTxtName());
//		
//		
//		return "frontend/contact/contact";
//	}
//	
//	@RequestMapping(value = "/contact-edit", method = RequestMethod.GET)
//	public String contactEdit(final Model model,
//			final HttpServletRequest request,
//			final HttpServletResponse response) throws IOException{
//		
//		Contact contact = new Contact("Ngoc Nguyen", "Ngocnv@abc.com", "0983734530", 
//				"Cau Giay-Ha Noi", "xin doi lai chuot quang");
//		
//		model.addAttribute("contact", contact); //Đẩy dữ liệu sang form 
//		return "frontend/contact/contact-edit";
//	}
//	
//	@RequestMapping(value = "/contact-edit-save", method = RequestMethod.POST)
//	public ResponseEntity<Map<String, Object>> contactEditNotify(final Model model,
//			final HttpServletRequest request,
//			final HttpServletResponse response,
//			final @RequestBody Contact contact //Lấy dữ liệu từ hàm ajax
//			) throws IOException{ 
//		Map<String, Object> jsonResult = new HashMap<String, Object>();
//		jsonResult.put("code", 404);
//		jsonResult.put("message", "Thông tin quý khách '" + contact.getTxtName()+ "' đã được lưu");
//		
//		return ResponseEntity.ok(jsonResult);
//	}
//	
	
	/////////////////////
//	@RequestMapping(value = "/contact-sf", method = RequestMethod.GET)
//	public String contactSf(final Model model,
//			final HttpServletRequest request,
//			final HttpServletResponse response) throws IOException{
//		
//		Contact contact = new Contact();
//		model.addAttribute("contact", contact); //Đẩy dữ liệu sang form (views)
//		
//		return "frontend/contact/contact-sf";
//	}
//	
//	@RequestMapping(value = "/contact-sf-send", method = RequestMethod.POST)
//	public String contactSfSend(final Model model,
//			final HttpServletRequest request,
//			final HttpServletResponse response,
//			@ModelAttribute("contact") Contact contact) throws IOException{
//		
//
////		System.out.println("Name = " + contact.getTxtName());
//		
//		return "frontend/contact/contact-sf";
//	}
	
	
//	
//	@RequestMapping(value = "/contact-list", method = RequestMethod.POST)
//	public String contactSfSend(final Model model,
//			final HttpServletRequest request,
//			final HttpServletResponse response,
//			@ModelAttribute("contact") Contact contact,
//			@RequestParam("contactFile") MultipartFile contactFile //lay file upload tu form
//			) throws IOException{
//		
//		//lưu file upload vào thư mục
//		if(contactFile != null && !contactFile.getOriginalFilename().isEmpty()) {
//			String path = FOLDER_UPLOAD + "ContactFiles/" + contactFile.getOriginalFilename();
//			File fileUpload = new File(path);
//			contactFile.transferTo(fileUpload); //luu file vao thu muc ContactFiles
//			//TODO: Luu duong dan cua file vao database
//		}
//		
//		model.addAttribute("contact", contact);
//		model.addAttribute("filename", contactFile.getOriginalFilename());
//		return "frontend/contact/contact-list";
//	}
//	
//	@RequestMapping(value = "/contact-sf-edit", method = RequestMethod.GET)
//	public String contactSfEdit(final Model model,
//			final HttpServletRequest request,
//			final HttpServletResponse response) throws IOException{
//		
//		Contact contact = new Contact("Ngoc Nguyen", "Ngocnv@abc.com", "0983734530", 
//				"Cau Giay-Ha Noi", "xin doi lai chuot quang");
//		
//		model.addAttribute("contact", contact);
//		
//		return "frontend/contact/contact-sf-edit";
//	}
//	
//	@RequestMapping(value = "/contact-sf-edit-save", method = RequestMethod.POST)
//	public ResponseEntity<Map<String, Object>> contactSfEditNotify(final Model model,
//			final HttpServletRequest request,
//			final HttpServletResponse response,
//			final @RequestBody Contact contact //Lấy dữ liệu từ hàm ajax
//			) throws IOException{ 
//		Map<String, Object> jsonResult = new HashMap<String, Object>();
//		jsonResult.put("code", 404);
//		jsonResult.put("message", "Thông tin quý khách '" + contact.getTxtName()+ "' đã được lưu");
//		
//		return ResponseEntity.ok(jsonResult);
//	}
//	
//	
}
