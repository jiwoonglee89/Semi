<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<title>관리자페이지 신고사유</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>

<body>

	<section id="footer">
		<div class="container">
			<header class="major">
				<h2>신고목록</h2>
				<c:if test="${count == 0}">
					<table width="700" border="1" cellpadding="0" cellspacing="0">
						<tr>
							<td align="center">board is empty!</td>
						</tr>
					</table>
				</c:if>
				<c:if test="${count > 0}">
					<table width="600" border="1" cellspacing="0" cellpadding="3"
						align="center">
						<tr>
							<td align="center" width="250">제목</td>
							<td align="center" width="250">${m_title}</td>
						</tr>


						<c:forEach var="article" items="${articleList}">
							<tr height="30">
								<td align="center" width="50"><c:out value="${number}" />
									<c:set var="number" value="${number - 1}" /></td>

								<td width="250"><c:if test="${article.re_level > 0}">
										<%-- getter 메서드 호출!! --%>
										<img src="images/level.gif" width="${5 * article.re_level}"
											height="16">
										<img src="images/re.gif">
									</c:if> <c:if test="${article.re_level == 0}">
										<img src="images/level.gif" width="${5 * article.re_level}"
											height="16">
									</c:if> <a
									href="/MarJSP/mvc_board/content.do?num=${article.num}&pageNum=${currentPage}">
										<%-- context root, key 값 --%> ${article.subject}
								</a> <c:if test="${article.readcount >= 20}">
										<img src="images/hot.gif" border="0" height="16">
									</c:if></td>

								<td align="center" width="100"><a
									href="mailto:${article.email}">${article.writer}</a></td>

								<td align="center" width="150">${article.reg_date}</td>
								<td align="center" width="50">${article.readcount}</td>
								<td align="center" width="100">${article.ip}</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</header>
			<form method="post" action="#">
				<div class="row uniform">
					<div class="12u$">
						<textarea name="reason" id="reason" placeholder="신고사유"rows="4"></textarea>
					</div>
					<div class="12u$">
						<ul class="actions">
							<li><input type="submit" value="신고하기" class="special" /></li>
							<li><input type="button" value="닫기" class="special" /></li>
						</ul>
					</div>
				</div>
			</form>
		</div>
	</section>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>

</body>
</html>