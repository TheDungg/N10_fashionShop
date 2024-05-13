<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div id="preloder">
    <div class="loader"></div>
</div>

<!-- OffCanvas Menu -->
<div class="offcanvas-menu-overlay"></div>
<div class="offcanvas-menu-wrapper">
    <div class="offcanvas__option">
        <div class="offcanvas__links">
            <a href="${classpath}/login">Sign in</a>
            <a href="#">FAQs</a>
        </div>
        <div class="offcanvas__top__hover">
            <span>USD <i class="arrow_carrot-down"></i></span>
            <ul>
                <li>USD</li>
                <li>EUR</li>
                <li>USD</li>
            </ul>
        </div>
    </div>
    <div class="offcanvas__nav__option">
        <a href="#" class="search-switch"><img src="${classpath}/frontend/img/icon/search.png" alt=""></a>
        <a href="#"><img src="${classpath}/frontend/img/icon/heart.png" alt=""></a>
        <a href="#"><img src="${classpath}/frontend/img/icon/cart.png" alt=""> <span>${totalCartProducts}</span></a>
        <div class="price">
          <bdi>
             <fmt:formatNumber value="${totalCartPrice}"
					minFractionDigits="0"></fmt:formatNumber>
			 <sup>vnđ</sup>
		  </bdi>
        </div>
    </div>
    <div id="mobile-menu-wrap"></div>
    <div class="offcanvas__text">
        <p>Free shipping, 30-day return or refund guarantee.</p>
    </div>
</div>

<!-- Header Section Begin -->
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-7">
                    <div class="header__top__left">
                        <p>Free shipping, 30-day return or refund guarantee.</p>
                    </div>
                </div>
                <div class="col-lg-6 col-md-5">
                    <div class="header__top__right">
                        <div class="header__top__links">
                            <a href="${classpath}/login">Sign in</a>
                            <a href="#">FAQs</a>
                        </div>
                        <div class="header__top__hover">
                            <span>USD<i class="arrow_carrot-down"></i></span>
                            <ul>
                                <li>USD</li>
                                <li>EUR</li>
                                <li>USD</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3">
                <div class="header__logo">
                    <a href="/"><img src="${classpath}/frontend/img/logo.png" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <nav class="header__menu mobile-menu">
                    <ul>
                        <li class="active"><a href="${classpath}/index">Home</a></li>
                        <li><a href="${classpath}/shop">Shop</a></li>
                
                        <li><a href="${classpath}/blog">Blog</a></li>
                        <li><a href="${classpath}/contact">Contacts</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3 col-md-3">
                <div class="header__nav__option">
                    <a href="#" class="search-switch"><img src="${classpath}/frontend/img/icon/search.png" alt=""></a>
                    <a href="#"><img src="${classpath}/frontend/img/icon/heart.png" alt=""></a>
                    <a href="${classpath}/shopping-cart"><img src="${classpath}/frontend/img/icon/cart.png" alt=""> <span>${totalCartProducts}</span></a>
                    <div class="price">
                    	<bdi>
                          <fmt:formatNumber value="${totalCartPrice}"
							minFractionDigits="0"></fmt:formatNumber>
						  <sup>vnđ</sup>
						</bdi>
                    </div>
                </div>
            </div>
        </div>
        <div class="canvas__open"><i class="fa fa-bars"></i></div>
    </div>
</header>
