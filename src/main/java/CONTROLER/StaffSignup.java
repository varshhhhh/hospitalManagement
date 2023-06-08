package CONTROLER;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.mydao;
import DTO.staff;

@WebServlet("/staffsignup")
public class StaffSignup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Long mobile = Long.parseLong(req.getParameter("mobile"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		Date dob = Date.valueOf(req.getParameter("dateofbirth"));

		// int age=2023-dob.toLocalDate().getYear();
		// int age=LocalDate.now().getYear()-dob.toLocalDate().getYear();
	
		int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		
		// period=class , between=methods
		
		
		mydao mydao = new mydao();
		if (mydao.fetchByFindMobile(mobile) == null && mydao.fetchByFindEmail(email) == null) {

			staff staff = new staff();
			staff.setName(name);
			staff.setMobile(mobile);
			staff.setEmail(email);
			staff.setPassword(password);
			staff.setDob(dob);
			staff.setGender(gender);
			staff.setAge(age);

			// mydao mydao = new mydao();
			mydao.save(staff);

			resp.getWriter().print("<h1> staff account created successfully and waiting for admin aprroval</h1> ");
			resp.getWriter().print("<h1> staff id:" + " " + staff.getId() + "</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} else {
			resp.getWriter().print("<h1> mobile number already exist </h1>");
			req.getRequestDispatcher("login.html").include(req, resp);

		}

	}

}
