package servlet;

import java.io.IOException;
import java.rmi.ServerException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/welcome")
public class WelcomeSerlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
		// 設定編碼
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		
		//接收參數
		
		String name = req.getParameter("name");
		
		resp.getWriter().print(name+"歡迎光臨");

	}

}
