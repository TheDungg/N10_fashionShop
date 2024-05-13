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
                        <h4>Shopping Cart</h4>
                        <div class="breadcrumb__links">
                            <a href="${classpath}/index">Home</a>
                            <a href="${classpath}/shop">Shop</a>
                            <span>Shopping Cart</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="shopping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach var="item" items="${cart.cartProducts}" varStatus="loop">
	                                <tr>
	                                    <td class="product__cart__item">
	                                        <div class="product__cart__item__pic">
	                                            <img width="90px" height="90px" src="${classpath}/FileUploads/${item.avatar}" alt="">
	                                        </div>
	                                        <div class="product__cart__item__text">
	                                            <h6>${item.productName}</h6>
	                                            
			                                    <h5>
					                            	<span> 
														<fmt:formatNumber value="${item.price}" minFractionDigits="0"></fmt:formatNumber>
														<sup>vnđ</sup>
													</span>
					                            </h5>
	                                            
	                                        </div>
	                                    </td>
	                                    <td class="quantity__item">
	                                        <div class="quantity">
	                                            <span class="input-group-btn">
							                    	<button onclick="updateProductQuantity(${item.productId}, -1)"
													   		value="-" type="button" class="quantity-left-minus btn btn-light btn-number" data-type="minus">
						                       		 	<i class="fa fa-minus"></i>
						                      		</button>	                      
							                    </span>
							               
							                    <strong class=" text-center p-2 mx-1">
							                    	<span id="productQuantity_${item.productId}">${item.quantity}</span>
							                    </strong>
							                    
							                    <span class="input-group-btn">
							                    	<button onclick="updateProductQuantity(${item.productId}, 1)"
															value="+" type="button" class="quantity-right-plus btn btn-light btn-number" data-type="plus" data-field="">
						                        		<i class="fa fa-plus"></i> 
						                     	 	</button>
							                    	                  	              
							                    </span>
	                                        </div>
	                                    </td>
	                                    <td class="cart__price">
		                                    <div class="total-price">
							                    <span class="secondary-font fw-medium">
							                    	<fmt:formatNumber value="${item.price * item.quantity}" minFractionDigits="0" />
							                    	<sup>vnđ</sup>
												</span>
		                  					</div>
	                                    </td>
	                                    <td class="cart__close">
	                                    	<a href="${classpath}/product-cart-delete/${item.productId}">
	                      						<i class="fa fa-close"></i>
	                    					</a>	                                    		
	                                    </td>
	                                </tr>
								</c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="continue__btn">
                                <a href="#">Continue Shopping</a>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="continue__btn update__btn">
                                <a href="#"><i class="fa fa-spinner"></i> Update cart</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="cart__discount">
                        <h6>Discount codes</h6>
                        <form action="#">
                            <input type="text" placeholder="Coupon code">
                            <button type="submit">Apply</button>
                        </form>
                    </div>
                    <div class="cart__total">
                        <h6>Cart total</h6>
                        <ul>
                            <li>Subtotal 
                            	<span class="secondary-font fw-medium">
			                    	<bdi>
			                          <fmt:formatNumber value="${totalCartPrice}"
										minFractionDigits="0"></fmt:formatNumber>
									  <sup>vnđ</sup>
									</bdi>
								</span>
                            </li>
                            <li>Total 
                            	<span class="secondary-font fw-medium">
			                    	<bdi>
			                          <fmt:formatNumber value="${totalCartPrice}"
										minFractionDigits="0"></fmt:formatNumber>
									  <sup>vnđ</sup>
									</bdi>
								</span>
                            </li>
                        </ul>
                        <a href="#gh-info" class="primary-btn">Proceed to checkout</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shopping Cart Section End -->
    
        <!-- Checkout Section Begin -->
    <section id="gh-info" class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <form action="${classpath}/shopping-cart" method="get">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <h6 class="coupon__code"><span class="icon_tag_alt"></span> Have a coupon? <a href="#">Click
                            here</a> to enter your code</h6>
                            <h6 class="checkout__title">Billing Details</h6>

                            <div class="checkout__input">
                                <p>Customer Name<span>*</span></p>
                                <input type="text" id="txtName" name="txtName" placeholder="Your name" value="${user.name}">
                            </div>

                            <div class="checkout__input">
                                <p>Customer Mobile<span>*</span></p>
                                <input type="text" id="txtMobile" name="txtMobile" placeholder="Your phone number" value="${user.mobile}">
                            </div>
                            <div class="checkout__input">
                                <p>Customer Email<span>*</span></p>
                                <input type="email" id="txtEmail" name="txtEmail" placeholder="Your email" value="${user.email}" >
                            </div>
                            <div class="checkout__input">
                                <p>Customer Address<span>*</span></p>
                                <input type="text" id="txtAddress" name="txtAddress" placeholder="Your address" value="${user.address}">
                            </div>

                            <div class="checkout__input">
                                <p>Order notes<span>*</span></p>
                                <input type="text" id="txtMessage" name="txtMessage"
                                placeholder="Notes about your order, e.g. special notes for delivery.">
                            </div>
                            
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="checkout__order">
                                <h4 class="order__title">Your order</h4>

                                <p>Click place order to finish your purchase.</p>
                                <div class="checkout__input__checkbox">
                                    <label for="payment">
                                        Check Payment
                                        <input type="checkbox" id="payment">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                                <div class="checkout__input__checkbox">
                                    <label for="paypal">
                                        Paypal
                                        <input type="checkbox" id="paypal">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                                <button onclick="_placeOrder()" type="submit" class="site-btn"><a href="${classpath}/index">PLACE ORDER</a> </button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <!-- Checkout Section End -->
    
    <!-- footer -->
	<jsp:include page="/WEB-INF/views/frontend/layout/footer.jsp"></jsp:include>
	
			<!--JS-->
	<jsp:include page="/WEB-INF/views/frontend/layout/js.jsp"></jsp:include>
	
	<script type="text/javascript">
		updateProductQuantity = function(_productId, _quantity) {
			let data = {
				productId : _productId, //lay theo id
				quantity : _quantity
			};

			//$ === jQuery
			jQuery.ajax({
				url : "/update-product-quantity",
				type : "POST",
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : "json", //Kieu du lieu tra ve tu controller la json

				success : function(jsonResult) {
					let totalProducts = jsonResult.totalCartProducts; 
					//Viet lai so luong sau khi bam nut -, +
					$("#productQuantity_" + jsonResult.productId).html(jsonResult.newQuantity); 
					location.reload();
				},

				error : function(jqXhr, textStatus, errorMessage) {
					alert("An error occur");
				}
			});
		}
	</script>

	<script type="text/javascript">
		function _placeOrder() {
			//javascript object
			let data = {				
				txtName : jQuery("#txtName").val(),
				txtEmail : jQuery("#txtEmail").val(), //Get by Id
				txtMobile : jQuery("#txtMobile").val(),
				txtAddress : jQuery("#txtAddress").val(),
				txtMessage : jQuery("#txtMessage").val(),
			};
			
			//$ === jQuery
			jQuery.ajax({
				url : "/place-order",
				type : "POST",
				contentType: "application/json",
				data : JSON.stringify(data),
				dataType : "json", //Kieu du lieu tra ve tu controller la json
				
				success : function(jsonResult) {
					alert(jsonResult.code + ": " + jsonResult.message);
					//$("#placeOrderSuccess").html(jsonResult.message);
				},
				
				error : function(jqXhr, textStatus, errorMessage) {
					alert("An error occur");
				}
			});
		}
	</script>
	
	
</html>


