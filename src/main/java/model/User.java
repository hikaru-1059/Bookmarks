package model;

import java.io.Serializable;

public class User implements Serializable {
	//フィールド
	private int userId;
	private String nickName;
	private String email;
	private String password;

	//コンストラクタ
	public User() {

	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public User(String nickName, String email, String password) {
		this.nickName = nickName;
		this.email = email;
		this.password = password;
	}
	
	public User(int userId, String nickName, String email, String password) {
		this.userId = userId;
		this.nickName = nickName;
		this.email = email;
		this.password = password;
	}

	//getter setter
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
