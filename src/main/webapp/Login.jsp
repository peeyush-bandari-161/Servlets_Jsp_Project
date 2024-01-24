<%@page import="com.mysql.cj.xdevapi.Expression"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<% 
	String message=(String) request.getAttribute("message");
	if( message!=null){
		%>
		<h1><%=message%></h1>
		<%
	}
	%>
	
	<form action="Login" method="post">
		<label>Email Id</label>
		<input name="emailId" placeholder="Enter Email Id" required="required">
		<br><br>
		<label>Password</label>
		<input name="password" placeholder="Enter Password" required="required">
		<br><br>
		
		<button>Login</button>
	</form>
</body>
</html>