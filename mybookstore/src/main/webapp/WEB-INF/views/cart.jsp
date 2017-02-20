<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Cart</h1>
					
					<p>All the selected books in your shopping cart</p>
				</div>
			</div>
		</section>
		
		<section class="container" ng-app="cartApp">
		
			<div ng-controller = "cartCtrl" ng-init = "initCartId('${cartId}')">
			
			<div>
				<a class="btn btn-danger pull-left" ng-click="clearCart()"><span class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
				<a href="<spring:url value="/order/${cartId}"/>" class="btn btn-success pull-right" ><span class="glyphicon glyphicon-shopping-cart"></span>Check out</a>
			</div>
			
			<table class="table table-hover">
				<tr>
					<th>Book</th>
					<th>Unit Price</th>
					<th>Quantity</th>
					<th>Total Price</th>
					<th>Action</th>
				</tr>
				
				<tr ng-repeat = "item in cart.cartItems">
					<td>{{item.book.bookName}}</td>
					<td>{{item.book.bookPrice}}</td>
					<td>{{item.quantity}}</td>
					<td>{{item.totalPrice}}</td>
					<td><a href="#" class="label label-danger" ng-click="removeFromCart(item.book.bookId)">
							<span class="glyphicon glyphicon-remove"></span>remove</a></td>
				</tr>
				
				<tr>
					<th></th>
					<th></th>
					<th>Grand Total</th>
					<th>{{calGrandTotal()}}</th>
					<th></th>
				</tr>
			</table>
			
			<a href="<spring:url value="/book/bookList"/>" class="btn btn-primary">Continue Shopping</a>
			
			</div>
		</section>
	</div>
</div>



<script src="<c:url value="/resources/js/Controller.js"/>"></script> 
<%@ include file="/WEB-INF/views/template/footer.jsp"%>  