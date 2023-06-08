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
import javax.servlet.http.Part;

import DAO.mydao;
import DTO.patient;

@WebServlet("/add_patient")
public class addPatient extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		Date dob = Date.valueOf(req.getParameter("dob"));
		int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		Part picture = req.getPart("picture");

		byte[] image = new byte[picture.getInputStream().available()];

		picture.getInputStream().read(image);

		patient patient = new patient();
		patient.setName(name);
		patient.setMobile(mobile);
		patient.setDob(dob);
		patient.setAge(age);
		patient.setPicture(image);

		mydao mydao = new mydao();
		mydao.fetchPatient(patient);

		resp.getWriter().print("<h1>ADDED PATIENT SUCCESSFULLYY</h1>");
		req.getRequestDispatcher("staff_home.html").include(req, resp);
	}

}
