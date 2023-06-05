<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Search Page</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
    }

    .search-container {
      text-align: center;
      margin-top: 100px;
    }
    
    .search-input {
      padding: 10px;
      font-size: 16px;
      border: none;
      border-radius: 30px;
      width: 400px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }
    
    .search-button {
      padding: 12px 24px;
      font-size: 16px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 30px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    .search-button:hover {
      background-color: #45a049;
    }
    
    h1 {
      color: #333;
    }
  </style>
</head>
<body>
  <div class="search-container">
    <h1>Search User</h1>
    <form action="searchuser" method="POST">
      <input type="number"  placeholder="Enter user i'd" required>
      <br><br>
      <button type="submit" class="search-button">Search</button>
    </form>
  </div>
</body>
</html>
