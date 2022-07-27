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


public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name=request.getParameter("Name");
			String email=request.getParameter("Email");
			String password=request.getParameter("Password");
			
			User user=new User(name,email,password);
			
			UserDao u=new UserDao(ConnectionProvider.getConnection());
			
			HttpSession session=request.getSession();
			boolean f=u.UserRegister(user);
			
			if(f) {
				
				session.setAttribute("succMsg", "Register Successfully");		
				response.sendRedirect("user_login.jsp");
			}
			else {
				session.setAttribute("errorMsg", "Something wrong on server");
				response.sendRedirect("signup.jsp");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
