package servlet;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DrinkOrder;

@WebServlet("/drink")
//http://localhost:8080/JavaWeb/drink?type=milkTea&size=L&ice=yes
public class DrinkOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String type = req.getParameter("type");
		String size = req.getParameter("size");
		String ice = req.getParameter("ice");
		
		if(type == null || size == null || ice ==null) {
			resp.getWriter().print("參數錯誤");
		}
		
		DrinkOrder drinkOrder = new DrinkOrder(type,size,ice);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/lib/drink_order.jsp");
		
		req.setAttribute("drinkOrder", drinkOrder);
		rd.forward(req, resp);
		
	}

	
	
	
}
