<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<title>개인신고</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>

<body>

	<section id="footer">
		<div class="container">
			<header class="major">
				<h2>개인신고</h2>
				<table width="600" border="1" cellspacing="0" cellpadding="3" align="center">
					<tr>
						<td width="200">글제목</td>
						<td width="400">${m_title}</td>
					</tr>
					<tr>
						<td width="200">이름</td>
						<td width="400">${p_name}</td>
					<tr>
						<td width="200">E-Mail</td>
						<td width="400">${p_email}</td>
					</tr>
					<tr>
						<td width="200">분야</td>
						<td width="400">${p_category}</td>
					</tr>
				</table>
			</header>
			<form method="post" action="co_main.do">
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