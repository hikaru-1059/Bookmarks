package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BooksDAO {
	//BOOKSテーブルの全件を取得します。
	public List<Book> findAll() {
		// 結果を格納するリスト
		List<Book> bookList = new ArrayList<>();
		// 実行するSQL文
		String sql = "SELECT * FROM BOOKS";

		// try-with-resources文を使うことで、close処理を自動で行ってくれる
		try (Connection conn = DBManager.getConnection(); // DBに接続
				PreparedStatement pStmt = conn.prepareStatement(sql); // SQLを準備
				ResultSet rs = pStmt.executeQuery()) { // SQLを実行し、結果を取得

			// 結果セットから1件ずつ取り出す
			while (rs.next()) {
				Book book = new Book(
						rs.getInt("BOOK_ID"),
						rs.getString("TITLE"),
						rs.getString("AUTHOR"),
						rs.getString("GENRE1"),
						rs.getString("GENRE2"),
						rs.getString("GENRE3"),
						rs.getString("SYNOPSIS"),
						rs.getString("IMAGE_PATH"));
				bookList.add(book); // リストに追加
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null; // 例外発生時は null を返す
		}

		return bookList;
	}
}
