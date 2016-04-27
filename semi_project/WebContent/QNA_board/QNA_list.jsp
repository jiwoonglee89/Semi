<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="./view/color.jspf" %>

<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css" >
</head>
<body bgcolor="${bodyback_c }" >
<center><b>글목록(전체 글 : ${count})</b>
<table width="700">
	<tr>
		<td align="right" bgcolor="${value_c}">
		<a href="QNA_writeForm.jsp"> write </a>
		</td>
	</tr>
</table>

<c:if test="${count == 0}">
<table width="700" border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center">
		board is empty!
		</td>
	</tr> 
</table>
</c:if>

<c:if test="${count > 0}">

<table border="1" width="700" cellpadding="0" cellspacing="0" >
	<tr height="30" bgcolor="${value_c}">
		<td align="center" width="50"> 글번호 </td>
		<td align="center"  width="250" > 제목 </td>
		<td align="center"  width="100" > 글쓴이 </td>
		<td align="center"  width="150" > 작성 날짜 </td>
		<td align="center"  width="50" > 조회 수 </td>
  </tr>
    
	<c:forEach var="article" items="${articleList}">
		<tr height="30">
			<td align="center"  width="50" >
				<c:out value="${number}"/>
				<c:set var="number" value="${number - 1}"/>
			</td>
			
			<td  width="250" >
			
			<c:if test="${article.re_level > 0}"> <%-- getter 메서드 호출!! --%>
				<img src="images/level.gif" width="${5 * article.re_level}" height="16">
				<img src="images/re.gif">
			</c:if>
			
			<c:if test="${article.re_level == 0}">
				<img src="images/level.gif" width="${5 * article.re_level}" height="16">
			</c:if>
			
			<a href="QNA_content.do?q_num=${article.num}&pageNum=${currentPage}"> <%-- context root, key 값 --%>
			${article.subject}</a>
			
			<c:if test="${article.readcount >= 20}">
				<img src="images/hot.gif" border="0"  height="16">
			</c:if>
		</td>
		
		<td align="center"  width="100">
			<a href="mailto:${article.email}">${article.writer}</a>
		</td>
		
		<td align="center"  width="150">${article.reg_date}</td>
		<td align="center"  width="50">${article.readcount}</td>
		<td align="center" width="100" >${article.ip}</td>
	</tr>
</c:forEach>

</table>
</c:if>

<c:if test="${count > 0}">
	<c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
	<c:set var="pageBlock" value="${10}"/> <%-- action 패키지에서 설정하도록 구현 --%>
	<fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
	<c:set var="startPage" value="${result * 10 + 1}" /> <%-- Block 을 넣어주면 가독성이 좋다.--%>
	<c:set var="endPage" value="${startPage + pageBlock-1}"/>
	<c:if test="${endPage > pageCount}">
	<c:set var="endPage" value="${pageCount}"/>
</c:if>
         
<c:if test="${startPage > 10}">

	<a href="QNA_list.do?pageNum=${startPage - 10 }">[이전]</a>
</c:if>



<c:forEach var="i" begin="${startPage}" end="${endPage}">
	<a href="QNA_list.do?pageNum=${i}">[${i}]</a>
</c:forEach>
	
	<c:if test="${endPage < pageCount}">
		<a href="QNA_list.do?pageNum=${startPage + 10}">[다음]</a>
	</c:if>
</c:if>

<form>
<select name="searchn">
<option value="0">작성자</option>
<option value="1">제목</option>
<option value="2">내용</option>
</select>

<input type="text" name="search" size="15" maxlength="50" /> 
<input type="submit" value="검색" />
</form>
<br></br>
</center>
</body>
</html>

</center>
</body>
</html>