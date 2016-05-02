<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${success != 0}">
<meta http-equiv="Refresh" content="0; url=Per_fileModifyPro.do?f_fliename=${file.f_filename}" >
성공적으로 수정 되었습니다.
</c:if>

<br>
<a href="javascript:history.go(-1)">[파일 수정 폼으로 돌아가기]</a>
