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
    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="hero__slider owl-carousel">
            <div class="hero__items set-bg" data-setbg="${classpath}/frontend/img/hero/hero-1.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-5 col-lg-7 col-md-8">
                            <div class="hero__text">
                                <h6>Summer Collection</h6>
                                <h2>Fall - Winter Collections 2030</h2>
                                <p>A specialist label creating luxury essentials. Ethically crafted with an unwavering
                                commitment to exceptional quality.</p>
                                <a href="#" class="primary-btn">Shop now <span class="arrow_right"></span></a>
                                <div class="hero__social">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-pinterest"></i></a>
                                    <a href="#"><i class="fa fa-instagram"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="hero__items set-bg" data-setbg="${classpath}/frontend/img/hero/hero-2.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-5 col-lg-7 col-md-8">
                            <div class="hero__text">
                                <h6>Summer Collection</h6>
                                <h2>Fall - Winter Collections 2030</h2>
                                <p>A specialist label creating luxury essentials. Ethically crafted with an unwavering
                                commitment to exceptional quality.</p>
                                <a href="#" class="primary-btn">Shop now <span class="arrow_right"></span></a>
                                <div class="hero__social">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-pinterest"></i></a>
                                    <a href="#"><i class="fa fa-instagram"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Banner Section Begin -->
    <section class="banner spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-7 offset-lg-4">
                    <div class="banner__item">
                        <div class="banner__item__pic">
                            <img src="${classpath}/frontend/img/banner/banner-1.jpg" alt="">
                        </div>
                        <div class="banner__item__text">
                            <h2>Clothing Collections 2030</h2>
                            <a href="#">Shop now</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5">
                    <div class="banner__item banner__item--middle">
                        <div class="banner__item__pic">
                            <img src="${classpath}/frontend/img/banner/banner-2.jpg" alt="">
                        </div>
                        <div class="banner__item__text">
                            <h2>Accessories</h2>
                            <a href="#">Shop now</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-7">
                    <div class="banner__item banner__item--last">
                        <div class="banner__item__pic">
                            <img src="${classpath}/frontend/img/banner/banner-3.jpg" alt="">
                        </div>
                        <div class="banner__item__text">
                            <h2>Shoes Spring 2030</h2>
                            <a href="#">Shop now</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Banner Section End -->

    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <ul class="filter__controls">
                        <li class="active" data-filter="*">Best Sellers</li>
                        <li data-filter=".new-arrivals">New Arrivals</li>
                        <li data-filter=".hot-sales">Hot Sales</li>
                    </ul>
                </div>
            </div>
            <div class="row product__filter">
            	<c:forEach items="${products}" var="product">
	                <div class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix new-arrivals">
	                    <div class="product__item">
	                        <div class="product__item__pic set-bg" data-setbg="${classpath}/FileUploads/${product.avatar}">
	                            <span class="label">New</span>
	                            <ul class="product__hover">
	                                <li><a href="#"><img src="${classpath}/frontend/img/icon/heart.png" alt=""></a></li>
	                                <li><a href="#"><img src="${classpath}/frontend/img/icon/compare.png" alt=""> <span>Compare</span></a></li>
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
	                                <label for="pc-1">
	                                    <input type="radio" id="pc-1">
	                                </label>
	                                <label class="active black" for="pc-2">
	                                    <input type="radio" id="pc-2">
	                                </label>
	                                <label class="grey" for="pc-3">
	                                    <input type="radio" id="pc-3">
	                                </label>
	                            </div>
	                        </div>
	                    </div>
	                </div>
				</c:forEach>
            </div>
        </div>
    </section>
    <!-- Product Section End -->

    <!-- Categories Section Begin -->
    <section class="categories spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="categories__text">
                        <h2>Clothings Hot <br /> <span>Shoe Collection</span> <br /> Accessories</h2>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="categories__hot__deal">
                        <img src="${classpath}/frontend/img/product-sale.png" alt="">
                        <div class="hot__deal__sticker">
                            <span>Sale Of</span>
                            <h5>$29.99</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 offset-lg-1">
                    <div class="categories__deal__countdown">
                        <span>Deal Of The Week</span>
                        <h2>Multi-pocket Chest Bag Black</h2>
                        <div class="categories__deal__countdown__timer" id="countdown">
                            <div class="cd-item">
                                <span>3</span>
                                <p>Days</p>
                            </div>
                            <div class="cd-item">
                                <span>1</span>
                                <p>Hours</p>
                            </div>
                            <div class="cd-item">
                                <span>50</span>
                                <p>Minutes</p>
                            </div>
                            <div class="cd-item">
                                <span>18</span>
                                <p>Seconds</p>
                            </div>
                        </div>
                        <a href="#" class="primary-btn">Shop now</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Categories Section End -->

    <!-- Instagram Section Begin -->
    <section class="instagram spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="instagram__pic">
                        <div class="instagram__pic__item set-bg" data-setbg="${classpath}/frontend/img/instagram/instagram-1.jpg"></div>
                        <div class="instagram__pic__item set-bg" data-setbg="${classpath}/frontend/img/instagram/instagram-2.jpg"></div>
                        <div class="instagram__pic__item set-bg" data-setbg="${classpath}/frontend/img/instagram/instagram-3.jpg"></div>
                        <div class="instagram__pic__item set-bg" data-setbg="${classpath}/frontend/img/instagram/instagram-4.jpg"></div>
                        <div class="instagram__pic__item set-bg" data-setbg="${classpath}/frontend/img/instagram/instagram-5.jpg"></div>
                        <div class="instagram__pic__item set-bg" data-setbg="${classpath}/frontend/img/instagram/instagram-6.jpg"></div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="instagram__text">
                        <h2>Instagram</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
                        labore et dolore magna aliqua.</p>
                        <h3>#Male_Fashion</h3>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Instagram Section End -->

    <!-- Latest Blog Section Begin -->
    <section class="latest spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <span>Latest News</span>
                        <h2>Fashion New Trends</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-6">
                    <div class="blog__item">
                        <div class="blog__item__pic set-bg" data-setbg="${classpath}/frontend/img/blog/blog-1.jpg"></div>
                        <div class="blog__item__text">
                            <span><img src="${classpath}/frontend/img/icon/calendar.png" alt=""> 16 February 2020</span>
                            <h5>What Curling Irons Are The Best Ones</h5>
                            <a href="#">Read More</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6">
                    <div class="blog__item">
                        <div class="blog__item__pic set-bg" data-setbg="${classpath}/frontend/img/blog/blog-2.jpg"></div>
                        <div class="blog__item__text">
                            <span><img src="${classpath}/frontend/img/icon/calendar.png" alt=""> 21 February 2020</span>
                            <h5>Eternity Bands Do Last Forever</h5>
                            <a href="#">Read More</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6">
                    <div class="blog__item">
                        <div class="blog__item__pic set-bg" data-setbg="${classpath}/frontend/img/blog/blog-3.jpg"></div>
                        <div class="blog__item__text">
                            <span><img src="${classpath}/frontend/img/icon/calendar.png" alt=""> 28 February 2020</span>
                            <h5>The Health Benefits Of Sunglasses</h5>
                            <a href="#">Read More</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Latest Blog Section End -->
    
    <!-- footer -->
	<jsp:include page="/WEB-INF/views/frontend/layout/footer.jsp"></jsp:include>
	
	<!--JS-->
	<jsp:include page="/WEB-INF/views/frontend/layout/js.jsp"></jsp:include>
	
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


