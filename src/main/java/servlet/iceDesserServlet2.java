package servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
// 變更 WebServlet 註解以處理多個路徑
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ice.IceOrder;

/**
 * ZHTW:
 * 這個 Servlet 負責處理冰品訂單相關的請求。
 * 它會處理兩個主要的路徑：
 * 1. /ice/new : 用於顯示新增訂單的表單 (GET請求)。
 * 2. /ice/orders : 用於處理新增/刪除訂單 (POST請求)，以及顯示目前的訂單列表 (GET請求)。
 */

@WebServlet(urlPatterns = {"/ice/new", "/ice/orders"}) // ZHTW: 將 Servlet 映射到這兩個 URL 模式
public class iceDesserServlet2 extends HttpServlet{

	// ZHTW: 使用 CopyOnWriteArrayList 存放訂單，確保多執行緒下的讀寫安全。
	// ZHTW: static 表示這個列表屬於類別本身，所有請求共享同一個訂單列表。
	private static List<IceOrder> iceOrders = new CopyOnWriteArrayList<>();

	/**
	 * ZHTW:
	 * 處理 GET 請求。
	 * 根據請求的路徑 (Servlet Path) 來決定要顯示哪個頁面：
	 * - 如果是 "/ice/new"，轉發到訂單表單頁面 (ice_dessert_form.jsp)。
	 * - 如果是 "/ice/orders" 或其他 GET 請求，準備訂單列表數據並轉發到訂單結果頁面 (icedessert_result.jsp)。
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ZHTW: 取得請求的 Servlet 路徑 (例如 "/ice/new" 或 "/ice/orders")
		String path = req.getServletPath();

		if ("/ice/new".equals(path)) {
			// ZHTW: 如果路徑是 /ice/new，顯示表單頁面
			req.getRequestDispatcher("/WEB-INF/ice_dessert_form.jsp").forward(req, resp);
		} else {
			// ZHTW: 預設情況 (包括 /ice/orders)，顯示訂單結果頁面
			// ZHTW: 將目前的訂單列表放入 request attribute，以便 JSP 頁面可以存取
			req.setAttribute("iceOrders", iceOrders);
			// ZHTW: 轉發請求到結果顯示頁面
			req.getRequestDispatcher("/WEB-INF/icedessert_result.jsp").forward(req, resp);
		}
	}

	/**
	 * ZHTW:
	 * 處理 POST 請求 (預期來自 /ice/orders 路徑)。
	 * 這通常是表單提交 (新增訂單) 或刪除訂單的請求。
	 * 處理完畢後，使用 Post/Redirect/Get (PRG) 模式，
	 * 發送一個重定向 (redirect) 回應給瀏覽器，要求瀏覽器發送一個新的 GET 請求到 /ice/orders，
	 * 以避免重新整理頁面時重複提交表單。
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// ZHTW: 確保能正確處理中文參數
		req.setCharacterEncoding("UTF-8");

		// ZHTW: 讀取 "action" 參數，判斷使用者意圖 (新增或刪除)
		String action = req.getParameter("action");
		if(action == null) {
			// ZHTW: 如果表單提交時沒有明確的 action (例如從新增表單過來)，預設為 "add"
			action = "add";
		}

		 // ZHTW: 使用 switch 根據 action 參數執行對應的操作
		switch (action) {
			case "delete":
				deleteAction(req); // ZHTW: 執行刪除邏輯
				break;

			case "add":
				addAvtion(req); // ZHTW: 執行新增邏輯
				break;

			default:
				// ZHTW: 如果收到未知的 action，印出錯誤訊息並執行預設的新增操作
				System.err.println(" 未知的操作: "+action+"，將執行預設的新增操作。");
				addAvtion(req);
				break;
		}

		// **** ZHTW: 應用 PRG (Post/Redirect/Get) 模式 ****
		// ZHTW: 不再使用 forward，而是發送 redirect 回應。
		// ZHTW: 瀏覽器收到 redirect 後，會自動發送一個新的 GET 請求到指定的 URL。
		// ZHTW: req.getContextPath() 會取得應用程式的根路徑 (例如 /JavaWeb)，確保 URL 正確。
		String redirectURL = req.getContextPath() + "/ice/orders";
		resp.sendRedirect(redirectURL); // ZHTW: 發送重定向指令 (預設是 HTTP 302 Found)

		// --- ZHTW: 移除舊的 forward 程式碼 ---
		// RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/icedessert_result.jsp");
		// req.setAttribute("iceOrders", iceOrders);
		// rd.forward(req, resp);
	}

	/**
	 * ZHTW:
	 * 處理刪除訂單的邏輯。
	 * 從請求中讀取要刪除的訂單索引 (index)，
	 * 驗證索引的有效性後，從 iceOrders 列表中移除對應的訂單。
	 */
	private void deleteAction(HttpServletRequest req ) {
		// ZHTW: 取得要刪除項目的索引值 (來自隱藏欄位)
		String indexStr = req.getParameter("index");
		try {
			// ZHTW: 將索引字串轉換為整數
			int index = Integer.parseInt(indexStr);
			// ZHTW: 檢查索引是否在有效範圍內
			if(index >= 0 && index < iceOrders.size()) {
				// ZHTW: 從列表中移除指定索引的訂單，並取得被移除的訂單 (可選)
				IceOrder removedOrder  = iceOrders.remove(index);
				System.out.println("成功刪除訂單 (索引 " + index + "): " + removedOrder.getMainDish().getName());
			} else {
				// ZHTW: 如果索引無效，印出錯誤訊息
				System.err.println(" 刪除失敗：無效的索引 " + index);
			}
		} catch (NumberFormatException e) {
			// ZHTW: 如果索引字串無法轉換為數字，印出錯誤訊息
			System.err.println("刪除失敗：索引格式錯誤 " + indexStr);
		} catch (Exception e) {
			// ZHTW: 捕捉其他可能的執行時期錯誤
			System.err.println(" 刪除訂單時發生錯誤 (索引 " + indexStr + "): " + e.getMessage());
			e.printStackTrace(); // ZHTW: 在伺服器控制台印出詳細的錯誤堆疊，方便除錯
		}
	}

	/**
	 * ZHTW:
	 * 處理新增訂單的邏輯。
	 * 從請求中讀取主餐 (mainDish) 和 配料 (toppings) 的參數，
	 * 建立一個新的 IceOrder 物件，並將其加入到 iceOrders 列表中。
	 */
	private void addAvtion(HttpServletRequest req) {
		// ZHTW: 接收表單提交的主餐名稱 (單選)
		String mainDishName = req.getParameter("mainDish");
		// ZHTW: 接收表單提交的配料名稱 (多選，可能為 null 或空陣列)
		String[] toppingArray = req.getParameterValues("toppings");

		// ZHTW: 確保主餐名稱有效 (不是 null 且去除前後空白後不是空字串)
		if(mainDishName!= null && !mainDishName.trim().isEmpty()) {
			// ZHTW: 建立 IceOrder 物件
			IceOrder iceOrder = new IceOrder(mainDishName, toppingArray);
			// ZHTW: 將新訂單加入到共享的訂單列表中
			iceOrders.add(iceOrder);
			System.out.println("ZHTW: 成功新增訂單: " + mainDishName);
		} else {
			// ZHTW: 如果沒有選擇主餐，印出錯誤訊息
			System.err.println("ZHTW: 新增訂單失敗：未選擇主餐。");
		}
	}
}
