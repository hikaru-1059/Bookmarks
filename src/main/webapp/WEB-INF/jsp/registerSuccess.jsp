<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookmarks</title>
</head>
<body>
	<h1>ユーザー登録が完了しました</h1>
	<form action="LoginServlet" method="get" class="login">
		<input type="submit" value="ログイン">
	</form>
	<form action="BookListServlet" method="get" class="top">
		<input type="submit" value="TOPページ">
	</form>
</body>
</html>