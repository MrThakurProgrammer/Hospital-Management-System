package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DatabaseConnection.ConnectionProvider;
import dao.DoctorDao;
import entities.Doctor;

public class DoctorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String email = request.getParameter("Email");
			String password = request.getParameter("Password");

			HttpSession session = request.getSession();

			DoctorDao dao = new DoctorDao(ConnectionProvider.getConnection());
			Doctor doctor = dao.login(email, password);

			if (doctor != null) {
				session.setAttribute("docObj", doctor);
				response.sendRedirect("Doctor/index.jsp");
			} else {
				session.setAttribute("errorMsg", "invalid email & password");
				response.sendRedirect("doctor_login.jsp");
			}   
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

