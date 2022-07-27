package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DatabaseConnection.ConnectionProvider;
import dao.AppointmentDao;
import entities.Appointment;

public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int userId = Integer.parseInt(request.getParameter("UserId"));
			String name = request.getParameter("Name");
			String gender = request.getParameter("Gender");
			String age = request.getParameter("Age");
			String appoint_date = request.getParameter("AppointDate");
			String email = request.getParameter("Email");
			String phno = request.getParameter("Phno");
			String diseases = request.getParameter("Diseases");
			int doctor_id = Integer.parseInt(request.getParameter("Doctor"));
			String address = request.getParameter("Address");

			Appointment ap = new Appointment(userId, name, gender, age, appoint_date, email, phno, diseases, doctor_id,
					address, "Pending");

			AppointmentDao dao = new AppointmentDao(ConnectionProvider.getConnection());
			HttpSession session = request.getSession();

			if (dao.addAppointment(ap)) {
				session.setAttribute("succMsg", "Appointment Sucessfully");
				response.sendRedirect("user_appointment.jsp");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				response.sendRedirect("user_appointment.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
