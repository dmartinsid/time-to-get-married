<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Is it time to get married?</title>
</head>
<body>
	Your age is ${age}
	<h3>Apenas ${marridPercentageSameGeneration}</h3>
	<c:forEach items="${friendsMarriedSameGeneration}" var="friend" >
		<img src="https://graph.facebook.com/${friend.uid }/picture"/>
		Name: ${friend.name } 
		Age: ${friend.age }<br>
		
	</c:forEach>
	
</body>
</html>