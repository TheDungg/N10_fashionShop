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

    <!-- CSS Styles -->
	<jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/frontend/layout/css.jsp"></jsp:include>
	
</head>

<body>
	<!-- Header -->
    <jsp:include page="/WEB-INF/views/frontend/layout/header.jsp"></jsp:include>
    
    <!-- Page content -->
    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-blog set-bg" data-setbg="${classpath}/frontend/img/breadcrumb-bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>Our Blog</h2>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Blog Section Begin -->
    <section class="blog spad">
        <div class="container">
            <div class="row">
            	<c:forEach var="product" items="${blogs}" varStatus="loop">
	                <div class="col-lg-4 col-md-6 col-sm-6">
	                    <div class="blog__item">
	                        <div class="blog__item__pic set-bg" data-setbg="${classpath}/FileUploads/${product.avatar}"></div>
	                        <div class="blog__item__text">
	                            <span><img src="layouts/img/icon/calendar.png" alt=""> 16 February 2020</span>
	                            <h5>${product.title}</h5>
	                            <a href="${classpath}/blog-details/${product.id}">Read More</a>
	                        </div>
	                    </div>
	                </div>
				</c:forEach>
            </div>
        </div>
    </section>
    <!-- Blog Section End -->
    
    <!-- footer -->
	<jsp:include page="/WEB-INF/views/frontend/layout/footer.jsp"></jsp:include>
	
		<!--JS-->
	<jsp:include page="/WEB-INF/views/frontend/layout/js.jsp"></jsp:include>
	
</html>








