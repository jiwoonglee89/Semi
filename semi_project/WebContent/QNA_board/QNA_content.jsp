<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./view/color.jspf" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
<style type="text/css">
a:link {color:balck; text-decoration:none;}
a:visited {}
a:active {text-decoration:underline;}
a:hover {text-decoration:underline; background-image:url('text_dottdeline.gif'); background-repeat:repeat-x; background-position:50% 100%; }}
</style>
<style>
@font-face {font-family:굴림; src:url();}
body,td,a,div,p,pre,input,textarea {font-family:굴림;font-size:9pt;}
</style>
</head>
<body bgcolor="${bodyback_c }">
<center><b>글내용 보기</b>
<br>
<form>
<table width="500" border="1" cellspacing="0" cellpadding="0" align="center">
	<tr height="30">
		<td align="center" width="125" bgcolor="${value_c}">글번호</td>
		<td align="center" width="125" align="center">${article.q_num}</td>
    	<td align="center" width="125" bgcolor="${value_c}">조회수</td>
    	<td align="center" width="125" align="center">${article.readcount}</td>
  	</tr>
  
  	<tr height="30">
    	<td align="center" width="125" bgcolor="${value_c}">작성자</td>
   	 	<td align="center" width="125" align="center">
			<c:if test="${article.co_id!=null }">${article.co_id }</c:if>
			<c:if test="${article.p_id!=null }">${article.p_id }</c:if>
		</td>
    	<td align="center" width="125" bgcolor="${value_c}" >작성일</td>
    	<td align="center" width="125" align="center">${article.q_regdate}</td>
  	</tr>
  	
  	<tr height="30">
    	<td align="center" width="125" bgcolor="${value_c}">글제목</td>
    	<td align="center" width="375" align="center" colspan="3">${article.qna_title}</td>
  	</tr>
  	
  	<tr>
    	<td align="center" width="125" bgcolor="${value_c}">글내용</td>
    	<td align="left" width="375" colspan="3"><pre>${article.context}</pre></td>
  	</tr>
  	
  	<tr height="30">
  		<td colspan="4" bgcolor="${value_c}" align="right">
  			<input type="button" value="글수정" onclick="document.location.href='QNA_updateForm.do?q_num=${article.q_num}&pageNum=${pageNum}'">
  			&nbsp;&nbsp;&nbsp;&nbsp;
  			<input type="button" value="글삭제" onclick="document.location.href='QNA_deleteForm.do?q_num=${article.q_num}&pageNum=${pageNum}'">
   			&nbsp;&nbsp;&nbsp;&nbsp;
   			<c:if test="${co_id==null && p_id==null}">
      		<input type="button" value="답글쓰기" onclick="document.location.href='QNA_writeForm.do?q_num=${article.q_num}&qref_number=${article.qref_number+1}'">
      		&nbsp;&nbsp;&nbsp;&nbsp;
      		</c:if>
      		
   			
       		<input type="button" value="글목록" onclick="document.location.href='QNA_list.do?pageNum=${pageNum}'">
    	</td>
	</tr>		
</table>
</form>
</body>
</html>