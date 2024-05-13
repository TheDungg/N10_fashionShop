<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${title}</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
    rel="stylesheet">

	<jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/frontend/layout/css.jsp"></jsp:include>
</head>

<body>
	<!-- Header -->
    <jsp:include page="/WEB-INF/views/frontend/layout/header.jsp"></jsp:include>
    
    <!-- Page content -->
    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__text">
                        <h4>Shop</h4>
                        <div class="breadcrumb__links">
                            <a href="${classpath}/index">Home</a>
                            <span>Shop</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shop Section Begin -->
    <section class="shop spad">
    	<form action="${classpath}/shop" method="get">
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-3">
	                    <div class="shop__sidebar">
	                        <div class="shop__sidebar__search">
	                            <form>
	                                <input type="text" id="keyword" name="keyword" placeholder="Search...">
	                                <button type="submit" id="btnSearch" name="btnSearch" class="icon_search"><span ></span></button>
	                            </form>	            
	                        </div>
	                        
	                        <div class="shop__sidebar__accordion">
	                            <div class="accordion" id="accordionExample">
	                                <div class="card">
	                                    <div class="card-heading">
	                                        <a data-toggle="collapse" data-target="#collapseOne">Categories</a>
	                                    </div>
	                                    <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
	                                        <div class="card-body">
	                                            <div class="shop__sidebar__categories">
	                                                <ul class="nice-scroll">
	                                                    <li><a href="#">Men (20)</a></li>
	                                                    <li><a href="#">Women (20)</a></li>
	                                                    <li><a href="#">Bags (20)</a></li>
	                                                    <li><a href="#">Clothing (20)</a></li>
	                                                    <li><a href="#">Shoes (20)</a></li>
	                                                    <li><a href="#">Accessories (20)</a></li>
	                                                    <li><a href="#">Kids (20)</a></li>
	                                                    <li><a href="#">Kids (20)</a></li>
	                                                    <li><a href="#">Kids (20)</a></li>
	                                                </ul>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	                                
	                                <div class="card">
	                                    <div class="card-heading">
	                                        <a data-toggle="collapse" data-target="#collapseThree">Filter Price</a>
	                                    </div>
	                                    <div id="collapseThree" class="collapse show" data-parent="#accordionExample">
	                                        <div class="card-body">
	                                            <div class="shop__sidebar__price">
	                                                <ul>
													    <li><input type="radio" name="price" id="price_0"
															value="0"> <label for="price_0">Tất cả</label></li>
														<li class="tags-item"><input type="radio" name="price" id="price_1"
															value="1"> <label for="price_1">200.000đ - 400.000đ</label></li>
														<li class="tags-item"><input type="radio" name="price" id="price_2"
															value="2"> <label for="price_2">400.000đ -
																600.000đ</label></li>
														<li class="tags-item"><input type="radio" name="price" id="price_3"
															value="3"> <label for="price_3">600.000đ -
																800.000đ</label></li>
														<li class="tags-item"><input type="radio" name="price" id="price_4"
															value="4"> <label for="price_4">800.000đ -
																1.000.000đ</label></li>
														<li class="tags-item"><input type="radio" name="price" id="price_5"
															value="5"> <label for="price_5">
																1.000.000đ +</label></li>
	                                                </ul>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	
	                                <div class="card">
	                                    <div class="card-heading">
	                                        <a data-toggle="collapse" data-target="#collapseSix">Tags</a>
	                                    </div>
	                                    <div id="collapseSix" class="collapse show" data-parent="#accordionExample">
	                                        <div class="card-body">
	                                            <div class="shop__sidebar__tags">
	                                                <a href="#">Product</a>
	                                                <a href="#">Bags</a>
	                                                <a href="#">Shoes</a>
	                                                <a href="#">Fashio</a>
	                                                <a href="#">Clothing</a>
	                                                <a href="#">Hats</a>
	                                                <a href="#">Accessories</a>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-lg-9">
	                    <div class="shop__product__option">
	                        <div class="row">
	                            <div class="col-lg-6 col-md-6 col-sm-6">
	                                <div class="shop__product__option__left">
	                                    <p>Showing 1–12 of 126 results</p>
	                                </div>
	                            </div>
	                            <div class="col-lg-6 col-md-6 col-sm-6">
	                                <div class="shop__product__option__right">
	                                    <p>Sort by Price:</p>
	                                    <select id="priceSort" name="priceSort">
	                                        <option value="0">All</option>
	                                        <option value="1">High to Low</option>
	                                        <option value="2">Low to High</option>
	                                    </select>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="row">
	                    	<c:forEach var="product" items="${products}" varStatus="loop">
		                        <div class="col-lg-4 col-md-6 col-sm-6">
		                            <div class="product__item">
		                                <div class="product__item__pic set-bg" data-setbg="${classpath}/FileUploads/${product.avatar}">
		                                    <ul class="product__hover">
		                                        <li><a href="#"><img src="${classpath}/frontend/img/icon/heart.png" alt=""></a></li>
		                                        <li><a href="#"><img src="${classpath}/frontend/img/icon/compare.png" alt=""> <span>Compare</span></a>
		                                        </li>
		                                        <li><a href="${classpath}/shop-details/${product.id}"><img src="${classpath}/frontend/img/icon/search.png" alt=""></a></li>
		                                    </ul>
		                                </div>
		                                <div class="product__item__text">
		                                    <h6>${product.name}</h6>
		                                    <a onclick="addToCart(${product.id}, 1, '${product.name}')" class="add-cart">+ Add To Cart</a>
		                                    <div class="rating">
		                                        <i class="fa fa-star-o"></i>
		                                        <i class="fa fa-star-o"></i>
		                                        <i class="fa fa-star-o"></i>
		                                        <i class="fa fa-star-o"></i>
		                                        <i class="fa fa-star-o"></i>
		                                    </div>
		                                    
				                            <h5>
				                            	<span> 
													<fmt:formatNumber value="${product.price}" minFractionDigits="0"></fmt:formatNumber>
													<sup>vnđ</sup>
												</span>
				                            </h5>	                                    
		                                    <div class="product__color__select">
		                                        <label for="pc-4">
		                                            <input type="radio" id="pc-4">
		                                        </label>
		                                        <label class="active black" for="pc-5">
		                                            <input type="radio" id="pc-5">
		                                        </label>
		                                        <label class="grey" for="pc-6">
		                                            <input type="radio" id="pc-6">
		                                        </label>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
							</c:forEach>
	                    </div>
	                    <div class="row">
	                        <div class="col-lg-12">
	                            <div class="product__pagination">
	                                <a class="active" href="#">1</a>
	                                <a href="#">2</a>
	                                <a href="#">3</a>
	                                <span>...</span>
	                                <a href="#">21</a>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
    	
    	</form>
    </section>
    <!-- Shop Section End -->
    
    <!-- footer -->
	<jsp:include page="/WEB-INF/views/frontend/layout/footer.jsp"></jsp:include>
	
		<!--JS-->
	<jsp:include page="/WEB-INF/views/frontend/layout/js.jsp"></jsp:include>
	
	
	<script type="text/javascript">
		$( document ).ready(function() {
			//Dat gia tri cua status ung voi dieu kien search truoc do
			$("#status").val(${productSearch.status});
			$("#categoryId").val(${productSearch.categoryId});
			$("#priceSort").val(${productSearch.priceSort});
			$("#price_" + ${productSearch.price}).prop("checked", true);
			$("#category_" + ${productSearch.categoryId}).prop("checked", true);
			$("#paging").pagination({
				currentPage: ${productSearch.currentPage}, //Trang hien tai
				items: ${productSearch.totalItems}, //Tong so san pham (total products)
				itemsOnPage: ${productSearch.sizeOfPage},
				cssStyle: 'light-theme',
				onPageClick: function(pageNumber, event) {
					$('#page').val(pageNumber);
					$('#btnSearch').trigger('click');
				},
			});
		});
	</script>
	
			<!-- Add to cart -->
	<script type="text/javascript">
		addToCart = function(_productId, _quantity, _productName) {		
			alert("Thêm sản phẩm '" + _productName + "' vào giỏ hàng ");
			let data = {
				productId: _productId, //lay theo id
				quantity: _quantity,
				
			};
				
			//$ === jQuery
			jQuery.ajax({
				url : "/add-to-cart",
				type : "POST",
				contentType: "application/json",
				data : JSON.stringify(data),
				dataType : "json", //Kieu du lieu tra ve tu controller la json
				
				success : function(jsonResult) {
					/* alert(jsonResult.code + ": " + jsonResult.message); */
					let totalProducts = jsonResult.totalCartProducts;
					$("#totalCartProductsId").html(totalProducts);
					location.reload();
				},
				
				error : function(jqXhr, textStatus, errorMessage) {
					alert(jsonResult.code + ': Đã có lỗi xay ra...!')
				},
			});
		}
	</script>
</html>


