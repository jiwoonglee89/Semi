<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>세부정보</title>
</head>
<body>
<img src="/semi_project/File/${file.realpath}">
제목 : ${file.f_title }
설명 : ${file.f_description }
날짜 : ${file.f }

</body>
</html>