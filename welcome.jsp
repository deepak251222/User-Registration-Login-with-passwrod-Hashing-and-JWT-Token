<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	color: #333;
}

.header {
	background-color: #4CAF50;
	padding: 20px;
	text-align: center;
	color: white;
}

.hero {
	text-align: center;
	margin-top: 100px;
}

.hero-title {
	font-size: 32px;
	font-weight: bold;
	margin-bottom: 20px;
}

.hero-description {
	font-size: 18px;
	margin-bottom: 30px;
}

.cta-button {
	padding: 12px 24px;
	font-size: 16px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 30px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.cta-button:hover {
	background-color: #45a049;
}

.feature {
	text-align: center;
	margin-top: 50px;
	padding: 20px;
}

.feature-icon {
	font-size: 40px;
	margin-bottom: 20px;
}

.feature-title {
	font-size: 24px;
	font-weight: bold;
	margin-bottom: 10px;
}

.feature-description {
	font-size: 16px;
}
</style>
</head>
<body>
	<div class="header">
		<h1>Welcome to Our Home</h1>
	</div>

	<div class="hero">
		<h2 class="hero-title">Please Go to Respected Url!</h2>

		<a href="adduser">Add User</a><br> <br> <a href="search">Search
			User</a><br> <br> <a href="loginuser">Login User</a><br> <br>
		<a href="token">Token Generate</a>

	</div>
</body>
</html>