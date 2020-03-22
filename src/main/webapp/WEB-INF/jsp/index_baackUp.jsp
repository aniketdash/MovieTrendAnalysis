<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet"> 
	<link rel="stylesheet" href="js/open_page.css">
</head>
<body>

	 <div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#">home</a>
  <a href="Explore_page.html">explore</a>
  <a href="#">comparision</a>
  <a href="#">ranking</a>
</div>

<!-- Use any element to open the sidenav -->


<!-- Add all page content inside this div if you want the side nav to push page content to the right (not used if you only want the sidenav to sit on top of the page -->
<div class="header" id="main">
		<span onclick="openNav()"><button class="btn"><i class="fa fa-bars"></i></button></span>
	<div class="inner_header">
		<div class="logo_container">
		<h1>Movie<span>My</span>Analysis</h1>
		</div>
		<ul class="navigation">
			<a><li>home</li></a>
			<a><li>explore</li></a>
			<a><li>comparision</li></a>
			<a><li>ranking</li></a>
		</ul>
	</div> 
	
 <div class="showCharts">
	<form id="contactForm1" action="#" th:action="@{/movie}" th:object="${movie}" method="post">
    	<select id="genre" name="genre">
   		<option value="Adult">Adult</option>
    	</select>
        <p><input type="submit" value="Submit" id="submit_1" /> <input type="reset" value="Reset" /></p>
    </form>
	</select>
    <h1>Movie Trend Analysis</h1>
	<p>Line chart</p>
	<div id="container" style="height: 400px"></div>
	
	<script src="js/highcharts.js"></script>
	<script src="js/jquery.js"></script>
	<script src="js/index.js"></script>
</div>
</div>
<script src="js/open_page.js"></script>
</body>
</html>