<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

  <div class="book-detail-container">
    <!-- 左側：本の画像 -->
    <div class="book-image">
      <img src="${pageContext.request.contextPath}${book.imagePath}" alt="${book.title}">
    </div>

    <!-- 右側：本の情報 -->
    <div class="book-info">
      <h1>${book.title}</h1>
      <h2>${book.author}</h2>

	<!--	スコアを0.1刻みの★で表示-->
	<div class="avg-score-container">
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
	</div>
	
	<hr class="review-divider">
	
      <!-- スライダー -->
      <div class="star">
        <input type="range" id="scoreSlider" name="slider" min="0" max="5" step="0.1" value="0">
        <div class="star-preview" id="starPreview" style="--fill: 0%;">★★★★★</div>
        <span id="scoreText">0.0</span>
      </div>

      <!-- コメントフォーム -->
      <form action="BookDetailServlet" method="post" class="review-form">
        <input type="hidden" name="bookId" value="${book.bookId}">
        <input type="hidden" id="scoreInput" name="score" value="0">
        <textarea name="comment" placeholder="感想やコメントを入力してください"></textarea>

        <div class="form-buttons">
          <input type="submit" name="action" value="登録" class="post">
          <input type="submit" name="action" value="戻る" class="return">
        </div>
      </form>
    </div>
  </div>

  <jsp:include page="/WEB-INF/jsp/common/footer.jsp" />

  <script>
    const slider = document.getElementById("scoreSlider");
    const preview = document.getElementById("starPreview");
    const scoreText = document.getElementById("scoreText");
    const scoreInput = document.getElementById("scoreInput");

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
