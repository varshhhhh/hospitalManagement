package CONTROLER;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.mydao;
import DTO.doctor;

@WebServlet("/doctor")
public class DoctorSignup extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		Long mobile = Long.parseLong(req.getParameter("mobile"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		Date dob = Date.valueOf(req.getParameter("dateofbirth"));
		String qualification = req.getParameter("qualification");
		String specialization = req.getParameter("specialization");

		int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();

		mydao mydao = new mydao();
		if (mydao.fetchByDoctorMobile(mobile) == null && mydao.fetchByDoctorEmail(email) == null) {

			doctor dacto = new doctor();

			dacto.setName(name);
			dacto.setMobile(mobile);
			dacto.setEmail(email);
			dacto.setPassword(password);
			dacto.setGender(gender);
			dacto.setDob(dob);
			dacto.setQualification(qualification);
			dacto.setSpecialization(specialization);

			// mydao mydao=new mydao();
			mydao.SaveDoctor(dacto);

			resp.getWriter().print("<h1> sign up succesfully  and waiting for admin aprroval</h1>");
			resp.getWriter().print("<h1>staff id: " + dacto.getId() + "</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);

		}

		else {
			resp.getWriter().print("<h1>mobile or email id alredy exits</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);

		}
	}

}
