<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<div class="hero-unit">
		<h1>Welcome!</h1>
		<p>Here you could get the answer if you must get married.</p>
		<p>
			<a class="btn btn-primary btn-large"
				href="https://www.facebook.com/dialog/oauth?client_id=${facebookProperties.client_id}&redirect_uri=${facebookProperties.redirect_uri}&scope=${facebookProperties.scope}&state=blabla">Log
				in</a>
		</p>
	</div>

</body>
</html>