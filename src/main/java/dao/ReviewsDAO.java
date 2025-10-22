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
		String sql = "SELECT R.REVIEW_ID, R.USER_ID, R.BOOK_ID, SCORE, COMMENT, U.NICKNAME AS USER_NAME "
				+ "FROM REVIEWS AS R "
				+ "JOIN USER AS U "
				+ "ON R.USER_ID = U.USER_ID "
				+ "WHERE R.BOOK_ID = ? "
				+ "ORDER BY R.REVIEW_ID DESC";

		// try-with-resources文を使うことで、close処理を自動で行ってくれる
		try (Connection conn = DBManager.getConnection(); // DBに接続
				PreparedStatement pStmt = conn.prepareStatement(sql)) { // SQLを準備

			pStmt.setInt(1, bookId);
			ResultSet rs = pStmt.executeQuery(); // SQLを実行し、結果を取得

			// 結果セットから1件ずつ取り出す
			while (rs.next()) {
				Review review = new Review(
						rs.getInt("REVIEW_ID"),
						rs.getInt("USER_ID"),
						rs.getInt("BOOK_ID"),
						rs.getDouble("SCORE"),
						rs.getString("COMMENT"),
						rs.getString("USER_NAME"));
				reviewList.add(review); // リストに追加
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null; // 例外発生時は null を返す
		}

		return reviewList;
	}

	//	レビュー登録用
	public boolean addReview(Review review) {
		String sql = "INSERT INTO REVIEWS (USER_ID, BOOK_ID, SCORE, COMMENT) VALUES (?, ?, ?, ?)";

		try (Connection conn = DBManager.getConnection(); // DBに接続
				PreparedStatement pStmt = conn.prepareStatement(sql)) { // SQLを準備

			// プレースホルダに値をセット
			pStmt.setInt(1, review.getUserId());
			pStmt.setInt(2, review.getBookId());
			pStmt.setDouble(3, review.getScore());
			pStmt.setString(4, review.getComment());

			// 実行結果（影響を受けた行数）を取得
			int rows = pStmt.executeUpdate();
			return rows > 0; // 1件以上登録できれば成功

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
