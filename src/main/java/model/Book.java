package model;

import java.io.Serializable;

public class Book implements Serializable {
	//フィールド
	public int bookId; //書籍id
	public String title; //書籍タイトル
	public String author; //著者名
	public String genre1; //ジャンル1
	public String genre2; //ジャンル2
	public String genre3; //ジャンル3
	public String synopsis; //あらすじ
	public String imagePath; //書籍画像

	//コンストラクタ
	public Book() {
	}

	public Book(int bookId, String title, String author, String genre1, String genre2, String genre3,
			String synopsis, String imagePath) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.genre1 = genre1;
		this.genre2 = genre2;
		this.genre3 = genre3;
		this.synopsis = synopsis;
		this.imagePath = imagePath;
	}
	
	//	getter setter
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre1() {
		return genre1;
	}

	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}

	public String getGenre2() {
		return genre2;
	}

	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}

	public String getGenre3() {
		return genre3;
	}

	public void setGenre3(String genre3) {
		this.genre3 = genre3;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
