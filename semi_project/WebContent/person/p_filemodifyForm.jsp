<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/view/color.jspf"%>

<html>
<head>
<title>개인회원 파일정보수정</title>
<link href="view/style.css" rel="stylesheet" type="text/css">


<script>
   function checkIt() { 
		var Fileinput = eval("document.Fileinput");

		if (!Fileinput.f_title.value) {
			alert("수정 할 제목을 입력하시오");
			return false;
		}
		if (Fileinput.f_description.value == "") {
			alert("수정할 내용 설명을 입력하시오.");
			return false;
		}
		if (Fileinput.f_category.value == "") {
			alert("수정할 파일 분류를 선택하시오.");
			return false;
		}
		
		return true;
	}
</script>


<%try{%>
</head>
<body bgcolor="${bodyback_c}>">
	<form method="post" action="Per_fileModifyForm.do?f_filename=${flle.f_filename}" name="Fileinput" onsubmit="return checkIt()">

		<table width="600" border="1" cellspacing="0" cellpadding="3" align="center">
			<tr>
				<td colspan="2" height="39" bgcolor="${title_c}" align="center">
					<font size="+1"><b>파일 정보수정</b></font>
				</td>
			</tr>
			
			<tr>
				<td width="200" bgcolor="${value_c}"><b>아이디: </b></td>
				<td width="400" bgcolor="${value_c}">${p_id}</td>
			</tr>
			
			<tr>
			
			<tr>
				<td width="200" bgcolor="${value_c}">파일 제목: </td>
				<td width="400">
				<input type="text" name="f_title" size="10" maxlength="20" value="${file.f_title}"></td>
			</tr>
		
		<td width="200" bgcolor="${value_c}">파일 : </td>
		<td width="400" bgcolor="${value_c}">
		  
		  <input type="file" name="file"  /> <br/> </td> 
		 </tr>
		 
			
			
			<tr>
				<td width="200" bgcolor="${value_c}" >파일 설명</td>
				<td width="400" bgcolor="${value_c}">
				<input type="textarea" name="f_description" value="${file.f_desciption}"></td>
			</tr>
			
			<tr>
				<td width="200" bgcolor="${value_c}">분류 :</td>
				<td width="400" bgcolor="${value_c}">
			
			<select name="p_category">
			<option>디자인분류</option>
			<option value="sanup">산업디자인</option>
			<option value="web">웹디자인</option>
			<option value="gun">시각디자인</option>
			</select>
			</td>
			</tr>			
	   
	   
			<tr>
				<td width="200" bgcolor="${value_c}" >업로드 클릭 : </td>
				<td width="400" bgcolor="${value_c}">
				<input type="submit" action="Per_fileModifyPro.do?f_filename=${file.f_filename}"  value="업로드"></td>
			</tr>
	   </table>
	   
	</form>
	
</body>
<%}catch(Exception e){}%>
</html>