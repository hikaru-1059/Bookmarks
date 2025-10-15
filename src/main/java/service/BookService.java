package service;

import java.util.List;

import dao.BooksDAO;
import model.Book;

public class BookService {
	// DAOクラスのインスタンスを保持（DB操作はDAOに任せる）
	private BooksDAO dao = new BooksDAO();

	//全書籍の情報を取得
	public List<Book> getAllBooks() {
		return dao.findAll();
	}
	
	public Book getBookById(int bookId) {
	    return dao.findById(bookId);
	}

}
