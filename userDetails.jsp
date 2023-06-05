
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
  margin-top: 5%;
  padding: 5%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
	<br>
	<br>
	<br>
	
	<center>

		<h2 style="color: red">User  Details</h2>
		
		<table style="width: 50%",border='5'>
			<tr>
				<td>User_I'D</td>
				<td>${u1.uid}</td>
			</tr>
			<tr>
				<td>User_NAME</td>
				<td>${u1.user_name}</td>
			</tr>
			<tr>
				<td>User Age</td>
				<td>${u1.uage}</td>
			</tr>
			<tr>
				<td>User City</td>
				<td>${u1.ucity}</td>
			</tr>
			<tr>
				<td>User_email</td>
				<td>${u1.username}</td>
			</tr>
			<tr>
				<td>user password</td>
				<td>${u1.upwd}</td>
			</tr>
		</table>
		<h3>
			<a href="welcome.jsp">Home Page</a>
		</h3>
	</center>
</body>
</html>
