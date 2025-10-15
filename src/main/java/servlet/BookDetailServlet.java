package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Book;
import service.BookService;


/**
 * Servlet implementation class BookDetailServlet
 */
@WebServlet("/BookDetailServlet")
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService service = new BookService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// パラメータを取得
        String idStr = request.getParameter("bookId");
        int bookId = Integer.parseInt(idStr);

        // DBから詳細情報を取得
        Book book = service.getBookById(bookId);

        // JSPに渡す
        request.setAttribute("book", book);

        // 詳細ページへフォワード
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/bookDetail.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
