<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Time to get Married</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Deivid Martins">


<link href="/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
html,body {
	height: 100%;
}

footer {
	padding: 0 10px 0 10px;
	border-top: 1px solid #eee;
	color: white;
	background-color: black;
}

footer>p {
	margin-bottom: 11px;
	margin-top: 13px;
}

.wrapper {
	min-height: 100%;
	height: auto !important;
	height: 100%;
	margin: 0 auto -43px;
}

.push {
	height: 63px;
}
	/* Just some arbitrary space to add between footer and rest of the content, when they are close */

/* not required for sticky footer; just makes some space for navigation bar */
.wrapper>.container-fluid {
	padding-top: 60px;
}
</style>
<link rel="shortcut icon" href="images/favicon.ico">
<link rel="apple-touch-icon" href="images/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="images/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="images/apple-touch-icon-114x114.png">
</head>
<body>
	<div class="wrapper">
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container-fluid">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand" href="#">Time to get married</a>
					<div class="nav-collapse">
						<ul class="nav">
							<li class="active"><a href="#">Home</a></li>
							<li><a href="#about">About</a></li>
							<li><a href="#contact">Contact</a></li>
						</ul>
						<p class="navbar-text pull-right">
							
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<decorator:body />
		</div>
		<div class="push">
			<!--//-->
		</div>
	</div>
	<!--/.fluid-container-->
	<footer class="container-fluid">
		<p>
			Time to get married 
			<a href="https://github.com/dcmdeivid/time-to-get-married">
				Fork it!
			</a>
		</p>
	</footer>



	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>

	<decorator:getProperty property="page.customJavaScript" />


</body>
</html>