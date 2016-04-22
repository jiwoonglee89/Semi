<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="DB.Co_MemBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./view/color.jspf"%>
<html>
<head><title>기업회원탈퇴</title>
<link href="style.css" rel="stylesheet" type="text/css">

<script>

       function begin(){
         document.myform.passwd.focus();
       }

       function checkIt(){
  if(!document.myform.passwd.value){
           alert("비밀번호를 입력하지 않으셨습니다.");
           document.myform.passwd.focus();
           return false;
         }
   }
</script>
</head>
<body onload="begin()" bgcolor="${bodyback_c}">
	<form name="myform" action="deletePro.do" method="post" onSubmit="return checkIt()">
		
		<table cellSpacing=1 cellPadding=1 width="260" border=1 align="center">

			<tr height="30">
				<TD colspan="2" align="middle" bgcolor="${title_c}">
				<font size="+1"><b>회원 탈퇴</b></font></TD>
			</tr>

			<tr height="30">
				<td width="110" bgcolor="${value_c}" align=center>비밀번호</TD>
				<td width="150" align=center>
				<input type=password name="co_passwd" size="15" maxlength="12"></TD>
			</tr>
			<tr height="30">
				<td colspan="2" align="middle" bgcolor="${value_c}">
				<input type=submit value="회원탈퇴"> 
				<input type="button" value="취  소" onclick="javascript:window.location='main.do'"></TD>
			</tr>
		</table>
	</form>
</body>
</html>