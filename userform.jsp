<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
.error {
	color: red;
	font-family: consolas;
	font-style: italic;
	font-weight: bold;
	font-size: large;
}

.c {
	background-color: black;
	border: 5px solid;
	text-align: center;
}

input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}
input[type=number], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

.alert alert-danger {
	background-color: #45a049;
}
</style>
</head>
<body>
	<div class="c">

		<h2 style="color: red">User Registration Form</h2>

		<div class="contibner">
			<hr>
			<h4 style="color: red">Please fill form Carefully</h4>
			<div class="alert alert-danger" role="alert">
				<form:errors path="user.*" />
			</div>
			<form action="add" method="POST">

				<table style="width: 50%" ,border="5">
				
					<tr>
						<td>User id</td>
						<td><input type="number" name="uid"
							placeholder="user id in digit" /></td>

						<td><form:errors path="uid" cssClass="error" /></td>
					</tr>

					<tr>
						<td>User Name</td>
						<td><input type="text" name="user_name"
							placeholder="enter name" /></td>
						<td><form:errors path="user_name" cssClass="error" /></td>
					</tr>

					<tr>
						<td>User Age</td>
						<td><input type="text" name="uage" placeholder="user age" /></td>

						<td><form:errors path="uage" cssClass="error" /></td>
					</tr>
					<tr>
						<td>User City</td>
						<td><input type="text" name="ucity" placeholder="enter city" /></td>
						<td><form:errors path="uciry" cssClass="error" /></td>
					</tr>
					<tr>
						<td>User Email</td>
						<td><input type="text" name="username"
							placeholder="enter email id ..@gmail.com" /></td>
						<td><form:errors path="username" cssClass="error" /></td>
					</tr>
					<tr>
						<td>User Password</td>
						<td><input type="text" name="upwd"
							placeholder="enter user pasword" /></td>
						<td><form:errors path="upwd" cssClass="error" /></td>
					</tr>
					<tr style="text-align: center">
					</tr>
				</table>

				<input type="submit" value="ADD" />
		</div>
</body>
</html>