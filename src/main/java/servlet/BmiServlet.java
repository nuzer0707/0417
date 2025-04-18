package servlet;

import java.io.IOException;
import java.rmi.ServerException;

import util.Util;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bmi")
public class BmiServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String height = req.getParameter("h");
		String weight = req.getParameter("w");
		
		if(!(Util.isDouble(height)&&Util.isDouble(weight))) {
			System.out.println("身高體重輸入錯誤");
			return;
		}
		
		double h = Double.parseDouble(height);
		double w = Double.parseDouble(weight);
		double bimValue= getBmiValue(h,w);
		String result= getBmiResult(bimValue);
		
		resp.getWriter().print(String.format("BMI 值 = %.2f (%s) \n",bimValue, result));	
		resp.getWriter().print("小於18過輕，大於23過重");
	}
	private double getBmiValue(double h ,double w) {
		return w/ Math.pow(h/100,2);	
	}
	
	private String getBmiResult(double bimValue) {
		
		return bimValue<= 18 ? "過輕":(bimValue >23) ?"過重" :"正常";
					
	}
	
	
}
