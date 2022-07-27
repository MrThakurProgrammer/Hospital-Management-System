 <%@page import="entities.User"%>
<%@page import="entities.Doctor"%>
<%@page import="dao.DoctorDao"%>
<%@page import="entities.Appointment"%>
<%@page import="DatabaseConnection.ConnectionProvider"%>
<%@page import="dao.AppointmentDao"%> 
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Page</title>
<%@include file="allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Patient Details</p>
						
						<!--Start JSTL Tags -->
					  <c:if test="${not empty succMsg }">
						<p class="text-center text-success fs-3">${succMsg}</p>
						<c:remove var="succMsg" />
					</c:if> 
					
					<c:if test="${not empty errorMsg }">
						<p class="text-center text-danger fs-3">${errorMsg}</p>
						<c:remove var="errorMsg" />
					</c:if>
						<table class="table">
							<thead>
								<tr>
								<th scope="col">Name</th>
								<th scope="col">Gender</th>
								<th scope="col">Age</th>
								<th scope="col">Appointment Date</th>
								<th scope="col">Email</th>
								<th scope="col">Mob No</th>
								<th scope="col">Diseases</th>
								<th scope="col">Status</th>
								<th scope="col">Action</th>
							</tr>
							</thead>
							<tbody>
								<%
									Doctor d = (Doctor) session.getAttribute("docObj");
									AppointmentDao dao = new AppointmentDao(ConnectionProvider.getConnection());
									List<Appointment> list = dao.getAllAppointmentByDoctorLogin(d.getId());
									for (Appointment ap : list) {
								%>
								<tr>
									<th><%=ap.getName()%></th>
									<td><%=ap.getGender()%></td>
									<td><%=ap.getAge()%></td>
									<td><%=ap.getAppoinDate()%></td>
									<td><%=ap.getEmail()%></td>
									<td><%=ap.getPhNo()%></td>
									<td><%=ap.getDiseases()%></td>
									<td><%=ap.getStatus()%></td>
									<th>
									<%
										if("Pending".equals(ap.getStatus())){%>										
											<a href="comments.jsp?id=<%= ap.getId() %>" class="btn btn-sm btn-success">Comment</a>
										<%}
										else{%>
											<a href="#" class="btn btn-success btn-sm disabled">Comment</a> 
										<%}
									%>
									
									</th>
								</tr>
								<%
								}
								%>
							</tbody> 
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>