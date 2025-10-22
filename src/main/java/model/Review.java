package model;

public class Review {
	//フィールド
	private int reviewId;
	private int userId;
	private int bookId;
	private double score;
	private String comment;
	private String userName;
	
	//コンストラクタ
	public Review() {
		
	}
	
	public Review(int reviewId, int userId, int bookId, double score, String comment, String userName) {
		this.reviewId = reviewId;
		this.userId = userId;
		this.bookId = bookId;
		this.score = score;
		this.comment = comment;
		this.userName = userName;
	}
	
	//getter setter
	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
