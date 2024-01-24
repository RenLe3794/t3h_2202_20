<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
<jsp:include page="/WEB-INF/jsp/common/head.jsp"></jsp:include>

	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Shopping Cart</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					<c:forEach  items="${cart}" var="c" >
						<tr>
							<td class="cart_product">
								<img src="/image/${c.productEntity.image}" height="120" width="120" alt="">
							</td>
							<td class="cart_description">
								<h4><a href="">${c.productEntity.name}</a></h4>
							</td>
							<td class="cart_price">
								<p>$${c.productEntity.price}</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href=""> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
									<a class="cart_quantity_down" href=""> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">${c.total}</p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href="/cart/delete/${c.userId}/${c.productId}"><i class="fa fa-times"></i></a>
							</td>
							<td><<p style="color: red">${message}</p></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->

	<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>What would you like to do next?</h3>
			</div>
			<div class="row" >
				<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li>Cart Sub Total <span> ${totalMoney} vnd </span></li>
							<li>Shipping Cost <span>Free</span></li>
							<li>Total <span> ${totalMoney} vnd </span></li>
						</ul>

							<a class="btn btn-default check_out" href="/checkout/${userId}/${totalMoney}">Check Out</a>
					</div>
				</div>
			</div>
		</div>
	</section><!--/#do_action-->
</body>
<jsp:include page="/WEB-INF/jsp/common/foot.jsp"></jsp:include>