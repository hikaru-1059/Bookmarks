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
	<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
	<div class="book-img">
	<img src="${pageContext.request.contextPath}${book.imagePath}"
		alt="${book.title}" width="120">
	</div>
	<h1>${book.title}</h1>
	<h2>${book.author}</h2>
	
	<!--	エラーメッセージ表示用-->
	<c:if test="${not empty errorMsg}">
  		<p style="color:red;">${errorMsg}</p>
	</c:if>
	
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
	
	<!--	スライダーの表示-->
	<div class="star">
  		<input type="range" id="scoreSlider" name="slider" min="0" max="5" step="0.1" value="0">
  		<div class="star-preview" id="starPreview" style="--fill: 0%;">★★★★★</div>
  		<span id="scoreText">0.0</span>
	</div>
	
	<!--	登録フォーム-->
	<form action="BookDetailServlet" method="post">
		<input type="hidden" name="bookId" value="${book.bookId}">
    		<input type="hidden" id="scoreInput" name="score" value="0">
		<textarea name="comment" placeholder="感想やコメントを入力してください" rows="10" cols="80"></textarea>
		<input type="submit" name="action" value="登録" class="post">
		<input type="submit" name="action" value="戻る" class="return">
	</form>
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	
	<script>
	  const slider = document.getElementById("scoreSlider");
	  const preview = document.getElementById("starPreview");
	  const scoreText = document.getElementById("scoreText");
	  const scoreInput = document.getElementById("scoreInput");
	
	//スライダー操作で星と数値更新
	  slider.addEventListener("input", () => {
	    const score = parseFloat(slider.value);
	    const fill = (score / 5) * 100;
	    preview.style.setProperty("--fill", fill + "%");
	    scoreText.textContent = score.toFixed(1);
	    scoreInput.value = score.toFixed(1);
	  });
	</script>
</body>
</html>