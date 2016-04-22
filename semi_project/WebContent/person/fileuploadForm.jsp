<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head><title>파일 등록</title></head>
<body>
<form action="fileuploadPro.do" method="post"  enctype="multipart/form-data">
<select name="p_category">
	<option>분야선택</option>
	<option value="0">산업디자인</option>
</select>
파일 : <input type="file" name="file"/> <br>
파일이름 : <input type="text" name="f_title"/> <br>
설명 : <input type="text" name="f_description"/> <br>
<input type="submit" value="업로드"/>


</form>

</body>
</html>