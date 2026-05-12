package servlet;

import java.io.IOException;

import dao.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewBooks")
public class ViewBooksServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BookDAO dao = new BookDAO();
        request.setAttribute("bookList", dao.getAllBooks());

        request.getRequestDispatcher("views/view-books.jsp")
               .forward(request, response);
    }
}