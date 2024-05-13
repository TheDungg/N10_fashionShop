package vn.devpro.ntd_project.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import vn.devpro.ntd_project.dto.DuntoConstants;
import vn.devpro.ntd_project.dto.SearchModel;
import vn.devpro.ntd_project.model.Product;
import vn.devpro.ntd_project.model.ProductImage;


@Service
public class ProductService extends BaseService<Product> implements DuntoConstants {

	@Override
	public Class<Product> clazz() {
		return Product.class;
	}
	
	public List<Product> findAllActive(){
		return super.executeNativeSql("SELECT * FROM tbl_product p where status=1");
	}
	
	public List<Product> findProductByCategory(int categoryId){
		return super.executeNativeSql("SELECT * FROM tbl_product WHERE status = 1 AND category_id = " + categoryId);
	}
	
	//hàm kiểm tra file có được upload ko
	public boolean isUploadFile(MultipartFile file) {
		if(file == null || file.getOriginalFilename().isEmpty()) {
			return false;
		}
		return true;
	}
	
	//hàm check danh sách file có upload được không
	public boolean isUploadFile(MultipartFile[] files) {
		if(files == null || files.length == 0) {
			return false;
		}
		return true;
	}
	
	//-----------------save add--------------
	@Transactional
	public Product saveAddProduct(Product product, MultipartFile avatarFile,
			MultipartFile[] imageFiles) throws IOException {
		//lưu avatar file
		if(isUploadFile(avatarFile)) {//có upload file
			//lưu file vào thư mục Product/avatar
			String path = FOLDER_UPLOAD + "Product/Avatar/" + avatarFile.getOriginalFilename();
			File file = new File(path);
			avatarFile.transferTo(file);
			//lưu đường dẫn vào bảng tbl_product
			product.setAvatar("Product/Avatar/" + avatarFile.getOriginalFilename());	
		}
		//Lưu images file
		if(isUploadFile(imageFiles)) {
			for(MultipartFile imageFile : imageFiles) {
				if(isUploadFile(imageFile)) {
					//lưu file vào thư mục Product/Image
					String path = FOLDER_UPLOAD + "Product/Image/" + imageFile.getOriginalFilename();
					File file = new File(path);
					imageFile.transferTo(file);
					//Lưu đường dẫn vào tbl_product_image
					ProductImage productImage = new ProductImage();
					productImage.setTitle(imageFile.getOriginalFilename());
					productImage.setPath("Product/Image/" + imageFile.getOriginalFilename());
					productImage.setStatus(Boolean.TRUE);
					productImage.setCreateDate(new Date());
					product.addRelationalProductImage(productImage); //lưu sang bảng tbl_product_image
				}
			}
		}
		return super.saveOrUpdate(product);
	}
	
	//---------------save edit-------------------
	@Transactional
	public Product saveEditProduct(Product product, MultipartFile avatarFile,
			MultipartFile[] imageFiles) throws IOException {
		
		//lấy product trong db
		Product dbProduct = super.getById(product.getId());
		
		//lưu avatar file mới nếu người dùng có upload avatar
		if(isUploadFile(avatarFile)) {//có upload file
			
			//xóa avatar cũ
			String path = FOLDER_UPLOAD + dbProduct.getAvatar();
			File file = new File(path);
			file.delete();														
			
			//lưu file avatar new vào thư mục Product/avatar
			path = FOLDER_UPLOAD + "Product/Avatar/" + avatarFile.getOriginalFilename();
			file = new File(path);
			avatarFile.transferTo(file);
			//lưu đường dẫn vào bảng tbl_product
			product.setAvatar("Product/Avatar/" + avatarFile.getOriginalFilename());	
		}else { //người dùng ko upload avatar mới
			//giữ nguyên avatar cũ
			product.setAvatar(dbProduct.getAvatar());		
		}
		//Lưu images file
		if(isUploadFile(imageFiles)) {
			for(MultipartFile imageFile : imageFiles) {
				if(isUploadFile(imageFile)) {
					//lưu file vào thư mục Product/Image
					String path = FOLDER_UPLOAD + "Product/Image/" + imageFile.getOriginalFilename();
					File file = new File(path);
					imageFile.transferTo(file);
					//Lưu đường dẫn vào tbl_product_image
					ProductImage productImage = new ProductImage();
					productImage.setTitle(imageFile.getOriginalFilename());
					productImage.setPath("Product/Image/" + imageFile.getOriginalFilename());
					productImage.setStatus(Boolean.TRUE);
					productImage.setCreateDate(new Date());
					
					product.addRelationalProductImage(productImage); //lưu sang bảng tbl_product_image
				}
			}
		}
		return super.saveOrUpdate(product);
	}
	

