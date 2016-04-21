<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="DB.Co_MemBean"%>
<%@ include file="./view/color.jspf"%>
<html>
<head>
<title>ID 중복확인</title>
<link href="style.css" rel="stylesheet" type="text/css">

<% request.setCharacterEncoding("utf-8");%>

<%
    String co_id = request.getParameter("co_id");
	Co_MemBean manager = Co_MemBean.getInstance();
    int check= manager.confirmId(co_id);
 
%>

<body bgcolor="${value_c}">
	<%
    if(check == 1) {
%>
	<table width="270" border="0" cellspacing="0" cellpadding="5">
		<tr bgcolor="${title_c}">
			<td height="39"><%=co_id%>이미 사용중인 아이디입니다.</td>
		</tr>
	</table>
	<form name="checkForm" method="post" action="confirmID.jsp">
		<table width="270" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td bgcolor="${value_c}" align="center">다른 아이디를 선택하세요.
					<p>
						<input type="text" size="10" maxlength="12" name="co_id">
						<input type="submit" value="ID중복확인">
				</td>
			</tr>
		</table>
	</form>
	<%
    } else {
%>
	<table width="270" border="0" cellspacing="0" cellpadding="5">
		<tr bgcolor="${title_c}">
			<td align="center">
				<p>
					입력하신<%=co_id%>는 사용하실 수 있는 ID입니다.
				</p> 
				<input type="button" value="닫기" onclick="setid()">
			</td>
		</tr>
	</table>
	<%
    }
%>
</body>
</html>
<script language="javascript">
<!--
  function setid()
    {
    opener.document.userinput.co_id.value="<%=co_id%>";//opener:새로운 창을 연다.
		self.close();
	}
	-->
</script>
>
