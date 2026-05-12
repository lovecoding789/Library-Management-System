package servlet;


import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import dao.BookDAO;

public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	BookDAO dao = new BookDAO();

    	int total = dao.getTotalBooks();
    	int issued = dao.getIssuedBooks();
    	int available = dao.getAvailableBooks();
    	int overdue = dao.getOverdueBooks();

    	request.setAttribute("total", total);
    	request.setAttribute("issued", issued);
    	request.setAttribute("available", available);
    	request.setAttribute("overdue", overdue);

    	RequestDispatcher rd = request.getRequestDispatcher("views/dashboard.jsp");
    	rd.forward(request, response);
    }
}