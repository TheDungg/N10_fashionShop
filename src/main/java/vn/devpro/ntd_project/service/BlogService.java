package vn.devpro.ntd_project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.devpro.ntd_project.dto.DuntoConstants;
import vn.devpro.ntd_project.model.Blog;


@Service
public class BlogService extends BaseService<Blog> implements DuntoConstants {

	@Override
	public Class<Blog> clazz() {
		// TODO Auto-generated method stub
		return Blog.class;
	}	
	
	public List<Blog> findAllActive(){
		return super.executeNativeSql("SELECT * FROM tbl_blog p where status = 1");
	}
}
