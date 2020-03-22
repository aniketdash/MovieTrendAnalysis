<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
/* background-image: url("http://pagetwo.completecolorado.com/wp-content/uploads/1280px-Hollywood_Sign_Zuschnitt.jpg"); */
 background-image: url("https://wallpaperplay.com/walls/full/b/5/8/64772.jpg");
}
</style>
<title></title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="js/open_page.css">
</head>
<body>

	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			<a href="${contextPath}/movie">Home</a>
			<a href="${contextPath}/profitableCompanies">Capitals</a>
			<a href="${contextPath}/diversity">Diversity</a>
			<a href="${contextPath}/marketShare">Share</a>
			<a href="${contextPath}/preference">Preference</a>
			<a href="${contextPath}/trends">Trends</a>
	</div>

	<!-- Use any element to open the sidenav -->


	<!-- Add all page content inside this div if you want the side nav to push page content to the right (not used if you only want the sidenav to sit on top of the page -->
	<div class="header" id="main">
		<span onclick="openNav()"><button class="btn">
				<i class="fa fa-bars"></i>
			</button></span>
		<div class="inner_header">
			<div class="logo_container">
				<h1>
					Movie<span>My</span>Analysis
				</h1>
			</div>
			<ul class="navigation">
			<a href="${contextPath}/movie"><li>Home</li></a>
			<a href="${contextPath}/profitableCompanies"><li>Capitals</li></a>
			<a href="${contextPath}/diversity"><li>Diversity</li></a>
			<a href="${contextPath}/marketShare"><li>Share</li></a>
			<a href="${contextPath}/preference"><li>Preference</li></a>
			<a href="${contextPath}/trends"><li>Trends</li></a>
			</ul>
		</div>

		<div class="showCharts">
			<form id="contactForm1" action="#" th:action="@{/movie}"
				th:object="${movie}" method="post">
				<select id="roles" name="roles">
					<option value="Writer">Writer</option>
					<option value="Actor">Actor</option>
					<option value="Director">Director</option>
				</select>
				<p>
					<input type="submit" value="Submit" id="submit_1" /> <input
						type="reset" value="Reset" />
				</p>
			</form>
			
			</select>
			<h1>Preference by Directors</h1>
			<p>Line chart</p>
			<div id="container" style="height: 400px"></div>

			<script src="js/highcharts.js"></script>
			<script src="js/jquery.js"></script>
			<script src="js/indexWriterForDirector.js"></script>
		</div>
	</div>
	<script src="js/open_page.js"></script>
</body>
</html>