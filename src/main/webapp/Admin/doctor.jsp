<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<%@page import="entities.Specalist"%>
<%@page import="java.util.*"%>
<%@page import="DatabaseConnection.ConnectionProvider"%>
<%@page import="dao.SpecalistDao"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Page</title>
<!--  All Css Js Link..-->
<%@include file="allcss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Add Doctor</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						
						<form action="../AddDoctorServlet" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> 
								<input type="text" required name="D_Name" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label> 
								<input type="date" required name="D_Dob" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> 
								<input required name="D_Qualification" type="text" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Specialist</label> 
							<select name="D_Specalist" required class="form-control">
								<option>--select--</option>								
								<%
								SpecalistDao dao=new SpecalistDao(ConnectionProvider.getConnection());
								List<Specalist> list = dao.getAllSpecalist();
								for (Specalist s : list) {
								%>
								<option><%= s.getS_name() %></option>
								<%
								}
								%>
								
							</select>
							</div>
							<div class="mb-3">
								<label class="form-label">Email</label> 
								<input type="text" required name="D_Email" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Mob No</label> 
								<input type="text" required name="D_Mobno" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> 
								<input required name="D_Password" type="password" class="form-control">
							</div>

							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>						
		</div>
	</div>
</body>
</html>