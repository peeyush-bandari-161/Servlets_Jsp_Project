<%@page import="dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% List<Employee>employees=(List) request.getAttribute("emp");%>
	<table border="2px solid">
	<tr>
		<th>Id</th>	
		<th>Name</th>
		<th>Age</th>
		<th>Address</th>
		<th>Phone</th>
		<th>Email</th>
		<th>Password</th>
		<th>Delete</th>
		<th>Update</th>
	</tr>
	<%for(Employee employee:employees){%>
			<tr>
				<td><%=employee.getEmpId() %></td>
				<td><%=employee.getEmpName() %></td>
				<td><%=employee.getEmpAge() %></td>
				<td><%=employee.getEmpAddress() %></td>
				<td><%=employee.getEmpPhno() %></td>
				<td><%=employee.getEmailId() %></td>
				<td><%=employee.getPassword() %></td>
				<td><a href="delete?id=<%=employee.getEmpId()%>"><button>DELETE</button></a></td>
				<td><a href="update?id-<%=employee.getEmpId()%>"><button>UPDATE</button></a></td>
			</tr>
		<%}%>
	
	</table>
</body>
</html>