package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Book;
import model.Login;
import service.BookService;
import service.ReviewService;
import service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	private BookService bookService = new BookService();
	private ReviewService reviewService = new ReviewService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//フォームに入力された値を取得
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Login login = userService.loginUser(email, password);
	    String status = login.getStatus();

		switch (status) {
		case "email_not_found" -> {
			request.setAttribute("msg", "登録されていないメールアドレスです。");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			rd.forward(request, response);
		}
		case "password_incorrect" -> {
			request.setAttribute("msg", "パスワードが違います");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			rd.forward(request, response);
		}
		case "success" -> {
			//セッションスコープ
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", login.getUser());
			
			// BookServiceを使って書籍を取得し保存
	        List<Book> bookList = bookService.getAllBooks();
	        request.setAttribute("bookList", bookList);
	        
			// 本IDごとの平均スコアを保持するMap
		    Map<Integer, Double> avgScores = new HashMap<>();

		    for (Book book : bookList) {
		        double avg = reviewService.getAverageScore(book.getBookId());
		        avgScores.put(book.getBookId(), avg);
		    }
			
		    request.setAttribute("avgScores", avgScores);
	        
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
			rd.forward(request, response);
		}
		}
	}
}
