package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DatabaseConnection.ConnectionProvider;
import dao.AppointmentDao;

public class UpdateStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			int did = Integer.parseInt(request.getParameter("did"));
			String comm = request.getParameter("comm");

			AppointmentDao dao = new AppointmentDao(ConnectionProvider.getConnection());

			HttpSession session = request.getSession();

			if (dao.updateCommentStatus(id, did, comm)) {
				session.setAttribute("succMsg", "Comment Updated");
				response.sendRedirect("Doctor/patient.jsp");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				response.sendRedirect("Doctor/patient.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
