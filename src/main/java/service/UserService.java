package service;

import dao.UserDAO;
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
	public String loginUser(String email, String password) {
		User user = dao.findByEmail(email);

		if (user == null) {
			// メールが登録されていない
			return "email_not_found";
		}
		if (!user.getPassword().equals(password)) {
			// パスワードが間違っている
			return "password_incorrect";
		}
		// ログイン成功
		return "success";
	}
}
