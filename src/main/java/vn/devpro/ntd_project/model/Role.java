package vn.devpro.ntd_project.model;

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

import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name = "tbl_role")
public class Role extends BaseModel implements GrantedAuthority {

	@Column(name = "name", length = 300, nullable = false)
	private String name;
	
	@Column(name = "description", length = 500, nullable = true)
	private String description;
	
	//----------------------
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_user_role", joinColumns = @JoinColumn(name = "role_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users = new ArrayList<User>();
	
	//mapping many-to-one
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "create_by")
	private Role roleCreaterole;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "update_by")
	private Role roleUpdaterole;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleCreaterole")
	private Set<Role> roleCreateroles = new HashSet<Role>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleUpdaterole")
	private Set<Role> roleUpdateroles = new HashSet<Role>();
	
	public void addRelationalRoleUser(User user) {
		user.getRoles().add(this);
		users.add(user);
	}
	
	public void removeRelationalRoleUser(User user) {
		user.getRoles().remove(this);
		users.remove(user);
	}

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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Role getRoleCreaterole() {
		return roleCreaterole;
	}

	public void setRoleCreaterole(Role roleCreaterole) {
		this.roleCreaterole = roleCreaterole;
	}

	public Role getRoleUpdaterole() {
		return roleUpdaterole;
	}

	public void setRoleUpdaterole(Role roleUpdaterole) {
		this.roleUpdaterole = roleUpdaterole;
	}

	public Set<Role> getRoleCreateroles() {
		return roleCreateroles;
	}

	public void setRoleCreateroles(Set<Role> roleCreateroles) {
		this.roleCreateroles = roleCreateroles;
	}

	public Set<Role> getRoleUpdateroles() {
		return roleUpdateroles;
	}

	public void setRoleUpdateroles(Set<Role> roleUpdateroles) {
		this.roleUpdateroles = roleUpdateroles;
	}

	public Role(Integer id, Date createDate, Date updateDate, Boolean status, String name, String description,
			List<User> users, Role roleCreaterole, Role roleUpdaterole, Set<Role> roleCreateroles,
			Set<Role> roleUpdateroles) {
		super(id, createDate, updateDate, status);
		this.name = name;
		this.description = description;
		this.users = users;
		this.roleCreaterole = roleCreaterole;
		this.roleUpdaterole = roleUpdaterole;
		this.roleCreateroles = roleCreateroles;
		this.roleUpdateroles = roleUpdateroles;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Integer id, Date createDate, Date updateDate, Boolean status) {
		super(id, createDate, updateDate, status);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getAuthority() {
		// Tra ve ten role
		return this.name;
	}
	
	
}
