<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	皋技瘤 惑技
	<hr />

	<table>
		<tr>
			<td>力格: </td> <td>${m_title }</td>
		</tr>
		<tr>
			<td>雀荤捞抚: </td> <td>${co_com }</td>
		</tr>
		<tr>
			<td>力格: </td> <td>${co_name }</td>
		</tr>
		<tr>
			<td>力格: </td> <td>${co_phone }</td>
		</tr>
		<tr>
			<td>力格: </td> <td>${co_email }</td>
		</tr>
		<tr>
			<td>力格: </td> <td>${m_context }</td>
		</tr>
		<tr><input type="hidden" name = "m_count"/>
		<input type="button" value="脚绊" onclick="javascript:window.location='declare/per2co_declare.do'"/>
		<input type="submit" value="摧扁"/>
		</tr>
	</table>

</body>
</html>