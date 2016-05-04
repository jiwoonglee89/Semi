<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../view/color.jsp"%>
<html>
<head>

<title>회원탈퇴</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="<%=bodyback_c%>">
	
		<table width="270" border="0" cellspacing="0" cellpadding="5"
			align="center">
			<tr bgcolor="<%=title_c%>">
				<td height="39" align="center"><font size="+1"><b>회원정보가
							삭제되었습니다.</b></font></td>
			</tr>
			<%-- <tr bgcolor="<%=value_c%>">
				<td align="center">
					<p>흑흑.... 서운합니다. 안녕히 가세요.</p>
					<meta http-equiv="Refresh" content="5;url=main.jsp">
				</td>
			</tr> --%>
			<tr bgcolor="<%=value_c%>">
				<td align="center"><input
					type="button" value="메인으로"
					onclick="javascript:window.location='../main.jsp'"></td>
			</tr>
		</table>
	</form>
</body>
</html>