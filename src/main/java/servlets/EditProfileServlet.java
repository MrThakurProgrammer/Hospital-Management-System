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

public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String name = request.getParameter("name");
			String dob = request.getParameter("dob");
			String qualification = request.getParameter("qualification");
			String spec = request.getParameter("spec");
			String email = request.getParameter("email");
			String mobno = request.getParameter("mobno");

			int id = Integer.parseInt(request.getParameter("id"));

			Doctor d = new Doctor(id,name,dob,qualification,spec,email,mobno,"");

			DoctorDao dao = new DoctorDao(ConnectionProvider.getConnection());
			HttpSession session = request.getSession();

			if (dao.editDoctorProfile(d)) {
				Doctor update =dao.getDoctorById(id);
				session.setAttribute("succMsgs", " Profile Edit Sucessfully");
				session.setAttribute("docObj", update);
				response.sendRedirect("Doctor/edit_profile.jsp");

			} else {
				session.setAttribute("errorMsgs", "Something wrong on server");
				response.sendRedirect("Doctor/edit_profile.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
