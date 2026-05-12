package servlet;

import java.io.IOException;

import dao.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String author = request.getParameter("author");

        BookDAO dao = new BookDAO();
        dao.addBook(title, author);
        
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);

        response.sendRedirect(request.getContextPath() + "/viewBooks");
    }
}