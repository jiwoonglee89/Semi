<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>기업신고</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="declare/assets/css/main.css" />
</head>


	<c:if test="${success==0}">
	<body>
	<section id="footer">
	
		<div class="container">
		
			<header class="major">
			
				<h2>기업신고</h2>
				<table width="600" border="1" cellspacing="0" cellpadding="3" align="center">
					<tr>
						<td width="200">글제목</td>
						<td width="400">${m_title}</td>
					</tr>
					<tr>
						<td width="200">기업명</td>
						<td width="400">${coBean.co_com}</td>
					<tr>
						<td width="200">담당자이름</td>
						<td width="400">${coBean.co_name}</td>
					</tr>
					<tr>
						<td width="200">담당자연락처</td>
						<td width="400">${coBean.co_phone}</td>
					</tr>
					<tr>
						<td width="200">담당자E-Mail</td>
						<td width="400">${coBean.co_email}</td>
					</tr>
					</table>
			</header>
			<form method="post" action="declare/per2co_declarePro.do">
				<input type="hidden" name="co_id" value="${co_id}"/>
				<div class="row uniform">
					<div class="12u$">
						<textarea name="reason" id="reason" placeholder="신고사유"rows="4"></textarea>
					</div>
					<div class="12u$">
						<ul class="actions">
							<li><input type="submit" value="신고하기" class="special" /></li>
							<li><input type="button" value="닫기" class="special" 
							onclick="javascript:window.location='person/p_messageList.do'"/></li>
						</ul>
					</div>
				</div>
			</form>
			
		</div>
		
	</section>
	</c:if>
	
	<c:if test="${success==1}">
	<section id="footer">
	
		<div class="container">
			<div class="12u$">
						<ul class="actions">
							<li>신고되었습니다</li>
							<li><input type="button" value="닫기" class="special"
							onclick="javascript:window.location='person/p_messageList.do'" /></li>
						</ul>
			</div>
		</div>
		
	</section>
	</c:if>
	
	<!-- Scripts -->
	<script src="declare/assets/js/jquery.min.js"></script>
	<script src="declare/assets/js/jquery.scrollex.min.js"></script>
	<script src="declare/assets/js/jquery.scrolly.min.js"></script>
	<script src="declare/assets/js/skel.min.js"></script>
	<script src="declare/assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="declare/assets/js/main.js"></script>
	
</body>
</html>
