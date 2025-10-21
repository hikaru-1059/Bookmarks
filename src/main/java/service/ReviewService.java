package service;

import java.util.List;

import dao.ReviewsDAO;
import model.Review;

public class ReviewService {
	// DAOクラスのインスタンスを保持（DB操作はDAOに任せる）
	private ReviewsDAO dao = new ReviewsDAO();

	// 特定の本のレビュー一覧を取得
	public List<Review> getReviewsByBookId(int bookId) {
		return dao.findByBookId(bookId);
	}

	// 特定の本の平均スコアを取得
	public double getAverageScore(int bookId) {
		List<Review> reviews = dao.findByBookId(bookId);

		if (reviews == null || reviews.isEmpty()) {
			return 0.0; //レビューがない場合は0
		}

		double total = 0;
		for (Review r : reviews) {
			total += r.getScore();
		}

		// 平均値を少数1桁にする
		double avg = Math.round((total / reviews.size()) * 10.0) / 10.0;
		return avg;
	}
}
