<%@ page contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head><title>파일 등록</title></head>
<body>
<form action="fileuploadPro.do" method="post"  enctype="multipart/form-data">
<select name="f_category">
	<option>디자인분류</option>
	<option value="0">산업디자인</option>
	<option value="1">웹디자인</option>
	<option value="2">건축디자인</option>
</select>
파일 : <input type="file" name="file"/> <br>
파일이름 : <input type="text" name="f_title" value="${filebean.f_title}"/> <br>
설명 : <textarea name="f_description"/></textarea> <br>
<input type="submit" value="업로드"/>
<input type="button" value="취소" onclick="javascript:window.location=history.go(-1)"/>


</form>

</body>
</html>