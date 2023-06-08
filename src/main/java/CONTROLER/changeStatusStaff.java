package CONTROLER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.mydao;
import DTO.staff;

@WebServlet("/changeStaffStatuss")
public class changeStatusStaff extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		mydao mydao = new mydao();
		staff staff = mydao.fethByStaffId(id);
		if (staff.isStatus()) {
			staff.setStatus(false);
		} else {
			staff.setStatus(true);
		}
		mydao.updateStaff(staff);

		resp.getWriter().print("<h1> update succesfully</h1>");
		req.setAttribute("list", mydao.fetchAllStaff());
		req.getRequestDispatcher("approvalStaff.jsp").include(req, resp);
	}
}
