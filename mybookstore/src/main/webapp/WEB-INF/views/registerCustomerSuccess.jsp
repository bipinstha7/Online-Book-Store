
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Customer registered successfully!!!</h1>
				</div>
			</div>
		</section>

		<section class="container">
			<p>
				<a href="<c:url value="book/bookList"/>" class="btn btn-primary">Books</a>
			</p>
	</div>
	</section>
</div>
</div>



<script src="<c:url value="/resources/js/Controller.js"/>"></script>
<%@ include file="/WEB-INF/views/template/footer.jsp"%>
