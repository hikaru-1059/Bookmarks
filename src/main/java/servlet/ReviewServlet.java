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
import model.Review;
import service.ReviewService;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService service = new ReviewService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch(action) {
		case "レビューを見る" -> {
			int bookId = Integer.parseInt(request.getParameter("bookId"));
            List<Review> reviewList = service.getReviewsByBookId(bookId);
            double avgScore = service.getAverageScore(bookId);

            Book book = (Book) request.getSession().getAttribute("book");
            request.setAttribute("book", book);
            request.setAttribute("reviewList", reviewList);
            request.setAttribute("avgScore", avgScore);
			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/reviewList.jsp");
			rd.forward(request, response);
		}
		case "レビューを投稿する" -> {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/reviewPost.jsp");
			rd.forward(request, response);
		}
		}
	}

}
