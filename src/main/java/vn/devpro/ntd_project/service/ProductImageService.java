package vn.devpro.ntd_project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.devpro.ntd_project.model.ProductImage;

@Service
public class ProductImageService extends BaseService<ProductImage> {

	@Override
	public Class<ProductImage> clazz() {
		return ProductImage.class;
	}
	
	public List<ProductImage> findAllImageByProduct(int productId){
		return super.executeNativeSql("SELECT * FROM tbl_product_image WHERE product_id = " + productId + " LIMIT 4");
	}
}
