package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DatabaseConnection.ConnectionProvider;
import dao.DoctorDao;


public class DeleteDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

			int id = Integer.parseInt(request.getParameter("id"));

			DoctorDao dao = new DoctorDao(ConnectionProvider.getConnection());
			HttpSession session = request.getSession();

			if (dao.deleteDoctor(id)) {
				session.setAttribute("succMsg", "Delete Sucessfully..");
				response.sendRedirect("Admin/view_doctor.jsp");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				response.sendRedirect("Admin/view_doctor.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
}
