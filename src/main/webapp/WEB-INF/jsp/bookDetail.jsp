<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookmarks</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
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
	<!--	スコアを0.1刻みの★で表示-->
	<c:set var="avgScore" value="${avgScores[book.bookId]}" />
		<div class="avg-star-box" style="--fill: ${(avgScore / 5.0) * 100}%;">
		  ★★★★★
		</div>
	<span class="avg-score">
	  <c:choose>
	    <c:when test="${avgScore != 0}">
	      ${avgScore}
	    </c:when>
	    <c:otherwise>-</c:otherwise>
	  </c:choose>
	</span>
	<form action="ReviewServlet" method="post">
		<input type="hidden" name="bookId" value="${book.bookId}">
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