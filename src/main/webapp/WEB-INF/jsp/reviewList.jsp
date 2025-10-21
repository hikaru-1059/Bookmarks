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
	<header>Bookmarks</header>
	<p>レビュー一覧</p>
	<img src="${pageContext.request.contextPath}${book.imagePath}"
		alt="${book.title}" width="120">
	<h1>${book.title}</h1>
	<h2>${book.author}</h2>

	<!--	スコアを0.1刻みの★で表示-->
	<c:set var="avgScore" value="${avgScores[book.bookId]}" />
	<div class="avg-star-box" style="--fill: ${(avgScore / 5.0) * 100}%;">
		★★★★★</div>
	<span class="avg-score"> <c:choose>
			<c:when test="${avgScore != 0}">
	      ${avgScore}
	    </c:when>
			<c:otherwise>-</c:otherwise>
		</c:choose>
	</span>

	<!--	レビュー表示-->
	<c:choose>
		<c:when test="${not empty reviewList}">
			<c:forEach var="r" items="${reviewList}">
				<div class="review-box">
					<p>${r.userName} さんのレビュー</p>
					<div class="star-box" style="--fill: ${(r.score / 5.0) * 100}%;">★★★★★</div>
					<p>${r.comment}</p>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>まだレビューは投稿されていません。</p>
		</c:otherwise>
	</c:choose>

	<form action="BookDetailServlet" method="post">
		<input type="submit" name="action" value="戻る" class="return">
	</form>

	<footer>
		<p>©Bookmarks</p>
	</footer>
</body>
</html>