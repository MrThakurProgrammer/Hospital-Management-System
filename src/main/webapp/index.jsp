<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
<!--  All Css Js Link..-->
<%@include file="component/allcss.jsp" %>

<style type="text/css">
.point-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>

<!-- Navbar...-->
	<%@include file="component/navbar.jsp" %>

<!-- Carousel -->
<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
  
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3" aria-label="Slide 4"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="4" aria-label="Slide 5"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="img/bg1.jpg" class="d-block w-100" alt="..." height="600px">
    </div>
    <div class="carousel-item">
      <img src="img/bg2.jpg" class="d-block w-100" alt="..." height="600px">
    </div>
    <div class="carousel-item">
      <img src="img/bg3.jpg" class="d-block w-100" alt="..." height="600px">
    </div>
    <div class="carousel-item">
      <img src="img/bg4.jpg" class="d-block w-100" alt="..." height="600px">
    </div>
    <div class="carousel-item">
      <img src="img/bg5.jpg" class="d-block w-100" alt="..." height="600px">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div> 

<!--Key features of our hospital  -->
  <div class="container p-3">
  	<p class="text-center fs-2">Key features of our hospital</p>
	  	<div class="row">
	  		<div class="col-md-8 p-5">
	  			<div class="row">
	  				<div class="col-md-6">
	  					<div class="card point-card">
	  						<div class="card-body">
	  							<p class="fs-5">100% Safety</p>
	  							<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
	  						</div>
	  					</div>
	  				</div>
	  				
	  				<div class="col-md-6 ">
	  					<div class="card point-card">
	  						<div class="card-body">
	  							<p class="fs-5">Clean Environment</p>
	  							<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
	  						</div>
	  					</div>
	  				</div>
	  				
	  				<div class="col-md-6 mt-2">
	  					<div class="card point-card">
	  						<div class="card-body">
	  							<p class="fs-5">Friendly Doctors</p>
	  							<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
	  						</div>
	  					</div>
	  				</div>
	  				
	  				<div class="col-md-6 mt-2">
	  					<div class="card point-card">
	  						<div class="card-body">
	  							<p class="fs-5">Medical Research</p>
	  							<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
	  						</div>
	  					</div>
	  				</div>
	  			</div>
	  		</div>	  		
  			<div class="col-md-4 p-5">
  				<img alt="" src="img/doc1.jpg" />
  			</div>	  		 	  		
	  	</div>
  </div>
 
<!-- Our Teams -->  
<hr>
	<div class="container p-2">
  		<p class="text-center fs-2">Our Teams</p>
  	
	  	<div class="row">
			<div class="col-md-3">
				<div class="card point-card">
					<div class="card-body text-center">
						<img src="img/dp5.jpg" width="230px" height="300px">
						<p class=" fw-bold fs-5">Dr. AK</p>
						<p class="fs-7">(CEO, Chairman)</p>
					</div>
				</div>
			</div>
			
			<div class="col-md-3 ">
				<div class="card point-card">
					<div class="card-body text-center">
					<img alt="" src="img/dp2.jpg" width="230px" height="300px">
						<p class=" fw-bold fs-5">Dr. PK</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>
			
			<div class="col-md-3 ">
				<div class="card point-card">
					<div class="card-body text-center">
					<img alt="" src="img/dp3.jpg" width="230px" height="300px">
						<p class=" fw-bold fs-5">Dr. SK</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>
			
			<div class="col-md-3 ">
				<div class="card point-card">
					<div class="card-body text-center">
					<img alt="" src="img/dp4.jpg" width="230px" height="300px">
						<p class=" fw-bold fs-5">Dr. DK</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>
		</div>
	</div>	  			  		 	  		
 
 <%@include file="component/footer.jsp" %>
</body>
</html>