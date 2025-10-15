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
	<a href="#">マイページ</a>
	<a href="#">ログアウト</a>
	<header>Bookmarks</header>
	<form action="#">
		<input type="text" id="keyword" placeholder="検索キーワード">
		<input type="submit" value="検索">
	</form>
	<c:forEach var="book" items="${bookList}">
		<div class="book-item">
			<a href="${pageContext.request.contextPath}/BookDetailServlet?bookId=${book.bookId}" class="book-link">
				<img src="${pageContext.request.contextPath}${book.imagePath}"
					alt="${book.title}" width="240">
			</a>
			<p>${book.title}</p>
			<div class="icons">
				<button class="btn-read">読書済み</button>
				<button class="btn-bookmark">ブックマーク</button>
				<button class="btn-score">スコア</button>
			</div>
		</div>
	</c:forEach>
	<footer>
		<p>©Bookmarks</p>
	</footer>
</body>
</html>