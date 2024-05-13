package vn.devpro.ntd_project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_sale_order_product")
public class SaleOrderProduct extends BaseModel {

	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	
	@Column(name = "description", length = 500, nullable = true)
	private String description;
	
	//mapping many-to-one
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sale_order_id")
	private SaleOrder saleOrder;
	
	//--------------------
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public SaleOrder getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	public SaleOrderProduct(Integer id, Date createDate, Date updateDate, Boolean status, Integer quantity,
			String description, Product product, SaleOrder saleOrder) {
		super(id, createDate, updateDate, status);
		this.quantity = quantity;
		this.description = description;
		this.product = product;
		this.saleOrder = saleOrder;
	}

	public SaleOrderProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaleOrderProduct(Integer id, Date createDate, Date updateDate, Boolean status) {
		super(id, createDate, updateDate, status);
		// TODO Auto-generated constructor stub
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
	
}
