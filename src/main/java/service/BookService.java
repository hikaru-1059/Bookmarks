package service;

import java.util.List;

import dao.BooksDAO;
import model.Book;

public class BookService {
	// DAOクラスのインスタンスを保持（DB操作はDAOに任せる）
	private BooksDAO dao = new BooksDAO();

	//全従業員情報を取得します。

	public List<Book> getAllBooks() {
		return dao.findAll();
	}
}
