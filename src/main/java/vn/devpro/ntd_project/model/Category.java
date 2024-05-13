package vn.devpro.ntd_project.model;

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
@Table(name = "tbl_category")
public class Category extends BaseModel {

	
	@Column(name = "name", length = 300, nullable = false)
	private String name;
	
	@Column(name = "description", length = 500, nullable = true)
	private String description;
	
	@Column(name = "seo", length = 1000, nullable = true)
	private String seo;
	
	
	//mapping many-to-one
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "create_by")
	private Category userCreateCategory;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "update_by")
	private Category userUpdateCategory;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateCategory")
	private Set<Category> userCreateCategories = new HashSet<Category>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateCategory")
	private Set<Category> userUpdateCategories = new HashSet<Category>();
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
	private Set<Product> products = new HashSet<Product>();
	
	//mqh 1-n sẽ có đoạn này:
	public void addRelationalProduct(Product product) {
		products.add(product);
		product.setCategory(this);
	}
	
	public void removeRelationalProduct(Product product) {
		products.remove(product);
		product.setCategory(null);
	}
	//-----------------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}



	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Integer id, Date createDate, Date updateDate, Boolean status) {
		super(id, createDate, updateDate, status);
		// TODO Auto-generated constructor stub
	}

	public Category getUserCreateCategory() {
		return userCreateCategory;
	}

	public void setUserCreateCategory(Category userCreateCategory) {
		this.userCreateCategory = userCreateCategory;
	}

	public Category getUserUpdateCategory() {
		return userUpdateCategory;
	}

	public void setUserUpdateCategory(Category userUpdateCategory) {
		this.userUpdateCategory = userUpdateCategory;
	}

	public Set<Category> getUserCreateCategories() {
		return userCreateCategories;
	}

	public void setUserCreateCategories(Set<Category> userCreateCategories) {
		this.userCreateCategories = userCreateCategories;
	}

	public Set<Category> getUserUpdateCategories() {
		return userUpdateCategories;
	}

	public void setUserUpdateCategories(Set<Category> userUpdateCategories) {
		this.userUpdateCategories = userUpdateCategories;
	}

	public Category(Integer id, Date createDate, Date updateDate, Boolean status, String name, String description,
			String seo, Category userCreateCategory, Category userUpdateCategory, Set<Category> userCreateCategories,
			Set<Category> userUpdateCategories, Set<Product> products) {
		super(id, createDate, updateDate, status);
		this.name = name;
		this.description = description;
		this.seo = seo;
		this.userCreateCategory = userCreateCategory;
		this.userUpdateCategory = userUpdateCategory;
		this.userCreateCategories = userCreateCategories;
		this.userUpdateCategories = userUpdateCategories;
		this.products = products;
	}

	
	
}
