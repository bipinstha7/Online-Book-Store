<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!-- Marketing messaging and featurettes
    ================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Customer Mnagement Page</h1>

			<p class="lead">This is the customer management page.</p>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-success">
					<th>Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Username</th>
					<th>Enabled</th>
				</tr>
			</thead>

			<c:forEach items="${customerList}" var="customer">

				<tr>
					<td>${customer.customerName}</td>
					<td>${customer.customerEmail}</td>
					<td>${customer.customerPhone}</td>
					<td>${customer.userName}</td>
					<td>${customer.enabled}</td>
				</tr>

			</c:forEach>
		</table>
		
<%@ include file="/WEB-INF/views/template/footer.jsp"%>