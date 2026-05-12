<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/dashboard.css">
</head>

<body>

<div class="navbar">
    <div class="logo">Library System</div>
    <ul>
        <li><a href="<%= request.getContextPath() %>/dashboard">Dashboard</a></li>
        <li><a href="<%= request.getContextPath() %>/viewBooks">View Books</a></li>
        <li><a href="<%= request.getContextPath() %>/views/add-book.jsp">Add Book</a></li>
    </ul>
</div>

<div class="container">

<h2>Dashboard</h2>

<div class="card-container">

    <div class="card">
        <h3>Total Books</h3>
        <p><%= request.getAttribute("total") != null ? request.getAttribute("total") : 0 %></p>
    </div>

    <div class="card">
        <h3>Issued Books</h3>
     <p><%= request.getAttribute("issued") != null ? request.getAttribute("issued") : 0 %></p>
    </div>

    <div class="card">
        <h3>Available Books</h3>
        <p><%= request.getAttribute("available") != null ? request.getAttribute("available") : 0 %></p>
    </div>

    <div class="card">
        <h3>Overdue Books</h3>
        <p><%= request.getAttribute("overdue") != null ? request.getAttribute("overdue") : 0 %></p>
    </div>

</div>

</div>

</body>
</html>
