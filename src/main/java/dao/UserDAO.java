package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {
	//ユーザー登録用
	public boolean insert(User user) {
		String sql = "INSERT INTO USER (NICKNAME, EMAIL, PASSWORD) VALUES (?, ?, ?)";
		try (Connection conn = DBManager.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, user.getNickName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());

			int result = stmt.executeUpdate();
			return result == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//メールアドレスが重複していないか確認する用
	public boolean existsByEmail(String email) {
		String sql = "SELECT * FROM USERS WHERE EMAIL = ?";
		try (Connection conn = DBManager.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			return rs.next(); // 既に登録済みならtrue

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// ログイン用(メールアドレスからユーザー情報を取得する)
    public User findByEmail(String email) {
        String sql = "SELECT * FROM user WHERE email = ?";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement pStmt = conn.prepareStatement(sql)) {

            pStmt.setString(1, email);
            ResultSet rs = pStmt.executeQuery();

            if (rs.next()) {
                // 1件だけ取得
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setNickName(rs.getString("nickname"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // 見つからなかった場合
    }
}
