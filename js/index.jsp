<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    if(session.getAttribute("user") == null){
        response.sendRedirect("login.jsp");
        return; 
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Management System</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/index.css">

</head>
<body>


<div class="navbar">
    <div class="logo">Library System</div>

    <div class="nav-links">
        <a href="<%= request.getContextPath() %>/dashboard">Dashboard</a>
        <a href="<%= request.getContextPath() %>/viewBooks">View Books</a>
        <a href="<%= request.getContextPath() %>/views/add-book.jsp">Add Book</a>
    </div>
</div>

<div class="hero">
    <p>"Whatever the cost of our libraries, the price is cheap compared to that of an ignorant nation"</p>
    <h1>Welcome, <%= session.getAttribute("user") %></h1>
    <p>Manage books and maintain your library efficiently.</p>
   
    <div class="buttons">
        <a href="viewBooks" class="btn btn-primary">View Books</a>
        <a href="views/add-book.jsp" class="btn btn-secondary">Add New Book</a>
    </div>
</div>

</body>
</html>