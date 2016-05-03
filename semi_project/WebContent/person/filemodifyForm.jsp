<%@ page contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head><title>파일 등록</title></head>
<body>
<form action="filemodifyPro.do?f_title=${fbean.f_title}" method="post"  enctype="multipart/form-data">
<select name="f_category">
	<option>디자인분류</option>
	<option value="0" selected="${fbean.f_category eq '산업디자인'?'selected':''}">산업디자인</option>
	<option value="1" selected="${fbean.f_category eq '웹디자인'?'selected':''}" >웹디자인</option>
	<option value="2" selected="${fbean.f_category eq '건축디자인'?'selected':''}" >건축디자인</option>
</select>
수정전 파일이름: <input type="text" name="f_filename" value="${fbean.f_filename}"/> <br>
수정할 파일선택: <input type="file" name="file"/> <br>
제목 : <input type="text" name="f_title" value="${fbean.f_title}"/> <br>
설명 : <textarea name="f_description" rows="25" cols="20"/>${fbean.f_description}</textarea> <br>

<input type="submit" value="파일수정"/>


</form>

</body>
</html>