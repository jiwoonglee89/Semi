<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<c:if test="${kind==1}">
	개인

	<c:forEach var ="i" items="${reasonList}">
		<p>아이디 : ${i.p_id}</p>
		<p>신고사유: ${i.reason}</p></br></br>
	</c:forEach>
</c:if>
<c:if test="${kind==2}">
	기업
	
	<c:forEach var ="i" items="${reasonList}">
		<a>아이디 : ${i.co_id}</a>
		<p>신고사유: ${i.reason}</p></br></br>
	</c:forEach>
</c:if>


</body>
</html>