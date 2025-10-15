package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Book;
import service.BookService;
import service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	private BookService bookService = new BookService();

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

		String result = userService.loginUser(email, password);

		switch (result) {
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
			// BookServiceを使って書籍を取得
	        List<Book> bookList = bookService.getAllBooks();

	        // JSPに渡すためにリクエストスコープにセット
	        request.setAttribute("bookList", bookList);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
			rd.forward(request, response);
		}
		}
	}
}
