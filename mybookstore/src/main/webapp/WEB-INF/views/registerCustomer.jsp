<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>



<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Register Customer</h1>

			<p class="lead">Please fill in your information below!</p>
		</div>

		<form:form action="${pageContext.request.contextPath}/register"
			method="post" commandName="customer">

		<h3>Basic Info</h3>

			<div class="form-group">
				<label for="name">Name:</label><form:errors path="customerName" cssStyle="color:#ff0000"/>
				<form:input path="customerName" id="name" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="email">Email:</label><span style="color:#ff0000">${emailMsg}</span><form:errors path="customerName" cssStyle="color:#ff0000"/>
				<form:input path="customerEmail" id="email" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="phone">Phone:</label>
				<form:input path="customerPhone" id="phone" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="username">Username:</label><span style="color:#ff0000">${usernameMsg}</span><form:errors path="userName" cssStyle="color:#ff0000"/>
				<form:input path="userName" id="Username" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="password">Password:</label><form:errors path="password" cssStyle="color:#ff0000"/>
				<form:password path="password" id="password" class="form-Control" />
			</div>
			
			<h3>Billing Address</h3>
			
			<div class="form-group">
				<label for="billingStreet">Street Name:</label>
				<form:input path="billingAddress.streetName" id="billingStreet" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="apartmentNumber">Apartment Number:</label>
				<form:input path="billingAddress.apartmentNumber" id="apartmentNumber" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="city">City:</label>
				<form:input path="billingAddress.city" id="city" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="state">State:</label>
				<form:input path="billingAddress.state" id="state" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="country">Country:</label>
				<form:input path="billingAddress.country" id="country" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="zipCode">Zipcode:</label>
				<form:input path="billingAddress.zipCode" id="zipCode" class="form-Control" />
			</div>
			
			<h3>Shipping Address</h3>
			
			<div class="form-group">
				<label for="shippingStreet">Street Name:</label>
				<form:input path="shippingAddress.streetName" id="shippingStreet" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="apartmentNumber">Apartment Number:</label>
				<form:input path="shippingAddress.apartmentNumber" id="apartmentNumber" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="city">City:</label>
				<form:input path="shippingAddress.city" id="city" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="state">State:</label>
				<form:input path="shippingAddress.state" id="state" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="country">Country:</label>
				<form:input path="shippingAddress.country" id="country" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="zipCode">Zipcode:</label>
				<form:input path="shippingAddress.zipCode" id="zipCode" class="form-Control" />
			</div>
			
			<br><br>

			<input type="submit" value="Submit" class="btn btn-success">
			<a href="<c:url value="/"/>"
				class="btn btn-danger">Cancel</a>


		</form:form>

		<%@ include file="/WEB-INF/views/template/footer.jsp"%>