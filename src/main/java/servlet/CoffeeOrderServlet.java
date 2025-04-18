package servlet;
import java.io.IOException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CoffeeOrder;

@WebServlet("/coffeeOrder")
public class CoffeeOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String type = req.getParameter("type");
		String size = req.getParameter("size");
		String sugar = req.getParameter("sugar");
		
		if(type == null || size == null || sugar ==null) {
			resp.getWriter().print("參數錯誤");
		}
		
		CoffeeOrder coffeeOrder =new CoffeeOrder(type,size,sugar);
		//resp.getWriter().print(coffeeOrder.getinfo());
		//建立分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/lib/coffee_order.jsp");
		req.setAttribute("coffeeOrder", coffeeOrder);
		rd.forward(req, resp);
		
	}

	
	
}
