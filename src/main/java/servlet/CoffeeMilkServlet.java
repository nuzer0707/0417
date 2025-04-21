package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CoffeeMilk;
import model.CoffeeTeacher;

@WebServlet("/coffee")
public class CoffeeMilkServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_form.jsp");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String coffee = req.getParameter("coffee");
		String milk = req.getParameter("milk");
		
		//CoffeeMilk coffeeMilk  = new CoffeeMilk(coffee,milk);
		CoffeeTeacher coffeeMilk = new CoffeeTeacher(coffee,milk);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_result.jsp");
		
		req.setAttribute("coffeeMilk", coffeeMilk);
		
		rd.forward(req, resp);
		
		
		
	}

	
	
	
}
