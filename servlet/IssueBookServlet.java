package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

import dao.BookDAO;

@WebServlet("/issueBook")
public class IssueBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        BookDAO dao = new BookDAO();
        dao.issueBook(id);

        response.sendRedirect("viewBooks");
    }
}