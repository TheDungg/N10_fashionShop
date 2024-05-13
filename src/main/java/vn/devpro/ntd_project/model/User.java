package vn.devpro.ntd_project.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Entity
@Table(name = "tbl_user")
public class User extends BaseModel implements UserDetails {

	@Column(name = "username", length = 120, nullable = false)
	private String username;
	
	@Column(name = "password", length = 120, nullable = false)
	private String password;
	
	@Column(name = "name", length = 60, nullable = false)
	private String name;
	
	@Column(name = "email", length = 45, nullable = true)
	private String email;
	
	@Column(name = "mobile", length = 45, nullable = true)
	private String mobile;
	
	@Column(name = "address", length = 45, nullable = true)
	private String address;
	
	@Column(name = "description", length = 500, nullable = true)
	private String description;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "users")
	private List<Role> roles = new ArrayList<Role>();
	
	//mapping many-to-one
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "create_by")
	private User userCreateUser;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "update_by")
	private User userUpdateUser;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateUser")
	private Set<User> userCreateUsers = new HashSet<User>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateUser")
	private Set<User> userUpdateUsers = new HashSet<User>();
	
	//mqh n-n sẽ có đoạn này:
	public void addRelationalUserRole(Role role) {
		role.getUsers().add(this);
		roles.add(role);
	}
	
	public void removeRelationalUserRole(Role role) {
		role.getUsers().remove(this);
		roles.remove(role);
	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public User getUserCreateUser() {
		return userCreateUser;
	}

	public void setUserCreateUser(User userCreateUser) {
		this.userCreateUser = userCreateUser;
	}

	public User getUserUpdateUser() {
		return userUpdateUser;
	}

	public void setUserUpdateUser(User userUpdateUser) {
		this.userUpdateUser = userUpdateUser;
	}

	public Set<User> getUserCreateUsers() {
		return userCreateUsers;
	}

	public void setUserCreateUsers(Set<User> userCreateUsers) {
		this.userCreateUsers = userCreateUsers;
	}

	public Set<User> getUserUpdateUsers() {
		return userUpdateUsers;
	}

	public void setUserUpdateUsers(Set<User> userUpdateUsers) {
		this.userUpdateUsers = userUpdateUsers;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, Date createDate, Date updateDate, Boolean status) {
		super(id, createDate, updateDate, status);
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, Date createDate, Date updateDate, Boolean status, String username, String password,
			String name, String email, String mobile, String address, String description,
			List<Role> roles, User userCreateUser, User userUpdateUser,
			Set<User> userCreateUsers, Set<User> userUpdateUsers) {
		super(id, createDate, updateDate, status);
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.description = description;
		this.roles = roles;
		this.userCreateUser = userCreateUser;
		this.userUpdateUser = userUpdateUser;
		this.userCreateUsers = userCreateUsers;
		this.userUpdateUsers = userUpdateUsers;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
