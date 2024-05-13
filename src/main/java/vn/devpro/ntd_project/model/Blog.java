package vn.devpro.ntd_project.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name = "tbl_blog")
public class Blog extends BaseModel {

	@Column(name = "title", length = 120, nullable = false)
	private String title;
	
	@Column(name = "avatar", length = 200, nullable = true)
	private String avatar;
	
	@Column(name = "image1", length = 200, nullable = true)
	private String image1;
	
	@Column(name = "caption", length = 500, nullable = true)
	private String caption;
	
	@Column(name = "description", length = 3000, nullable = true)
	private String description;
	
		

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blog(Integer id, Date createDate, Date updateDate, Boolean status, String title, String avatar,
			String caption, String description) {
		super(id, createDate, updateDate, status);
		this.title = title;
		this.avatar = avatar;
		this.caption = caption;
		this.description = description;
	}
	

	public Blog(Integer id, Date createDate, Date updateDate, Boolean status, String image1) {
		super(id, createDate, updateDate, status);
		this.image1 = image1;
	}

	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Blog(Integer id, Date createDate, Date updateDate, Boolean status) {
		super(id, createDate, updateDate, status);
		// TODO Auto-generated constructor stub
	}
	
	
}
