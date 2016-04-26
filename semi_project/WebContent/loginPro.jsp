<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<c:if test="${select==2}">
<c:redirect url="corporation/co_main.jsp"></c:redirect>
</c:if>
<c:if test="${select==1 }">
<c:redirect url="person/p_mainview.jsp"></c:redirect>
</c:if>
</body>
</html>