	@Autowired
	private ProductImageService productImageService;

	@Transactional
	public void deleteProductbyId(int productId) {
		// lấy product trong db
		Product product = super.getById(productId);
		//Lấy list ảnh của product trong tbl_product_image
		String sql = "SELECT * FROM tbl_product_image where product_id=" +productId;
		List<ProductImage> productImages = productImageService.executeNativeSql(sql);
		//
		for(ProductImage productImage : productImages) {
			//xoa file trong thu muc Product Image (truoc)
			String path = FOLDER_UPLOAD + productImage.getPath();
			File file = new File(path);
			file.delete();
			
//			product.removeRelationalProductImage(productImage);
		}
		String path = FOLDER_UPLOAD + product.getAvatar();
		File file = new File(path);
		file.delete();
		
		super.deleteById(productId);
		
	}
	
		//----------------------------Search Product-----------------------
		public List<Product> searchProduct(SearchModel productSearch) {
			//tao cau lenh sql
			String sql = "SELECT * FROM tbl_product p where 1=1";
					
			//tim kiem voi status
			if(productSearch.getStatus() != 2) {
				sql += " AND p.status=" + productSearch.getStatus();
			}
			
			//tim kiem voi category
			if(productSearch.getCategoryId() != 0) {
				sql += " AND p.category_id=" + productSearch.getCategoryId();
			}
			
			//tìm kiếm theo keyword
			if(!StringUtils.isEmpty(productSearch.getKeyword())) {
				String keyword = productSearch.getKeyword().toLowerCase();
				
				sql += " AND (LOWER(p.name) like '%" + keyword + "%'" + 
						" OR LOWER(p.short_description) like '%" + keyword + "%'" +
						" OR LOWER(p.seo) like '%" + keyword + "%')";
			}
			
			//tìm kiếm theo date
			if(!StringUtils.isEmpty(productSearch.getBeginDate()) && 
					!StringUtils.isEmpty(productSearch.getEndDate())) {
				
				String beginDate = productSearch.getBeginDate();
				String endDate = productSearch.getEndDate();
				
				sql += " AND p.create_date BETWEEN '" + beginDate + "' AND '" + endDate + "'";
			}
			
			return super.executeNativeSql(sql, productSearch.getCurrentPage(), productSearch.getSizeOfPage());
		}
		
		public List<Product> listProducts(SearchModel searchModel){
			String sql = "SELECT * FROM tbl_product p WHERE status = 1";
			
			if(!StringUtils.isEmpty(searchModel.getKeyword())) {
				String keyword = searchModel.getKeyword().toLowerCase();
				sql += " AND (LOWER(p.name) LIKE '%" + keyword + "%')";
			}
			
			if(searchModel.getPrice() != 0) {
				if(searchModel.getPrice() == 1) {
					sql += " AND p.price BETWEEN 200000 AND 400000";
				}else if(searchModel.getPrice() == 2) {
					sql += " AND p.price BETWEEN 400000 AND 600000";
				}else if(searchModel.getPrice() == 3) {
					sql += " AND p.price BETWEEN 600000 AND 800000";
				}else if(searchModel.getPrice() == 4) {
					sql += " AND p.price BETWEEN 800000 AND 1000000";
				}else {
					sql += " AND p.price > 1000000";
				}
			}
			
			if(searchModel.getCategoryId() != 0) {
				sql += " AND p.category_id = " + searchModel.getCategoryId();
			}
			
			if(searchModel.getPriceSort() != 0) {
				if(searchModel.getPriceSort() == 1) {
					sql += " ORDER BY p.price DESC";
				}else {
					sql += " ORDER BY p.price ASC";
				}
			}
			return super.executeNativeSql(sql);
		}
}
