package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ice.IceOrder;

@WebServlet("/ice")
public class iceDesserServlet extends HttpServlet{
	
	private static List<IceOrder> iceOrders = new CopyOnWriteArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		
		req.getRequestDispatcher("/WEB-INF/ice_dessert_form.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	req.setCharacterEncoding("UTF-8");
	
	
	// 讀取 action 參數，如果沒有提供，可以預設為 "add" (或其他你認為的預設行為)
	String action = req.getParameter("action");
	if(action == null) {
		action = "add";// 如果沒有 action 參數，預設為新增
	}
	
	 // 使用 switch 處理不同的 action
	switch (action) {
	case "delete": 
		deleteAction(req);
		break;
		
	case "add": 
		addAvtion(req);
		break;
	
	default:
		System.err.println("未知的操作"+action+"，將執行預設的新增操作。");
		addAvtion(req);
		break;
	}
	

	//重導 JSP
	RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/icedessert_result.jsp");
	req.setAttribute("iceOrders", iceOrders);
	rd.forward(req, resp);

	
	}

	//刪除方法
	private void deleteAction(HttpServletRequest req ) {
		
		String indexStr = req.getParameter("index");
		try {
			int index = Integer.parseInt(indexStr);
			if(index >= 0 && index < iceOrders.size()) {
				IceOrder removedOrder  = iceOrders.remove(index);
				System.out.println("成功刪除訂單 (索引 " + index + "): " + removedOrder.getMainDish().getName());
			}else {
				System.err.println("刪除失敗：無效的索引 " + index);
			}
		} catch (NumberFormatException e) {
			System.err.println("刪除失敗:格式錯誤"+indexStr);
		}catch 	(Exception e) {
			System.err.println("刪除發勝錯誤"+indexStr + e.getMessage());
		}
			
	}
		
	//新增方法
	private void addAvtion(HttpServletRequest req) {
		
		//接收表單參數
		String mainDishName = req.getParameter("mainDish");
		String[] toppingArray = req.getParameterValues("toppings");
		
		if(mainDishName!= null && !mainDishName.trim().isEmpty()) {
			//建立 IceOrder
			IceOrder iceOrder = new IceOrder(mainDishName,toppingArray);
			//加入到訂單集合
			iceOrders.add(iceOrder);
			System.out.println("成功新增訂單"+mainDishName);
		}else {
			System.err.println("新增訂單失敗：未選擇主餐。");
		}
		
	}
	
	
	
}
