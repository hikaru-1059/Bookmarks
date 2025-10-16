package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Review;

public class ReviewsDAO {
	public List<Review> findByBookId(int bookId) {
		// 結果を格納するリスト
		List<Review> reviewList = new ArrayList<>();
		// 実行するSQL文
		String sql = "SELECT * FROM REVIEWS WHERE BOOK_ID = ?";

		// try-with-resources文を使うことで、close処理を自動で行ってくれる
		try (Connection conn = DBManager.getConnection(); // DBに接続
				PreparedStatement pStmt = conn.prepareStatement(sql)){ // SQLを準備
				
				pStmt.setInt(1, bookId);
				ResultSet rs = pStmt.executeQuery(); // SQLを実行し、結果を取得

			// 結果セットから1件ずつ取り出す
			while (rs.next()) {
				Review review = new Review(
						rs.getInt("REVIEW_ID"),
						rs.getInt("BOOK_ID"),
						rs.getDouble("SCORE"));
				reviewList.add(review); // リストに追加
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null; // 例外発生時は null を返す
		}

		return reviewList;
	}
}
