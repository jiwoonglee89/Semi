<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title></title>
</head>
<body>
<c:if test="${success>0 }">
���������� �Ű�Ǿ����ϴ�.<br>
<a href="co_main.do"> ��Ϻ���</a>
</c:if>
<c:if test="${success<=0 }">
�Ű� ���еǾ����ϴ�.<br>
<a href="co_main.do"> ��Ϻ���</a>
</c:if>
</body>
</html>