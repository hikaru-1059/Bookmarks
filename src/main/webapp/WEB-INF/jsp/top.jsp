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
	<div class="auth-links">
	<a href="UserRegisterServlet">会員登録</a>
	<a href="LoginServlet">ログイン</a>
	</div>
	<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
	<div class="search-box">
	<form action="#">
		<input type="text" id="keyword" placeholder="検索キーワード"> <input
			type="submit" value="検索">
	</form>
	</div>
	<div class="book-container">
		<c:forEach var="book" items="${bookList}">
			<div class="book-item">
				<a
					href="${pageContext.request.contextPath}/BookDetailServlet?bookId=${book.bookId}"
					class="book-link"> <img
					src="${pageContext.request.contextPath}${book.imagePath}"
					alt="${book.title}" width="240">
				</a>
				<p>${book.title}</p>
				<div class="icons">
					<a href="#"> <img
						src="${pageContext.request.contextPath}/images/icon/read_book.png"
						alt="読書済み">
					</a> <a href="#"> <img
						src="${pageContext.request.contextPath}/images/icon/favorite_book.png"
						alt="ブックマーク">
					</a> <span class="score"> <span>★</span> <span> <c:choose>
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
	</div>
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>
