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
	<table border="2 solid 2px">
		<c:forEach var="i" items="${dataList}">
			i.co_com::::${i.co_com}
			<tr>
				<td>${i.co_com}</td>
				<td><a href="p_messageView.do">${i.m_title}</a></td>
				<td>${i.m_regdate}</td>
				<td>${i.m_countdes}</td>
				<td><input type ="hidden" name="co_id" value="${i.co_id}"/></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>