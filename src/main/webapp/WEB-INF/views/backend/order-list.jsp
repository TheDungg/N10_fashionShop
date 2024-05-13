<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- directive của JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="${classpath }/backend/assets/images/favicon.png">
<title>${title }</title>

<!-- variables -->
<jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>

<!-- Custome css resource file -->
<jsp:include page="/WEB-INF/views/backend/layout/css.jsp"></jsp:include>
</head>

<body>


	<!-- End test -->
	<!-- ============================================================== -->
	<!-- Preloader - style you can find in spinners.css -->
	<!-- ============================================================== -->

	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper" data-theme="light" data-layout="vertical"
		data-navbarbg="skin6" data-sidebartype="full"
		data-sidebar-position="fixed" data-header-position="fixed"
		data-boxed-layout="full">

		<!-- Topbar header - style you can find in pages.scss -->
		<jsp:include page="/WEB-INF/views/backend/layout/header.jsp"></jsp:include>
		<!-- End Topbar header -->

		<!-- Left Sidebar - style you can find in sidebar.scss  -->
		<jsp:include page="/WEB-INF/views/backend/layout/left-slide-bar.jsp"></jsp:include>
		<!-- End Left Sidebar - style you can find in sidebar.scss  -->

		<!-- Page wrapper  -->
		<!-- ============================================================== -->
		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<div class="page-breadcrumb">
				<div class="row">
					<div class="col-7 align-self-center">
						<h2
							class="page-title text-truncate text-dark font-weight-medium mb-1">List
							Order</h2>
					</div>
				</div>
			</div>
			<!-- ============================================================== -->
			<!-- End Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- Container fluid  -->
			<!-- ============================================================== -->
			<div class="container-fluid">
				<!-- ============================================================== -->
				<!-- Start Page Content -->
				<!-- ============================================================== -->
				<!-- basic table -->
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<div class="table-responsive">

									<table id="zero_config"
										class="table table-striped table-bordered no-wrap">
										<thead>
											<tr>
												<th scope="col">No.</th>
												<th scope="col">User</th>
												<th scope="col">Code</th>
												<th scope="col">Total</th>
												<th scope="col">Customer</th>
												<th scope="col">Mobile</th>
												<th scope="col">Email</th>
												<th scope="col">Address</th>												
												<th scope="col">Create by</th>
												<th scope="col">Create date</th>
												<th scope="col">Update by</th>
												<th scope="col">Update date</th>
												<th scope="col">Status</th>		

											</tr>
										</thead>
										<tbody>
											<c:forEach var="sale_order" items="${sale_orders }" varStatus="loop">
												<tr>
													<td>${loop.index + 1 }</td>
													<td>${sale_order.user.name }</td>
													<td>${sale_order.code }</td>
													<td>
														<fmt:formatNumber value="${sale_order.total }" minFractionDigits="0"></fmt:formatNumber>
													
													</td>
													<td>${sale_order.customerName }</td>
													<td>${sale_order.customerMobile }</td>
													<td>${sale_order.customerEmail }</td>
													<td>${sale_order.customerAddress }</td>
													
													<td></td>
													<td>
														<fmt:formatDate value="${sale_order.createDate }" pattern="dd-MM-yyyy"/>
													</td>
													<td></td>
													<td></td>
													<td>
														<a href="${classpath }/admin/sale-order-edit/${sale_order.id }" role="button" 
																class="btn btn-primary">Edit</a>
														<a href="${classpath }/admin/sale-order-delete/${sale_order.id }" role="button"
																class="btn btn-secondary">Delete</a>
													</td>
												</tr>
											</c:forEach>

										</tbody>
										<tfoot>
											<tr>
												<th scope="col">No.</th>
												<th scope="col">User</th>
												<th scope="col">Code</th>
												<th scope="col">Total</th>
												<th scope="col">Customer</th>
												<th scope="col">Mobile</th>
												<th scope="col">Email</th>
												<th scope="col">Address</th>												
												<th scope="col">Create by</th>
												<th scope="col">Create date</th>
												<th scope="col">Update by</th>
												<th scope="col">Update date</th>
												<th scope="col">Status</th>												
											</tr>
										</tfoot>
									</table>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- ============================================================== -->
			<!-- End Container fluid  -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- footer -->
			<!-- ============================================================== -->
			<jsp:include page="/WEB-INF/views/backend/layout/footer.jsp"></jsp:include>
			<!-- ============================================================== -->
			<!-- End footer -->
			<!-- ============================================================== -->
		</div>
		<!-- ============================================================== -->
		<!-- End Page wrapper  -->
		<!-- ============================================================== -->
	</div>
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->

	<!-- Slider js: All Jquery-->
	<jsp:include page="/WEB-INF/views/backend/layout/js.jsp"></jsp:include>
</body>

</html>