package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DatabaseConnection.ConnectionProvider;
import dao.UserDao;

public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int uid = Integer.parseInt(request.getParameter("uid"));
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");

			UserDao dao = new UserDao(ConnectionProvider.getConnection());
			HttpSession session = request.getSession();

			if (dao.checkOldPassword(uid, oldPassword)) {

				if (dao.changePassword(uid, newPassword)) {
					session.setAttribute("succMsg", "Password Change Sucessfully");
					response.sendRedirect("change_password.jsp");

				} else {
					session.setAttribute("errorMsg", "Something wrong on server");
					response.sendRedirect("change_password.jsp");
				}

			} 
			 else {
				session.setAttribute("errorMsg", "Old Password Incorrect");
				response.sendRedirect("change_password.jsp");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
