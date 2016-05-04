<%@ page contentType="text/html; charset=EUC-KR"%>
<html>
<head>
<title>회원탈퇴</title>
</head>
<body>
<% session.invalidate(); %>
성공적으로 탈퇴하셨습니다.<br>
이용해 주셔서 감사합니다.<br>
<a href="/main.jsp">메인으로 돌아가기</a>
</body>
</html>