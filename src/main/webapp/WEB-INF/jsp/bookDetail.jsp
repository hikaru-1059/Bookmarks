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
	<p>書籍詳細</p>
	<img src="${pageContext.request.contextPath}${book.imagePath}"
		alt="${book.title}" width="360">
	<h1>${book.title}</h1>
	<h2>${book.author}</h2>
	<p>
		<strong>ジャンル</strong>
	</p>
	<p>${book.genre1}</p>
	<span class="score">
		<span>★</span>
		<span>
			<c:choose>
				<c:when test="${avgScores[book.bookId] != 0}">
					${avgScores[book.bookId]}
				</c:when>
				<c:otherwise>-</c:otherwise>
			</c:choose>
		</span>
	</span>
	<form action="ReviewServlet" method="post">
		<input type="submit" name="action" value="レビューを見る">
		<input type="submit" name="action" value="レビューを投稿する">
	</form>
	<p>
		<strong>あらすじ</strong>
	</p>
	<p>${book.synopsis}</p>
	<form action="BookListServlet" method="get" class="return">
		<input type="submit" value="戻る">
	</form>
	<footer>
		<p>©Bookmarks</p>
	</footer>
</body>
</html>