<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<c:if test="${kind==1}">
	����

	<c:forEach var ="i" items="${reasonList}">
		<p>���̵� : ${i.p_id}</p>
		<p>�Ű����: ${i.reason}</p></br></br>
	</c:forEach>
</c:if>
<c:if test="${kind==2}">
	���
	
	<c:forEach var ="i" items="${reasonList}">
		<a>���̵� : ${i.co_id}</a>
		<p>�Ű����: ${i.reason}</p></br></br>
	</c:forEach>
</c:if>


</body>
</html>