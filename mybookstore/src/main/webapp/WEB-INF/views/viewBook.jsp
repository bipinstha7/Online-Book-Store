<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>



<!-- Marketing messaging and featurettes
    ================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Book Detail</h1>

			<p class="lead">Here is the detailed information of book!</p>
		</div>

		<div class="container" ng-app="cartApp">
			<div class="row">
				<div class="col-md-5">
					<img src="<c:url value="/resources/images/${book.bookId}.png"/>" alt="image" style="width:100%; height: 300px" />
				</div>

				<div class="col-md-5">
					<h3>${book.bookName}</h3>
					<p>${book.bookDescription}</p>
					<p>
						<strong>Category</strong> : ${book.bookCategory}
					</p>
					<p>
						<strong>Publication</strong> :${book.bookPublication}
					</p>
					<p>
						<strong>Condition</strong> :${book.bookCondition}
					</p>
					<p>
						<strong>InStock</strong> :${book.bookInStock}
					</p>
					<h4><strong>NRs. ${book.bookPrice}</strong></h4>
					
					<br/>
					<c:set var="role" scope="page" value="${param.role}"/>
					<c:set var="url" scope="page" value="/book/bookList" />
					<c:if test="${role=='admin'}">
						<c:set var="url" scope="page" value="/admin/bookInventory"/>
					</c:if>
					
					<p ng-controller="cartCtrl">
						<a href="<c:url value="${url}"/>" class="btn btn-default">Back</a>
						<a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${book.bookId}')"><span class="glyphicon glyphicon-shopping-cart"></span>Order Now</a>
						<a href="<spring:url value="/customer/cart"/>" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
					</p>
				</div>
			</div>

		</div>

		<script src="<c:url value="/resources/js/Controller.js"/>"></script>
		<%@ include file="/WEB-INF/views/template/footer.jsp"%>