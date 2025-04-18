package servlet;

import java.io.IOException;
import java.rmi.ServerException;
import java.security.PrivateKey;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Util;


@WebServlet("/welcome")
public class WelcomeSerlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
		// 設定編碼
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		
		//接收參數
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		//檢查age是否是數字
		if(Util.isNum2(age)) {
			String message = Integer.parseInt(age)>=18 ? "成年": "未成年";
			resp.getWriter().print(name+"歡迎光臨 (" + age +" 歲 "+ message+ ")");
		}else {
			resp.getWriter().print(name+"歡迎光臨");
		}
		
	}


	
}
