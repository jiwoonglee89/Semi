<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
메세지리스트

<table>
<c:forEach var="i" items="${dataList }">
<c:set var="co_com" value="${i.co_com }"/>
<c:set var="m_title" value="${i.m_title }"/>
<c:set var="m_regdate" value="${i.m_regdate }"/>
<c:set var="m_countdes" value="${i.m_countdes }"/>
<tr><td>${co_com}</td><td>${m_title}</td><td>${m_regdate}</td><td>${m_countdes}</td></tr>
</c:forEach>

</table>
</body>
</html>