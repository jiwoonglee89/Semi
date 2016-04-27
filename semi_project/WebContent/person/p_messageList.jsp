<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>메세지리스트</title>
</head>
<body>
	메세지리스트
	<hr />
	<table>
		<c:forEach var="i" items="${dataList }">
			i.co_com::::${i.co_com}
			<tr>
				<td><a href="p_messageView.do">${i.co_com}</a></td>
				<td>${i.m_title}</td>
				<td>${i.m_regdate}</td>
				<td>${i.m_countdes}</td>
				<td></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>