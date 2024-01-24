<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="/WEB-INF/jsp/common/head.jsp"></jsp:include>

	

			<div class="container">


			<div class="shopper-informations">
				<div class="row">
					<div class="col-sm-3">
						<div class="shopper-info">
							<p>Shopper Information</p>


						</div>
					</div>
					<div class="col-sm-5 clearfix">
						<div class="bill-to">
							<p>Bill To</p>
							<div class="form-one">
								<form action="/checkout/checkout-form" method="post">

							<input  name="email" placeholder="Email*">
							<input  name="name" placeholder=" Name *">
							<input  name="address" placeholder="Address">
							<input  name="phone" placeholder="Phone *">
							<input  name="userId" value="${userId}" >
							<input  name="money" value="${Money}" >
									<button type="submit" class="btn btn-primary" >Hoàn tất</button>
								</form>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="order-message">
						<p>Shipping Order</p>
						<textarea name="notice"  placeholder="Notes about your order, Special Notes for Delivery" rows="16"></textarea>


						</div>
					</div>					
				</div>
			</div>
			<div class="review-payment">
				<h2>Review & Payment</h2>
			</div>

			
	</section> <!--/#cart_items-->



<jsp:include page="/WEB-INF/jsp/common/foot.jsp"></jsp:include>
</body>
</html>