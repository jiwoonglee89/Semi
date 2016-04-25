<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>업로드 성공</title>
</head>
<body>
	<c:if test="${success!= 0 }">
		${f_title } 을 업로드 하였습니다
	</c:if>
	<a href="p_mainview.do">목록보기</a>

</body>
</html>
















