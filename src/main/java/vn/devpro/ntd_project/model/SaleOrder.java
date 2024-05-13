package vn.devpro.ntd_project.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "tbl_sale_order")
public class SaleOrder extends BaseModel {

	
	@Column(name = "code", length = 60, nullable = true)
	private String code;
	
	@Column(name = "total", nullable = true)
	private BigDecimal total;
	
	@Column(name = "customer_name", length = 300, nullable = false)
	private String customerName;
	
	@Column(name = "customer_email", length = 120, nullable = true)
	private String customerEmail;
	
	@Column(name = "customer_mobile", length = 120, nullable = true)
	private String customerMobile;
	
	@Column(name = "customer_address", length = 300, nullable = true)
	private String customerAddress;
	
	// Mapping one to many: SaleOrder to sale order product
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "saleOrder")
	private Set<SaleOrderProduct> orderProducts = new HashSet<SaleOrderProduct>();
	
	public void addRelationalSaleOrderProduct(SaleOrderProduct saleOrderProduct) {
		orderProducts.add(saleOrderProduct);
		saleOrderProduct.setSaleOrder(this);;
	}
	
	//mapping many-to-one
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	//------------------------
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

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

	public Set<SaleOrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(Set<SaleOrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public SaleOrder(Integer id, Date createDate, Date updateDate, Boolean status, String code, BigDecimal total,
			String customerName, String customerEmail, String customerMobile, String customerAddress,
			Set<SaleOrderProduct> orderProducts, User user) {
		super(id, createDate, updateDate, status);
		this.code = code;
		this.total = total;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerMobile = customerMobile;
		this.customerAddress = customerAddress;
		this.orderProducts = orderProducts;
		this.user = user;
	}

	public SaleOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaleOrder(Integer id, Date createDate, Date updateDate, Boolean status) {
		super(id, createDate, updateDate, status);
		// TODO Auto-generated constructor stub
	}
	
	
}
