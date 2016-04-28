<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="view/color.jspf"%>

<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="${bodyback_c}">
<center><b>글목록(전체 글:${count})</b>
<table width="700">
  <tr>
    <td align="right" bgcolor="${value_c}">
       <a href="QNA_writeForm.do">글쓰기</a>
    </td>
  </tr>
</table>

<c:if test="${count == 0}">
<table width="700" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
      게시판에 저장된 글이 없습니다.
    </td>
  </tr>
</table>
</c:if>

<c:if test="${count > 0}">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
    <tr height="30" bgcolor="${value_c}">
      <td align="center"  width="50"  >번 호</td>
      <td align="center"  width="250" >제   목</td>
      <td align="center"  width="100" >작성자ID</td>
      <td align="center"  width="150" >작성일</td>
      <td align="center"  width="50" >조회수</td>
    </tr>

   <c:forEach var="article" items="${articleList}">
   <tr height="30">
    <td align="center"  width="50" >
  <c:out value="${number}"/>
  <c:set var="number" value="${number - 1}"/>
</td>
    <td  width="250" >
  <c:if test="${article.qref_number > 0}">
  <img src="images/level.gif" width="${5 * article.qref_number}" height="16">
    <img src="images/re.gif">
  </c:if>
  <c:if test="${article.qref_number == 0}">
    <img src="images/level.gif" width="${5 * article.qref_number}" height="16">
  </c:if>
          
      <a href="QNA_content.do?q_num=${article.q_num}&pageNum=${currentPage}">
          ${article.qna_title}</a>
          <c:if test="${article.readcount >= 20}">
            <img src="images/hot.gif" border="0"  height="16">
  </c:if>
</td>
    <td align="center"  width="100">
    <c:if test="${article.co_id!=null }">${article.co_id }</c:if>
    <c:if test="${article.p_id!=null }">${article.p_id }</c:if>
    </a>
</td>
    <td align="center"  width="150">${article.q_regdate}
</td>
    <td align="center"  width="50">${article.readcount}</td>
  </tr>
  </c:forEach>
</table>
</c:if>

<form>
<select name="search">
	<option value="writer">작성자</option>
	<option value="qna_title">제목</option>
	<option value="context">내용</option>
</select>
<input type="text" name="search_context" size="15" maxlength="50" />
<input type="submit" value="검색" />
<input type="button" value="목록보기" onclick="window.location='QNA_list.do'" />
</form>
<c:if test="${search_context==null }">
<c:if test="${count > 0}">
   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
   <c:set var="startPage" value="${result * 10 + 1}" />
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
</c:if>
</center>
</body>
</html>