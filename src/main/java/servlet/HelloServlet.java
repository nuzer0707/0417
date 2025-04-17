package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//表示瀏覽器可以透過 http"//localhost:8080/JavaWeb/hello 網址執行到 Servlet 程式
//@WebServlet("/hello") 簡化
//@WebServlet(urlPatterns = "/hello") 標準 
@WebServlet(urlPatterns = {"/hello","/welcome"})
public class HelloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("Hello JavaServlet"); //將字串回應給瀏覽器
	}
	
}
