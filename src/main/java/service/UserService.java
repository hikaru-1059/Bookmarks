package service;

import dao.UserDAO;
import model.Login;
import model.User;

public class UserService {
	private UserDAO dao = new UserDAO();

	public boolean registerUser(User user) {
		// メール重複チェック
		if (dao.existsByEmail(user.getEmail())) {
			return false; // 登録NG
		}
		// DBにINSERT
		return dao.insert(user);
	}

	// ログイン処理
	public Login loginUser(String email, String password) {
		User user = dao.findByEmail(email);

		if (user == null) {
			return new Login("email_not_found", null);
		}

		if (!user.getPassword().equals(password)) {
			return new Login("password_incorrect", null);
		}

		// 成功したらユーザー情報も返す
		return new Login("success", user);
	}
}
