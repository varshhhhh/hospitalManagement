package CONTROLER;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.mydao;
import DTO.doctor;
import DTO.staff;

@WebServlet("/forgot_pass")
public class forgot_password extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Long mobile = Long.parseLong(req.getParameter("mobile"));
		Date dob = Date.valueOf(req.getParameter("dob"));
		String password = req.getParameter("new_password");

		mydao mydao = new mydao();
		doctor doctor = mydao.fethByDoctorId(id);
		staff staff = mydao.fethByStaffId(id);

		if (doctor == null && staff == null) {
			resp.getWriter().print("<h1> invalid id:</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);

		} else {
			if (doctor != null) {
				if (doctor.getName().equals(name) && doctor.getMobile() == mobile && doctor.getDob().equals(dob)) {
					doctor.setPassword(password);
					mydao.UpadteDoctor(doctor);
					resp.getWriter().print("<h1>update successfully</h1>");
					req.getRequestDispatcher("login.html").include(req, resp);
				} else {
					resp.getWriter().print("<h1> invalid id:</h1>");
					req.getRequestDispatcher("forgot_pass.html").include(req, resp);
				}
			} else {
				if (staff.getName().equals(name) && staff.getMobile() == mobile && staff.getDob().equals(dob)) {
					staff.setPassword(password);
					mydao.updateStaff(staff);
					resp.getWriter().print("<h1>update successfully</h1>");
					req.getRequestDispatcher("login.html").include(req, resp);
				} else {
					resp.getWriter().print("<h1> invalid id:</h1>");
					req.getRequestDispatcher("forgot_pass.html").include(req, resp);
				}

			}
		}

	}

}
