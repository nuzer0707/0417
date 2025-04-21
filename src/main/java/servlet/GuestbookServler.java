package servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Guestbook;


@WebServlet("/guestbook")
public class GuestbookServler extends HttpServlet {

	private static final List<Guestbook> guestbooks = new CopyOnWriteArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/guestbook_form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String message = req.getParameter("message");
		
		Guestbook guestbook = new Guestbook(message);
		
		guestbooks.add(guestbook);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/guestbook_result.jsp");
		
		req.setAttribute("message", message);
		req.setAttribute("guestbooks", guestbooks);
		rd.forward(req, resp);
	}
	
	
	
}
