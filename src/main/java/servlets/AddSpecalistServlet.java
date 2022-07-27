package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DatabaseConnection.ConnectionProvider;
import dao.SpecalistDao;



public class AddSpecalistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String SpecName=request.getParameter("SpecName");
			SpecalistDao dao=new SpecalistDao(ConnectionProvider.getConnection());			
			boolean f=dao.addSpecalist(SpecName);			
			HttpSession session=request.getSession();
			if(f) {
				
				session.setAttribute("succMsg",  "Specalist Added");
				response.sendRedirect("Admin/index.jsp");
			}
			else {
				session.setAttribute("errorMsg", "Something wrong on server");
				response.sendRedirect("admin_login.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
