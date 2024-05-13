package vn.devpro.ntd_project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_contact")
public class ContactMod extends BaseModel {
	
	@Column(name = "name", length = 120, nullable = false)
	private String customerName;
	
	@Column(name = "email", length = 200, nullable = true)
	private String customerEmail;
	
	@Column(name = "mobile", length = 60, nullable = true)
	private String customerMobile;
	
	@Column(name = "address", length = 300, nullable = true)
	private String customerAddress;
	
	@Column(name = "message", length = 1200, nullable = true)
	private String customerMessage;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerMessage() {
		return customerMessage;
	}

	public void setCustomerMessage(String customerMessage) {
		this.customerMessage = customerMessage;
	}

	public ContactMod(Integer id, Date createDate, Date updateDate, Boolean status, String customerName,
			String customerEmail, String customerMobile, String customerAddress, String customerMessage) {
		super(id, createDate, updateDate, status);
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerMobile = customerMobile;
		this.customerAddress = customerAddress;
		this.customerMessage = customerMessage;
	}

	public ContactMod() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactMod(Integer id, Date createDate, Date updateDate, Boolean status) {
		super(id, createDate, updateDate, status);
		// TODO Auto-generated constructor stub
	}


	
	
}
