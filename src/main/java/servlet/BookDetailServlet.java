package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.ReviewsDAO;
import model.Book;
import model.Review;
import service.BookService;
import service.ReviewService;

/**
 * Servlet implementation class BookDetailServlet
 */
@WebServlet("/BookDetailServlet")
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	private ReviewService reviewService = new ReviewService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		// 本の情報を保存
		Book book = bookService.getBookById(bookId);
		HttpSession session = request.getSession();
		session.setAttribute("book", book);

		// スコアだけ個別に算出
		double avgScore = reviewService.getAverageScore(bookId);
		Map<Integer, Double> avgScores = new HashMap<>();
		avgScores.put(bookId, avgScore);
		session.setAttribute("avgScores", avgScores);

		// 詳細ページへフォワード
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/bookDetail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");

		switch (action) {
		case "登録" -> {
			int userId = 8;
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			double score = Double.parseDouble(request.getParameter("score"));
			String comment = request.getParameter("comment");

			// Reviewオブジェクトに詰める
			Review review = new Review();
			review.setUserId(userId);
			review.setBookId(bookId);
			review.setScore(score);
			review.setComment(comment);

			// DAOを使ってDBへ登録
			ReviewsDAO dao = new ReviewsDAO();
			boolean result = dao.addReview(review);

			if (result) {
				// 登録成功 → 完了画面にフォワード
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/reviewSuccess.jsp");
				rd.forward(request, response);
			} else {
				// 登録失敗 → エラーページにフォワード
				request.setAttribute("errorMsg", "レビューの登録に失敗しました。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/reviewPost.jsp");
				rd.forward(request, response);
			}
		}
		case "戻る" -> {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/bookDetail.jsp");
			rd.forward(request, response);
		}
		}
	}
}
