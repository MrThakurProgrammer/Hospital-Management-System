package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DatabaseConnection.ConnectionProvider;
import dao.UserDao;
import entities.User;

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String email=request.getParameter("Email");
			String password=request.getParameter("Password");
		
			HttpSession session=request.getSession();
			UserDao dao=new UserDao(ConnectionProvider.getConnection());
			User user=dao.Login(email, password);
			
			if(user!=null) {
				
				session.setAttribute("userObj",  user);
				response.sendRedirect("index.jsp");
			}
			else {
				session.setAttribute("errorMsg", "invalid email & password");
				response.sendRedirect("user_login.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
