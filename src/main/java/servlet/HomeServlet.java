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

import model.Book;
import service.BookService;
import service.ReviewService;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	private ReviewService reviewService = new ReviewService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// BookServiceを使って書籍を取得
		List<Book> bookList = bookService.getAllBooks();

		// JSPに渡すためにリクエストスコープにセット
		request.setAttribute("bookList", bookList);

		// 本IDごとの平均スコアを保持するMap
		Map<Integer, Double> avgScores = new HashMap<>();

		for (Book book : bookList) {
			double avg = reviewService.getAverageScore(book.getBookId());
			avgScores.put(book.getBookId(), avg);
		}

		request.setAttribute("avgScores", avgScores);

		// 表示するJSPの場所を指定
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		rd.forward(request, response);
	}
}
