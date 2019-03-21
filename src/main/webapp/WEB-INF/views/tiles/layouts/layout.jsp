<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><tiles:insertAttribute name="title" /></title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../../../css/main.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="body-container">

		<!-- Begin header -->
		<div id="header">
			<!-- navBar menu -->
			<nav class="navbar navbar-inverse">
				<div class="container">
					<div class="container">
						<div class="container">
							<div class="container">
								<div class="navbar-header">
									<a class="navbar-brand" href="#">TM Attendance</a>
								</div>
								<ul class="nav navbar-nav">
									<li class="active"><a href="#">Home</a></li>
									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="#">TM Report<span
											class="caret"></span></a>
										<ul class="dropdown-menu">

											<security:authorize access="hasAnyRole('ADMIN', 'FACULTY')">
												<li><a href="/faculty/report/block">Block</a></li>
												<li><a href="/faculty/entry">Entry</a></li>
											</security:authorize>

										<%-- <security:authorize access="hasAnyRole('ADMIN', 'FACULTY')">
											<li><a href="#">Block</a></li>
											<li><a href="#">Entry</a></li>
										</security:authorize> --%>
										
										<security:authorize access="hasRole('STUDENT')">
											<li><a href="/student/attendance">TM Attendance</a></li>
											<li><a href="/student/tmcheckingreport">TM Checks</a></li>
											<li><a href="/student/retreatreport">Retreats</a></li>
										</security:authorize>
										</ul></li>
										
									<security:authorize access="hasRole('ADMIN')">
										<li><a href="/admin/upload">File Upload</a></li>
										<li class="dropdown"><a class="dropdown-toggle"
											data-toggle="dropdown" href="#">Retreat<span
												class="caret"></span></a>
											<ul class="dropdown-menu">
												<li><a href="/admin/retreat">Add</a></li>
												<li><a href="/admin/retreat/update">Update</a></li>
											</ul>
										</li>
										<li class="dropdown"><a class="dropdown-toggle"
											data-toggle="dropdown" href="#">TM Checks<span
												class="caret"></span></a>
											<ul class="dropdown-menu">
												<li><a href="/admin/check">Add</a></li>
												<li><a href="/admin/check/update">Update</a></li>
											</ul>
										</li>
									</security:authorize>
									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="#" id="profile">Profile<span
											class="caret"></span></a>
										<ul class="dropdown-menu">
											<li><a href="#">${currentUser}</a></li>
											<li><a href="/logout">Logout</a></li>
										</ul>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</nav>
		</div>
		<!-- End header -->

		<!-- Begin main body -->
		<div id="body">
			<div class="container-fluid text-center">
				<div class="row content">
					<div class="col-sm-1 sidenav"></div>
					<div class="col-sm-10 text-left">

						<div class="row">
							<tiles:insertAttribute name="body" />
						</div>
					</div>
					<div class="col-sm-1 sidenav"></div>
				</div>
			</div>
		</div>
		<!-- End  main body -->

		<!-- Begin Footer -->
		<div id="footer" >
			<footer>
				<div class="container">
					<div class="ooter-copyright  py-3 text-white bg-dark">
						<p class="text-muted">
							© 2019 Copyright: <a href="#"> tmattendance.mum.edu</a>
						</p>
					</div>
				</div>
			</footer>
		</div>
		<!-- End Footer -->

	</div>
</body>
</html>
