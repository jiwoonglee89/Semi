<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="DB.Co_MemBean"%>
<%@ include file="./view/color.jspf"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<body>
<c:if test="${success==0 }">
<script>alert("회원가입에실패하였습니다 정보를 다시 입력해주세요")</script>
<c:redirect url="co_inputForm.do"></c:redirect>
</c:if>

<c:if test="${success!=0 }">
<script>alert("회원가입에성공하였습니다")</script>
<c:redirect url="/main.do"></c:redirect>
</c:if>

</body>
<link href="style.css" rel="stylesheet" type="text/css">

<table width="270" border="0" cellspacing="0" cellpadding="5" align="center">
	<c:if test="${success!=0 }">
	<tr bgcolor="${title_c}">
		<td height="39" align="center">
		<font size="+1">
		<b>회원정보가수정되었습니다.</b>
		</font>
   
		</td>
	</tr>
	<tr>
		<td bgcolor="${value_c}" align="center">
			<p>입력하신 내용대로 수정이 완료되었습니다.</p>
		</td>
	</tr>
	<tr>
		<td bgcolor="${value_c}" align="center">
			<form>
				<input type="button" value="메인으로" onclick="window.location='main.jsp'">
			</form> 5초후에 메인으로 이동합니다.
			<meta http-equiv="Refresh" content="5;url=main.jsp">
		
		</td>
	</tr>
</table>
</body>
</html>