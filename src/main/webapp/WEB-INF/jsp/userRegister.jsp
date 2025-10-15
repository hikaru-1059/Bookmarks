<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookmarks</title>
</head>
<body>
	<header>Bookmarks</header>
	<h1>ユーザー登録</h1>
	<c:if test="${not empty msg}">
    		<p class="error-message">${msg}</p>
	</c:if>
	<div class="user-register">
		<form action="UserRegisterServlet" method="post">
			<div>
				<label for="email">メールアドレス</label><br>
				<input type="text" id="email" name="email" required>
			</div>
			<div>
				<label for="password">パスワード(半角英数8文字)</label><br>
				<input type="password" id="password" name="password" required>
			</div>
			<div>
				<label for="password2">パスワード(確認用)</label><br>
				<input type="password" id="password2" name="password2" required>
			</div>
			<div>
				<label for="nickname">ニックネーム</label><br>
				<input type="text" id="nickname" name="nickname" required>
			</div>
			<div>
				<input type="submit" value="登録">
			</div>
		</form>
	</div>
	<form action="BookListServlet" method="get" class="return">
		<input type="submit" value="戻る">
	</form>
	<footer>
		<p>©Bookmarks</p>
	</footer>
</body>
</html>