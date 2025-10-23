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
	<h1>レビュー登録が完了しました</h1>
	<form action="BookDetailServlet" method="post">
		<input type="submit" name="action" value="戻る" class="return">
	</form>
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>