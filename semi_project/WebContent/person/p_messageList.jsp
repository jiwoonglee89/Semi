<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="declare/assets/css/main.css" />
</head>

<body>
	<section id="footer">

		<div class="container">
			메세지리스트
			<hr />
			<table border="2 solid 2px">
				<tr>
					<td>회사이름</td>
					<td align="center" >쪽지제목</td>
					<td align="center">보낸시간</td>
					<td align="center">확인여부</td>
					<td align="center">내용조회</td>
					<td align="center">신고하기</td>

				</tr>
				<c:forEach var="i" items="${dataList}">
					<input type="hidden" value="${i.m_num}" name="m_num" />

					<tr>
						<td>${i.co_com}</td>
						<td><a href="p_messageView.do">${i.m_title}</a></td>
						<td>${i.m_regdate}</td>
						<td>${i.m_countdes}</td>
						<td><form action="p_messageView.do" method="get">
								<input type="hidden" name="m_num" value="${i.m_num}" /> <input
									type="submit" value="상세조회" />
							</form></td>
						<td><form action="per2co_declareForm.do" method="get">
								<input type="hidden" name="m_num" value="${i.m_num}" /> <input
									type="hidden" name="co_id" value="${i.co_id}" /> <input
									type="submit" value="신고" />
							</form></td>

					</tr>
				</c:forEach>

			</table>
		</div>

	</section>

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