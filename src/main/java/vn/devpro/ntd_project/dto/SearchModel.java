package vn.devpro.ntd_project.dto;

public class SearchModel {

	private int categoryId;
	private String keyword;
	private int status;
	private String beginDate;
	private String endDate;
	private int price;
	private int priceSort;
	
	private int sizeOfPage;
	private int currentPage;
	private int totalItems;
	
	
	
	
	public SearchModel(int categoryId, String keyword, int status, String beginDate, String endDate, int price,
			int priceSort, int sizeOfPage, int currentPage, int totalItems) {
		super();
		this.categoryId = categoryId;
		this.keyword = keyword;
		this.status = status;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.price = price;
		this.priceSort = priceSort;
		this.sizeOfPage = sizeOfPage;
		this.currentPage = currentPage;
		this.totalItems = totalItems;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPriceSort() {
		return priceSort;
	}
	public void setPriceSort(int priceSort) {
		this.priceSort = priceSort;
	}

	public int getSizeOfPage() {
		return sizeOfPage;
	}
	public void setSizeOfPage(int sizeOfPage) {
		this.sizeOfPage = sizeOfPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public SearchModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
