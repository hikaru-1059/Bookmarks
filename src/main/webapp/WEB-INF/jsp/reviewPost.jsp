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
	<p>レビュー登録</p>
	<img src="${pageContext.request.contextPath}${book.imagePath}"
		alt="${book.title}" width="120">
	<h1>${book.title}</h1>
	<h2>${book.author}</h2>
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
	
	<form action="BookDetailServlet" method="post">
		<textarea name="comment" placeholder="感想やコメントを入力してください" rows="10" cols="80"></textarea>
		<input type="submit" name="action" value="登録" class="post">
		<input type="submit" name="action" value="戻る" class="return">
	</form>
	<footer>
		<p>©Bookmarks</p>
	</footer>
</body>
</html>