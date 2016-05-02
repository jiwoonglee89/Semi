<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>deleteFile</title>
</head>
<body>
${f_filename}을삭제하시겠습니까?
<form action="filedeletePro.do" method="post">
	<input type="submit" value="삭제"/>
	<input type="hidden" name="f_filename" value="${f_filename}"/>
	<input type="button" value="아니오" onclick="javascript:window.location='p_detail.do'"/>
</form>

</body>
</html>