<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookmarks</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
	<h1>ユーザー登録が完了しました</h1>
	<form action="LoginServlet" method="get" class="login">
		<input type="submit" value="ログイン">
	</form>
	<form action="BookListServlet" method="get" class="top">
		<input type="submit" value="TOPページ">
	</form>
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>