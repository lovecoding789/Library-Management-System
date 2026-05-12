package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import dao.BookDAO;

public class ToggleIssueServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        BookDAO dao = new BookDAO();
        boolean isIssued = dao.isBookIssued(id);

        if (isIssued) {
            dao.returnBook(id);
        } else {
            dao.issueBook(id);
        }
        response.sendRedirect("viewBooks");
    }
}