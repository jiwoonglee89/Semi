<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>��������</title>
</head>
<body>
<img src="/semi_project/File/${file.realpath}">
<br>
���� : ${file.f_title } <br>
���� : ${file.f_description } <br>
��¥ : ${file.f_regdate } <br>
<br>
<br>
�ۼ��� ������ <br>
�̸� : ${person.p_name } <br>
���� : ${person.p_gender } <br>
�̸��� : ${person.p_email }<br>
��ȭ��ȣ : ${person.p_tel }<br>
������� : ${person.p_birth }<br>
�ּ� : ${person.p_address }<br>
������ ���� : ${person.p_category }<br>
��»��� : ${person.p_career}<br>
������ : ${person.p_award}<br>

<form action="co_message.do" target="_blank">
	<input type="submit" value="�޼��� ������">
	<input type="hidden" value="${person.p_id}" name="id">
	<input type="button" value="�ݱ�" onclick="javascript:window.close()">
</form>

</body>
</html>