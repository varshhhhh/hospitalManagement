package CONTROLER;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.mydao;
import DTO.doctor;;

@WebServlet("/FetchAllDoctor")
public class FectchAllDoctor extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		mydao mydao = new mydao();
		List<doctor> list = mydao.fetchAllDoctor();
		if (list.isEmpty()) {
			resp.getWriter().print("<h1 style='color:red'>no doctor has sign up yet </h1>");
			req.getRequestDispatcher("admin.html").include(req, resp);
		} else {
			req.setAttribute("list", list);
			req.getRequestDispatcher("approveDoctor.jsp").forward(req, resp);
		}
	}
}
