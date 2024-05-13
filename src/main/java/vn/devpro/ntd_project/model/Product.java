package vn.devpro.ntd_project.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_product")
public class Product extends BaseModel {

	@Column(name = "name", length = 300, nullable = false)
	private String name;
	@Column(name = "avatar", length = 300, nullable = true)
	private String avatar;
	@Column(name = "price", nullable = true)
	private BigDecimal price;
	@Column(name = "sale_price", nullable = true)
	private BigDecimal sale_price;
	@Column(name = "is_hot", nullable = true)
	private Boolean is_hot = Boolean.FALSE;
	@Column(name = "short_description", length = 500, nullable = true)
	private String short_description;
	@Column(name = "detail_description", length = 300, nullable = true)
	private String detail_description;
	@Column(name = "seo", length = 1000, nullable = true)
	private String seo;

//	--------Mapping many-to-one: product-to-category-------------------------------------------------------------------
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
	@JoinColumn(name = "category_id")
	private Category category;
//	, insertable = false, updatable = false
	//mapping many-to-one
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "create_by")
	private Product userCreateProduct;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "update_by")
	private Product userUpdateProduct;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateProduct")
	private Set<Product> userCreateProducts = new HashSet<Product>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateProduct")
	private Set<Product> userUpdateProducts = new HashSet<Product>();

// 	Mapping one t0 many : product to sale-order-product	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
//	private Set<SaleOrderProduct> orderProducts = new HashSet<SaleOrderProduct>();

//  Mapping one-to-many : product to product-image
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	private Set<ProductImage> productimages = new HashSet<ProductImage>();
	
	public void addRelationalProductImage(ProductImage productImage) {
		productimages.add(productImage);
		productImage.setProduct(this);
	}
	
	public void removeRelationalProductImage(ProductImage productImage) {
		productimages.remove(productImage);
		productImage.setProduct(null);
	}
	

	

	
//	public Set<SaleOrderProduct> getOrderProducts() {
//		return orderProducts;
//	}

//	public void setOrderProducts(Set<SaleOrderProduct> orderProducts) {
//		this.orderProducts = orderProducts;
//	}

	public Set<ProductImage> getProductimages() {
		return productimages;
	}

	public void setProductimages(Set<ProductImage> productimages) {
		this.productimages = productimages;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSale_price() {
		return sale_price;
	}

	public void setSale_price(BigDecimal sale_price) {
		this.sale_price = sale_price;
	}

	public Boolean getIs_hot() {
		return is_hot;
	}

	public void setIs_hot(Boolean is_hot) {
		this.is_hot = is_hot;
	}

	

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getDetail_description() {
		return detail_description;
	}

	public void setDetail_description(String detail_description) {
		this.detail_description = detail_description;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, Date createDate, Date updateDate, Boolean status) {
		super(id, createDate, updateDate, status);
		// TODO Auto-generated constructor stub
	}



	public Product getUserCreateProduct() {
		return userCreateProduct;
	}

	public void setUserCreateProduct(Product userCreateProduct) {
		this.userCreateProduct = userCreateProduct;
	}

	public Product getUserUpdateProduct() {
		return userUpdateProduct;
	}

	public void setUserUpdateProduct(Product userUpdateProduct) {
		this.userUpdateProduct = userUpdateProduct;
	}

	public Set<Product> getUserCreateProducts() {
		return userCreateProducts;
	}

	public void setUserCreateProducts(Set<Product> userCreateProducts) {
		this.userCreateProducts = userCreateProducts;
	}

	public Set<Product> getUserUpdateProducts() {
		return userUpdateProducts;
	}

	public void setUserUpdateProducts(Set<Product> userUpdateProducts) {
		this.userUpdateProducts = userUpdateProducts;
	}

	public Product(Integer id, Date createDate, Date updateDate, Boolean status, String name, String avatar,
			BigDecimal price, BigDecimal sale_price, Boolean is_hot, String short_description,
			String detail_description, String seo, Category category, Product userCreateProduct,
			Product userUpdateProduct, Set<Product> userCreateProducts, Set<Product> userUpdateProducts,
//			Set<SaleOrderProduct> orderProducts, 
			Set<ProductImage> productimages) {
		super(id, createDate, updateDate, status);
		this.name = name;
		this.avatar = avatar;
		this.price = price;
		this.sale_price = sale_price;
		this.is_hot = is_hot;
		this.short_description = short_description;
		this.detail_description = detail_description;
		this.seo = seo;
		this.category = category;
		this.userCreateProduct = userCreateProduct;
		this.userUpdateProduct = userUpdateProduct;
		this.userCreateProducts = userCreateProducts;
		this.userUpdateProducts = userUpdateProducts;
//		this.orderProducts = orderProducts;
		this.productimages = productimages;
	}
	

}
