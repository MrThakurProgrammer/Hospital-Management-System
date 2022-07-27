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

public class AddDoctorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name=request.getParameter("D_Name");
			String dob=request.getParameter("D_Dob");
			String qualification=request.getParameter("D_Qualification");
			String specalist=request.getParameter("D_Specalist");
			String email=request.getParameter("D_Email");
			String mobno=request.getParameter("D_Mobno");
			String password=request.getParameter("D_Password");
			
			Doctor doctor=new Doctor(name,dob,qualification,specalist,email,mobno,password);
			DoctorDao dao=new DoctorDao(ConnectionProvider.getConnection());						
			HttpSession session=request.getSession();
			
			if(dao.registerDoctor(doctor)) {
				
				session.setAttribute("succMsg",  "Added Successfully");
				response.sendRedirect("Admin/doctor.jsp");
			}
			else {
				session.setAttribute("errorMsg", "Something wrong on server");
				response.sendRedirect("Admin/doctor.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
