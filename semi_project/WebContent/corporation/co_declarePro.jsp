<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title></title>
</head>
<body>
<c:if test="${success>0 }">
성공적으로 신고되었습니다.<br>
<a href="co_main.do"> 목록보기</a>
</c:if>
<c:if test="${success<=0 }">
신고가 실패되었습니다.<br>
<a href="co_main.do"> 목록보기</a>
</c:if>
</body>
</html>