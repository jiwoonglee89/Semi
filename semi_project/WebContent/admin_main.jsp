<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0
 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>sample3</title>
		<script type="text/javascript" src="jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="jquery.tablesorter.min.js"></script>
		<script type="text/javascript">
$(function(){
	 $("#myTable").tablesorter(); 
});
		</script>
		<link rel="stylesheet" href="blue/style.css" type="text/css" media="print, projection, screen" />
	</head>
	<body>
		<table id="myTable" class="tablesorter">
<thead>
	<tr>
	<th>No</th>
	<th>id</th>
	<th>이름</th>
	<th>성별</th>
	<th>전화번호</th>
	<th>디자인 분야</th>
	<th>신고사유</th>
	<th>경고횟수</th>
	<th></th>
	</tr>
</thead>
<c:forEach var="people" items="${people}">
<c:set var="number" value="0" />
<tbody>
	<tr>
		<td>${number+1}</td>
		<td>${people.p_id }</td>
		<td>${people.p_name }</td>
		<td>${people.p_gender }</td>
		<td>${people.p_tel }</td>
		<td>${people.p_category }</td>
		<td></td>
		<td>${people.p_count }</td>
	</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>