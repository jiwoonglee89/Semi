<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<title>메시지 보내기</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="../declare/assets/css/main.css" />
</head>

<body>

	<section id="footer">
		<div class="container">
			<header class="major">
				<h2>메세지 보내기</h2>
					<table width="600" border="1" cellspacing="0" cellpadding="3" align="center">
					<tr>
						<td width="200">사용자 ID</td>
						<td width="400">${person.p_id}</td>
					<tr>
						<td width="200">사용자 이름</td>
						<td width="400">${person.p_name}</td>
					</tr>
				</table>
			</header>
			<form method="post" action="co_messagePro.do">
				<div class="row uniform">
					<div class="12u$">
						<textarea name="m_title" id="m_title" placeholder="제목" rows="4"></textarea>
					</div>
					<div class="12u$">
						<textarea name="m_context" id="m_context" placeholder="내용" rows="4"></textarea>
					</div>
					<div class="12u$">
						<ul class="actions">
							<li><input type="submit" value="메세지 보내기" class="special" /></li>
							<li><input type="button" value="닫기" class="special" onclick="javascript:window.close()"/></li>
							<input type="hidden" name="id" value="${person.p_id}">
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