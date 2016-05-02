<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	메세지 상세
	<hr />

	<table>
		<tr>
			<td>제목: </td> <td>${m_title}</td>
		</tr>
		<tr>
			<td>회사이름: </td> <td>${co_com}</td>
		</tr>
		<tr>
			<td>담당자이름: </td> <td>${co_name}</td>
		</tr>
		<tr>
			<td>담당자핸드폰: </td> <td>${co_phone}</td>
		</tr>
		<tr>
			<td>담당자E-Mail: </td> <td>${co_email}</td>
		</tr>
		<tr>
			<td>내용: </td> <td>${m_context}</td>
		</tr>
		<tr><form method="get" action="p_messageList.do">
		<input type="hidden" name = "m_count" value="${m_count}"/>
		<input type="hidden" name ="m_num" value="${m_num}"/>
		<input type="submit" value="닫기"/>
		</form>
		</tr>
	</table>

</body>
</html>