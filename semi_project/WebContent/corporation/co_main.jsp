<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>

<html>
		<style>
			div#glayLayer{
				display:none;
				position:fixed;
				left:0;
				top:0;
				height:100%;
				width:100%;
				background:black;
				filter:alpha(opacity=60);
				opacity: 0.60;
			}
			* html div#glayLayer{
				position:absolute;
			}
			#overLayer{
				display:none;
				position: fixed;
				top:50%;
				left:50%;
				margin-top:-244px;
				margin-left:-325px;
			}
			* html #overLayer{
				position: absolute;
			}
		</style>	
	<head>
		<title>기업용 페이지</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
	
	</head>
	<body>
	${co_id}님의 페이지입니다.<br>
	<a href="../QNA_board/QNA_list.do">QnA</a> <a href="co_modify.do">정보수정</a> <a href="logout.jsp">로그아웃</a>
	<br>
	<br>
	<br>
	<form name="sel_category" onchange="javascript:click_check()">
	<select name="category" size=1>
	<option>디자인분류</option>
	<option value=0>산업디자인</option>
	<option value=1>웹디자인</option>
	<option value=2>시각디자인</option>
	</select>
	</form>	

	<form method="post" action="#" name="sel_order">
	<select name="order" size=1>
	<option>순서</option>
	<option value=0>최신순</option>
	<option value=1>인기순</option>
	</select>
	</form>
	<form method="post" name="sel_option">
	<select name="option" size=1>
	<option>SEARCH</option>
	<option value=0>제목</option>
	<option value=1>설명</option>
	</select>
	<input type="text" name="search" size="15" maxlength="50">
	<input type="submit" value="검색">
	</form>
	
	
<!--  
	<c:if test="${search==null}">
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
        <a href="co_main.do?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="co_main.do?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="co_main.do?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
</c:if>
</c:if>
-->

		
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<div class="inner">
						</div>
					</header>
					
				<!-- Main -->
					<div id="main">
						<div class="inner">
							<section class="tiles">
							<c:forEach var="item" items="${file}">
								<article class="style1">
									<span class="image">
										<img src="images/pic01.jpg" alt="" />
									</span>
									<a href="images/pic01.jpg" class="modal">
										<h2>Magna</h2>
										<div class="content">
											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
										</div>
									</a>
									제목 : ${item.f_title} <br> 
									설명 :	 ${item.f_description} <br>
									날짜 : ${item.f_regdate}<br>
								</article>
							</c:forEach>
							</section>
						</div>
					</div>
			</div>

		<!-- Scripts -->
			<script>
				function click_check(){
					sel_category=document.sel_category;
					if(sel_category.category.options[sel_category.category.selectedIndex].value=="0")
						alert("확인")
				}
			</script>
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
			<script>
				$(function(){
					$("body").append("<div id='glayLayer'></div><div id='overLayer'></div>");
					
					$("#glayLayer").click(function(){
						$(this).hide()
						$("#overLayer").hide();
					});
					
					$("a.modal").click(function(){
						$("#glayLayer").show();
						$("#overLayer").show().html("<img src='"+$(this).attr("href")+"' />");
						return false;
					});
					
				});
			</script>
	</body>
</html>