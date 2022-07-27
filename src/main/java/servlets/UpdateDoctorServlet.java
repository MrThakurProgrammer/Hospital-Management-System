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

public class UpdateDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

			String name = request.getParameter("name");
			String dob = request.getParameter("dob");
			String qualification = request.getParameter("qualification");
			String spec = request.getParameter("spec");
			String email = request.getParameter("email");
			String mobno = request.getParameter("mobno");
			String password = request.getParameter("password");

			int id = Integer.parseInt(request.getParameter("id"));

			Doctor d = new Doctor(id,name,dob,qualification,spec,email,mobno,password);

			DoctorDao dao = new DoctorDao(ConnectionProvider.getConnection());
			HttpSession session = request.getSession();

			if (dao.updateDoctor(d)) {
				session.setAttribute("succMsg", "Update Sucessfully..");
				response.sendRedirect("Admin/view_doctor.jsp");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				response.sendRedirect("Admin/view_doctor.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
