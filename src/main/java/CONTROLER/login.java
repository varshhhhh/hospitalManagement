package CONTROLER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.mydao;
import DTO.doctor;
import DTO.staff;

@WebServlet("/login")
public class login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");

		mydao mydao = new mydao();
		doctor doctor = mydao.fethByDoctorId(id);
		staff staff = mydao.fethByStaffId(id);

		if (staff == null && doctor == null && id != 99999) {
			resp.getWriter().print("<h1>incorect id</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} 
		else {
			if (staff != null) 
			{

				if (staff.getPassword().equals(password)) 
				{
					if (staff.isStatus()) 
					{
						resp.getWriter().print("<h1 style='color:red'>login success</h1>");
						req.getRequestDispatcher("staff_home.html").include(req, resp);
					} else 
					{
						resp.getWriter().print("<h1>wait for admin approval</h1>");
						req.getRequestDispatcher("login.html").include(req, resp);
					}

				} else 
				{
					resp.getWriter().print("<h1>incorrect password</h1>");
					req.getRequestDispatcher("login.html").include(req, resp);
				}
			}
			
		
			if (doctor != null)
			{

				if (doctor.getPassword().equals(password))
				{
					if (doctor.isStatus()) 
					{
						resp.getWriter().print("<h1 style='color:red'>login success</h1>");
						req.getRequestDispatcher("doctor_home.html").include(req, resp);

					
					} 
					else
					{
					resp.getWriter().print("<h1>wait for admin approval</h1>");
					req.getRequestDispatcher("login.html").include(req, resp);
					}
			}
			else 
			{
				resp.getWriter().print("<h1>Incorrect password</h1>");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
			}

			if (id == 99999) 
			{
				if ("99999".equals(password)) 
				{
					resp.getWriter().print("<h1>login successfull</h1>");
					req.getRequestDispatcher("admin.html").include(req, resp);
				}

				else 
				{
					resp.getWriter().print("<h1>incorrect user id or password</h1>");
					req.getRequestDispatcher("login.html").include(req, resp);
				}
			}
	}
   }
}