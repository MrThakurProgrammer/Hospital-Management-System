package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DatabaseConnection.ConnectionProvider;
import dao.DoctorDao;
import dao.UserDao;

public class DoctorChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int uid = Integer.parseInt(request.getParameter("uid"));
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");

			DoctorDao dao = new DoctorDao(ConnectionProvider.getConnection());
			HttpSession session = request.getSession();

			if (dao.checkOldPassword(uid, oldPassword)) {

				if (dao.changePassword(uid, newPassword)) {
					session.setAttribute("succMsg", "Password Change Sucessfully");
					response.sendRedirect("Doctor/edit_profile.jsp");

				} else {
					session.setAttribute("errorMsg", "Something wrong on server");
					response.sendRedirect("Doctor/edit_profile.jsp");
				}

			} 
			 else {
				session.setAttribute("errorMsg", "Old Password Incorrect");
				response.sendRedirect("Doctor/edit_profile.jsp");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
