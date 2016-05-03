<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
 	String admin_id = (String)session.getAttribute("admin_id");
 	request.setAttribute("admin_id", admin_id);
%>
<script type="text/javascript" src="jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="jquery.tablesorter.min.js"></script>
<script>
$(function(){
	 $("#myTable").tablesorter(); 
});
</script>
<html>
	<head>
		<title>관리자 페이지</title>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="admin_main_per.do?who_p=1">개인</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="admin_main_co.do?who_co=1">기업</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="QNA_board/QNA_list.do">Q&A</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="logout.jsp">로그아웃</a>
		

		<link rel="stylesheet" href="blue/style.css" type="text/css" media="print, projection, screen" />
	</head>
	<body>
<c:if test="${who_p==1}">
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
	<th>강제 퇴출</th>
	</tr>
</thead>
<c:set var="number" value="0" />
<c:forEach var="people" items="${people}">
<tbody>
	<tr>
		<td>${number=number+1}</td>
		<td>${people.p_id }</td>
		<td>${people.p_name }</td>
		<td>${people.p_gender }</td>
		<td>${people.p_tel }</td>
		<td>${people.p_category }</td>
		<td><a href="admin_reason.do?id=${people.p_id}">신고사유</a></td>
		<td>${people.p_count }</td>
		<td><a href="admin_delete_per.do?id=${people.p_id}">퇴출</a></td>
	</tr>
</c:forEach>
</tbody>
</table>
</c:if>
<c:if test="${who_co==1}">
<table id="myTable" class="tablesorter">
<thead>
	<tr>
	<th>No</th>
	<th>id</th>
	<th>기업명</th>
	<th>담당자 이름</th>
	<th>담당자 전화번호</th>
	<th>업종</th>
	<th>신고사유</th>
	<th>경고횟수</th>
	<th>강제 퇴출</th>
	</tr>
</thead>
<c:set var="number" value="0" />
<c:forEach var="cor" items="${coporation}">
<tbody>
	<tr>
		<td>${number=number+1}</td>
		<td>${cor.co_id }</td>
		<td>${cor.co_com}</td>
		<td>${cor.co_name }</td>
		<td>${cor.co_tel }</td>
		<td>${cor.co_category }</td>
		<td><a href="admin_reason.do?id=${cor.co_id}">신고사유</a></td>
		<td>${cor.co_count }</td>
		<td><a href="admin_delete_co.do?co_id=${cor.co_id}">퇴출</a></td>
	</tr>
</c:forEach>
</tbody>
</table>
</c:if>
</body>
</html>