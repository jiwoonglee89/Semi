<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./view/color.jspf" %>
<!DOCTYPE html>
<html>
<title>ID 중복확인</title>
<link href="view/style.css" rel="stylesheet" type="text/css">
<% request.setCharacterEncoding("UTF-8"); %>

<body bgcolor="${bodyback_c}">
 
<c:if test="${check == 1}">
<table width="270" border="0" cellspacing="0" cellpadding="5">
	<tr bgcolor="${title_c}">
		<td height="39">${co_id}이미 사용중인 아이디입니다.</td>
	</tr>
</table>
<form name="checkForm" method="post" action="confirmId.do">
<table width="270" border="0" cellspacing="0" cellpadding="5">
	<tr>
		<td bgcolor="${value_c}" align="center">
		<p>다른 아이디를 선택하세요.</p>
		<input type="text" size="10" maxlength="12" name="id">
		<input type="submit" value="ID중복확인">
	</td>
	</tr>
</table>
</form>
</c:if>

<c:if test="${check==-1}">
<table width="270" border="0" cellspacing="0" cellpadding="5">
	<tr bgcolor="${title_c}">
		<td align="center">
		<p>입력하신 ${param.id}는 사용하실 수 있는 ID입니다.</p>
		<input type="button" value="닫기" onclick="setid()">
		</td>
	</tr>
</table>
</c:if>
</body>
</html>
<script>
	function setid(){
		opener.document.userinput.id.value="${param.id}";
		self.close();
	}
</script>