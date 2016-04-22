<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./view/color.jspf" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<link href="style.css" rell="stylesheet" type="text/css">
<style type="text/css">

a:link { color:black; text-decoration:none; }
a:visited {  }
a:active { text-decoration:underline; }
a:hover { text-decoration:underline; background-image:url('text_dottdeline.gif'); background-repeat:repeat-x; background-position:50% 100%; }

</style>

<style>
	@font-face { font-family:굴림; src:url(); }
	body,td,a,div,p,pre,input,textarear { font:굴림; font-size:9pt }
</style>	
</head bgcolor="${bodyback_c}">
<center><b>content view</b>
<br>
<form>
<table width="500" border="1" cellspacing="0" cellpadding="0" align="center">
	<tr height="30">
		<td align="center" width="125" bgback="${value_c}">글번호</td>
		<td align="center" width="125" align="center">${article.num}</td>
    	<td align="center" width="125" bgcolor="${value_c}">조회수</td>
    	<td align="center" width="125" align="center">${article.readcount}</td>
  	</tr>
  
  	<tr height="30">
    	<td align="center" width="125" bgcolor="${value_c}">작성자</td>
   	 	<td align="center" width="125" align="center">${article.writer}</td>
    	<td align="center" width="125" bgcolor="${value_c}" >작성일</td>
    	<td align="center" width="125" align="center">${article.reg_date}</td>
  	</tr>
  	
  	<tr height="30">
    	<td align="center" width="125" bgcolor="${value_c}">글제목</td>
    	<td align="center" width="375" align="center" colspan="3">${article.subject}</td>
  	</tr>
  	
  	<tr>
    	<td align="center" width="125" bgcolor="${value_c}">글내용</td>
    	<td align="left" width="375" colspan="3"><pre>${article.content}</pre></td>
  	</tr>
  	
  	<tr height="30">
  		<td colspan="4" bgcolor="${value_c}" align="right">
  			<input type="button" value="글수정" onclick="document.location.href='/MarJSP/mvc_board/updateForm.do?num=${article.num}&pageNum=${pageNum}'">
  			&nbsp;&nbsp;&nbsp;&nbsp;
  			<input type="button" value="글삭제" onclick="document.location.href='/MarJSP/mvc_board/deleteForm.do?num=${article.num}&pageNum=${pageNum}'">
   			&nbsp;&nbsp;&nbsp;&nbsp;
      		<input type="button" value="답글쓰기" onclick="document.location.href='/MarJSP/mvc_board/writeForm.do?num=${article.num}&ref=${article.ref}&re_step=${article.re_step}&re_level=${article.re_level}'">
   			&nbsp;&nbsp;&nbsp;&nbsp;
       		<input type="button" value="글목록" onclick="document.location.href='/MarJSP/mvc_board/list.do?pageNum=${pageNum}'">
    	</td>
	</tr>		

</form>

<form method=post action=contentPro.jsp >
					<tr bgcolor=bgcolor="${value_c}" align="center">
						<td>코멘트 작성</td>
						<td colspan=2>
							<textarea name=commentt rows="6" cols="40"></textarea>
							<input type=hidden name=content_num value="${article.num}">
							<input type=hidden name=p_num value="${pageNum}">
							<input type=hidden name=comment_num value="${count+1}">
						</td>
						<td align=center>
							작성자<br>
							<input type=text name=commenter size=10><br>
							비밀번호<br>
							<input type=password name=passwd size=10><p>
							<input type=submit value=코멘트달기> <!-- submit 폼안에 내용들이 전송됨 -->
						</td>
					</tr>
					</form>

</table>


</body>
</html>