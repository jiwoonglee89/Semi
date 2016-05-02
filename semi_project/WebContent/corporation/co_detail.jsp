<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>세부정보</title>
</head>
<body>
<img src="/semi_project/File/${file.realpath}">
<br>
제목 : ${file.f_title } <br>
설명 : ${file.f_description } <br>
날짜 : ${file.f_regdate } <br>
<br>
<br>
작성자 프로필 <br>
이름 : ${person.p_name } <br>
성별 : ${person.p_gender } <br>
이메일 : ${person.p_email }<br>
전화번호 : ${person.p_tel }<br>
생년월일 : ${person.p_birth }<br>
주소 : ${person.p_address }<br>
디자인 종류 : ${person.p_category }<br>
경력사항 : ${person.p_career}<br>
수상경력 : ${person.p_award}<br>

<form action="co_message.do" target="_blank">
	<input type="submit" value="메세지 보내기">
	<input type="button" value="신고하기" onclick="javascript:window.location='co_declareForm.do?id=${person.p_id}&title=${file.f_title}'">
	<input type="hidden" value="${person.p_id}" name="id">
	<input type="button" value="닫기" onclick="javascript:window.close()">
</form>

</body>
</html>