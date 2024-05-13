package vn.devpro.ntd_project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.devpro.ntd_project.model.Category;

@Service
public class CategoryService extends BaseService<Category> {

	@Override
	public Class<Category> clazz() {
		return Category.class;
	}
	
	public List<Category> findAllActive(){
		return super.executeNativeSql("SELECT * FROM tbl_category WHERE status = 1");
	}
}
