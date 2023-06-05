<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false"%> 
<!DOCTYPE html>
<html>
<head>
  <title>Status Page</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      color: #333;
    }

    .status-container {
      text-align: center;
      margin-top: 100px;
    }
    
    .status-icon {
      font-size: 80px;
      margin-bottom: 20px;
    }
    
    .status-heading {
      font-size: 24px;
      font-weight: bold;
      margin-bottom: 10px;
    }

    .status-description {
      font-size: 16px;
    }

    .button-container {
      margin-top: 30px;
    }
    
    .home-button {
      padding: 12px 24px;
      font-size: 16px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 30px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    .home-button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <div class="status-container">
  <h2>This is Status</h2>
   <h1> <div class="status">
     ${message}
  </div></h1>
      <button class="home-button" onclick="location.href='welcome'">Go to Homepage</button>
    </div>
  </div>
</body>
</html>
 