<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!-- Marketing messaging and featurettes
    ================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>All Books</h1>

			<p class="lead">Checkout all the books available now!</p>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-success">
					<th>Photo Thumb</th>
					<th>Book Name</th>
					<th>Category</th>
					<th>Price</th>
					<th></th>
				</tr>
			</thead>

			<c:forEach items="${books}" var="book">

				<tr>
					<td><img src="<c:url value="/resources/images/${book.bookId}.png"/>" alt="image" style="width:100%" /></td>
					<td>${book.bookName}</td>
					<td>${book.bookCategory}</td>
					<td>${book.bookPrice}</td>
					<td><a href="<spring:url value="/book/viewBook/${book.bookId}"/>">
							<span class="glyphicon glyphicon-info-sign"></span></a></td>
				</tr>

			</c:forEach>
		</table>
		
<%@ include file="/WEB-INF/views/template/footer.jsp"%>