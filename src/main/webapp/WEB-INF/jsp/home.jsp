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
	<a href="LogoutServlet">ログアウト</a>
	<header>Bookmarks</header>
	<form action="#">
		<input type="text" id="keyword" placeholder="検索キーワード"> <input
			type="submit" value="検索">
	</form>
	<c:forEach var="book" items="${bookList}">
		<div class="book-item">
			<a
				href="${pageContext.request.contextPath}/BookDetailServlet?bookId=${book.bookId}"
				class="book-link"> 
				<img src="${pageContext.request.contextPath}${book.imagePath}"
				alt="${book.title}" width="240">
			</a>
			<p>${book.title}</p>
			<div class="icons">
				<button class="btn-read">読書済み</button>
				<button class="btn-bookmark">ブックマーク</button>
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
			</div>
		</div>
	</c:forEach>
	<footer>
		<p>©Bookmarks</p>
	</footer>
</body>
</html>