<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./view/color.jspf" %>
<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
</head>
<body bgcolor="${bodyback_c}">
<center><b>write</b>
<br>
<form method="post" name="writeform" action="/semi_project/QNA_board/QNA_writePro.do" onsubmit="return writeSave()">
<input type="hidden" name="q_num" value="${q_num}">
<input type="hidden" name="Q_ref" value="${Q_ref}">


<table width="400" border="1" cellspacing="0" cellpadding="0" align="center">
	<tr>
		<td align="right" colspan="2" bgcolor="${value_c}">
			<a href="/semi_project/QNA_board/QNA_list.do">list</a>
		</td>
	</tr>
	
	<tr>
		<td width="70" bgcolor="${value_c}" align="center">name</td>
		<td width="330">
			<input type="text" size="10" maxlength="10" name="writer">
		</td>
	</tr>
	
	<tr>
		<td width="70" bgcolor="${value_c}" align="center">sub</td>
		<td  width="330">
			<c:if test="${num == 0}">
       		<input type="text" size="40" maxlength="50" name="subject">
       	</td>
			</c:if>
	
	<c:if test="${num != 0}">
   		<input type="text" size="40" maxlength="50" name="subject" value="[답변]"></td>
	</c:if>
	</tr>
	
	<tr>
    	<td  width="70"  bgcolor="${value_c}" align="center">Email</td>
    	<td  width="330">
       		<input type="text" size="40" maxlength="30" name="email" >
       	</td>
  	</tr>
  	
  	<tr>
    	<td  width="70"  bgcolor="${value_c}" align="center" >content</td>
    	<td  width="330" >
     		<textarea name="content" rows="13" cols="40"></textarea>
     	</td>
  	</tr>
  	
  	<tr>
    	<td  width="70"  bgcolor="${value_c}" align="center" >passwd</td>
    	<td  width="330" >
     		<input type="password" size="8" maxlength="12" name="passwd">
		</td>
  	</tr>
  	
	<tr>     
		<td colspan=2 bgcolor="${value_c}" align="center">
  			<input type="submit" value="글쓰기" > 
  			<input type="reset" value="다시작성">
  			<input type="button" value="목록보기" OnClick="window.location='/semi_project/QNA_board/QNA_list.do'">
		</td>
	</tr>
</table>   
</form>  
   
</body>
</html> 