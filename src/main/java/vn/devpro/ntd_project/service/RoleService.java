package vn.devpro.ntd_project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vn.devpro.ntd_project.model.Role;

@Service
public class RoleService extends BaseService<Role> {

	@Override
	public Class<Role> clazz() {
		// TODO Auto-generated method stub
		return Role.class;
	}
	
	@Transactional
	public void deleteRoleById(int id) {
		super.deleteById(id);
	}
	
	@Transactional
	public void inactiveRole(Role role) {
		super.saveOrUpdate(role);
	}
	
	public Role getRoleByName(String name) {
		String sql = "SELECT * FROM tbl_role WHERE name='" + name + "'";
		List<Role> roles = super.executeNativeSql(sql);
		
		if (roles.size() > 0) {
			return roles.get(0);
		}
		else {
			return new Role();
		}
	}
}
