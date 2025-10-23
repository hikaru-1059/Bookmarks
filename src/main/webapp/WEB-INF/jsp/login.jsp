<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
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
	<h1>ログイン</h1>
	<c:if test="${not empty msg}">
		<p class="error-message">${msg}</p>
	</c:if>
	<div class="user-login">
		<form action="LoginServlet" method="post">
			<div>
				<label for="email">メールアドレス</label><br> <input type="text"
					id="email" name="email" required>
			</div>
			<div>
				<label for="password">パスワード(半角英数8文字)</label><br> <input
					type="password" id="password" name="password" required>
			</div>
			<div>
				<input type="submit" value="ログイン">
			</div>
		</form>
		<a href="#">パスワードを忘れてしまった方はこちら</a>
		<form action="BookListServlet" method="get" class="return">
			<input type="submit" value="戻る">
		</form>
	</div>
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>