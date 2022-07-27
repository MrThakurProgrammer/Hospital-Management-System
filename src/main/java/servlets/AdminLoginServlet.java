package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String email=request.getParameter("Email");
			String password=request.getParameter("Password");
			
			HttpSession session=request.getSession();
			
			if("admin@gmail.com".equals(email) && "admin".equals(password)) {
				
				session.setAttribute("adminObj", new User());
				response.sendRedirect("Admin/index.jsp");
			}
			else {
				session.setAttribute("errorMsg", "invalid email & password");
				response.sendRedirect("admin_login.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
