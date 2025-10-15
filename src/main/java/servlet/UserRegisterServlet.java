package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service = new UserService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//フォームに入力された値を取得
		String name = request.getParameter("nickname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		//パスワードと確認用パスワードの一致確認
		if (!password.equals(password2)) {
	        request.setAttribute("msg", "パスワードが一致しません。");
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp");
	        rd.forward(request, response);
	        return; // 処理中断！
	    }
		
		User user = new User(name, email, password);

		boolean result = service.registerUser(user);
		System.out.println("登録結果：" + result);


		if (result) {
			request.setAttribute("msg", "ユーザー登録が完了しました！");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/registerSuccess.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("msg", "このメールアドレスは既に登録されています。");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp");
			rd.forward(request, response);
		}
	}

}
