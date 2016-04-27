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
<center><b>update</b>
<br>
<form method="post" name="writeform" action="QNA_updatePro.do?pageNum=${pageNum}" onsubmit="return Save()">
<table width="400" border="1" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td  width="70"  bgcolor="${value_c}" align="center">ID</td>
    <td align="left" width="330">
    <c:if test="${article.co_id!=null }">${co_id}</c:if>
    <c:if test="${article.p_id!=null }">${p_id }</c:if>
   <input type="hidden" name="q_num" value="${article.q_num}"></td>
  </tr>
  <tr>
    <td  width="70"  bgcolor="${value_c}" align="center" >제 목</td>
    <td align="left" width="330">
       <input type="text" size="40" maxlength="50" name="qna_title" value="${article.qna_title}"></td>
  </tr>
  <tr>
    <td  width="70"  bgcolor="${value_c}" align="center" >내 용</td>
    <td align="left" width="330">
     <textarea name="context" rows="13" cols="40">${article.context}</textarea></td>
  </tr>
  <tr>
    <td  width="70"  bgcolor="${value_c}" align="center" >비밀번호</td>
    <td align="left" width="330" >
     <input type="password" size="8" maxlength="12" name="q_passwd">
</td>
  </tr>
  <tr>     
   <td colspan=2 bgcolor="${value_c}" align="center">
     <input type="submit" value="글수정" > 
     <input type="reset" value="다시작성">
     <input type="button" value="목록보기" onclick="document.location.href='QNA_list.do?pageNum=${pageNum}'">
   </td>
</tr>
</table>
</form>
</body>
</html>