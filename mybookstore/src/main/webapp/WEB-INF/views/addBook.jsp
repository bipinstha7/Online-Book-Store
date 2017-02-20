<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>



<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Add Book</h1>

			<p class="lead">Fill the below information to add a book!</p>
		</div>

		<form:form action="${pageContext.request.contextPath}/admin/book/addBook"
                   method="post" commandName="book" enctype="multipart/form-data">
			
			<div class="form-group">
				<label for="name">Name:</label> <form:errors path="bookName" cssStyle="color: #ff0000;"/>
				<form:input path="bookName" id="name" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="category">Category:</label>
				<label class="checkbox-inline">
					   <form:radiobutton path="bookCategory" id="category" value="nepali"/>Nepali	
				</label>
				<label class="checkbox-inline">
					   <form:radiobutton path="bookCategory" id="category" value="fiction"/>Fiction	
				</label>
				<label class="checkbox-inline">
					   <form:radiobutton path="bookCategory" id="category" value="nonfiction"/>Non-Fiction	
				</label>
				<label class="checkbox-inline">
					   <form:radiobutton path="bookCategory" id="category" value="biography"/>Biography	
				</label>
				<label class="checkbox-inline">
					   <form:radiobutton path="bookCategory" id="category" value="religion"/>Religion	
				</label>
				<label class="checkbox-inline">
					   <form:radiobutton path="bookCategory" id="category" value="business&economics"/>Business & Economics	
				</label>
			</div>
			<div class="form-group">
				<label for="description">Description:</label>
				<form:textarea path="bookDescription" id="description" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="price">Price:</label> <form:errors path="bookPrice" cssStyle="color: #ff0000;"/>
				<form:input path="bookPrice" id="price" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="publication">Publication:</label>
				<form:input path="bookPublication" id="publication" class="form-Control" />
			</div>
			<div class="form-group">
				<label for="condition">Condition:</label>
				<label class="checkbox-inline">
					   <form:radiobutton path="bookCondition" id="condition" value="new"/>New	
				</label>
				<label class="checkbox-inline">
					   <form:radiobutton path="bookCondition" id="condition" value="used"/>Used	
				</label>
			</div>
			
			<div class="form-group">
				<label for="bookInStock">Book In Stock:</label> <form:errors path="bookInStock" cssStyle="color: #ff0000;"/>
				<form:input path="bookInStock" id="bookInStock" class="form-Control" />
			</div>
			
			<div class="form-group">
				<label class="control-label" for="bookImage">Upload Picture</label>
				<form:input id="bookImage" path="bookImage" type="file" class="form:input-large"/>
			</div>
			
			<br><br>
			
			<input type="submit" value="Submit" class="btn btn-success">
				<a href="<c:url value="/admin/bookInventory"/>" class="btn btn-danger">Cancel</a>
				
			
		</form:form>

		<%@ include file="/WEB-INF/views/template/footer.jsp"%>