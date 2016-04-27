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
						<tr><td align="center">board is empty!</td></tr>
					</table>
				</c:if>

				<table>
					<c:forEach var="i" items="${dataList}">
						<c:set var="reason" value="${i.reason}" />
						<tr>
							<td>${reason}</td>
						</tr>
					</c:forEach>
				</table>

			</header>
			<form method="post" action="#">
				<div class="row uniform">
				
					<div class="12u$">
						<ul class="actions">
							<li><input type="button" value="확인" class="special" /></li>
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
	<script src="assets/js/main.js"></script>

</body>
</html>