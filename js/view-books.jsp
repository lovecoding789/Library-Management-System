<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*, model.Book" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Books</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/view-books.css">
</head>

<body>

<div class="navbar">
    <div class="logo">Library System</div>
    <ul>
        <li><a href="<%= request.getContextPath() %>/viewBooks">View Books</a></li>
        <li><a href="<%= request.getContextPath() %>/views/add-book.jsp">Add Book</a></li>
        <li><a href="#">Logout</a></li>
    </ul>
</div>

<div class="container">

<h2>Library Books</h2>

<table>
<tr>
    <th>ID</th>
    <th>Title</th>
    <th>Author</th>
    <th>Status</th>
    <th>Issue Date</th>
    <th>Return Date</th>
    <th>Action</th>
</tr>

<%
List<Book> list = (List<Book>) request.getAttribute("bookList");

if(list != null) {
    for(Book b : list) {
%>
<tr>
    <td><%= b.getId() %></td>
    <td><%= b.getTitle() %></td>
    <td><%= b.getAuthor() %></td>

    <!--Styled Status -->
    <td class="<%= b.isIssued() ? "status-issued" : "status-available" %>">
        <%= b.isIssued() ? "Issued" : "Available" %>
        
   </td>
    
    <td><%= b.getIssueDate() != null ? b.getIssueDate() : "-" %></td>
<td><%= b.getReturnDate() != null ? b.getReturnDate() : "-" %></td>

    <!-- Styled Buttons -->
    <td>
    <% if(b.isIssued()) 
    
    { %>
        <a href="<%= request.getContextPath() %>/toggleIssue?id=<%=b.getId()%>">
            <button class="return-btn">Return</button>
        </a>
    <% } else
    
    { %>
        <a href="<%= request.getContextPath() %>/toggleIssue?id=<%=b.getId()%>">
            <button class="issue-btn">Issue</button>
        </a>
    <% } %>
</td>
</tr>
<%
    }
}
%>

</table>

</div>

</body>
</html>