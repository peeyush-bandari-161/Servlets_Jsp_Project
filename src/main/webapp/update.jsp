<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/update" method="get">
		<label>Employee Name:</label>
		<input name="empName" placeholder="Enter Employee Name" required="required">
		<br><br>
		<label>Employee Age:</label>
		<input name="empAge" placeholder="Enter Employee Age" required="required">
		<br><br>
		<label>Employee Address:</label>
		<input name="empAddress" placeholder="Enter Employee Address" required="required">
		<br><br>
		<label>Employee Phone: </label>
		<input name="empPhno" placeholder="Enter Employee Phone" required="required">
		<br><br>
		<label>Email Id:</label>
		<input name="mailId" placeholder="Enter EMailId" required="required">
		<br><br>
		<label>Password:</label>
		<input name="password" placeholder="Enter Password" required="required">
		<br><br>
		
		<button>Update</button>
	</form>
</body>
</html>