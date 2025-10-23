package model;

import java.io.Serializable;

public class Login implements Serializable {
	private String status; // "success" / "email_not_found" / "password_incorrect"
	private User user;

	public Login(String status, User user) {
		this.status = status;
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public User getUser() {
		return user;
	}
}
