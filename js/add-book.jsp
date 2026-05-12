<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/add-book.css">
</head>

<body>

<!-- 🔹 Navbar -->
<div class="navbar">
    <div class="logo">Library System</div>
    <ul>
        <li><a href="<%= request.getContextPath() %>/viewBooks">View Books</a></li>
        <li><a href="add-book.jsp">Add Book</a></li>
        <li><a href="#">Logout</a></li>
    </ul>
</div>

<!--Wrapper-->
<div class="wrapper">
    <div class="container">
        <h2>Add New Book</h2>

        <form action="<%= request.getContextPath() %>/addBook" method="post">
            <input type="text" name="title" placeholder="Enter Book Title" required>
            
            <input type="text" name="author" placeholder="Enter Author Name" required>
            
            <button type="submit">Add Book</button>
        </form>
    </div>
</div>

</body>
</html>