<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Login Page</title>
<!--  All Css Js Link..-->
<%@include file="component/allcss.jsp" %>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>

</head>
<body>

<!-- Navbar...-->
<%@include file="component/navbar.jsp" %>

<div class="container p-5">
	<div class="row">
		<div class="col-md-4 offset-md-4">
			<div class="card paint-card">
				<div class="card-body">
					<p class="fs-4 text-center">Doctor Login</p>
					
					<!--Start JSTL Tags -->
					  <c:if test="${not empty succMsg }">
						<p class="text-center text-success">${succMsg}</p>
						<c:remove var="succMsg" />
					</c:if> 
					
					<c:if test="${not empty errorMsg }">
						<p class="text-center text-danger">${errorMsg}</p>
						<c:remove var="errorMsg" />
					</c:if>
					<!--End JSTL Tags -->
					
					<form action="DoctorLoginServlet" method="post">
						<div class="mb-3">
							<label class="form-label">Email Address:</label>
							<input type="email" required name="Email" class="form-control"/>
						</div>
						<div class="mb-3">
							<label class="form-label">Password:</label>
							<input type="password" required name="Password" class="form-control"/>
						</div>
						<button type="submit" class="btn bg-success text-white col-md-12">Login</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>


</body>
</html>