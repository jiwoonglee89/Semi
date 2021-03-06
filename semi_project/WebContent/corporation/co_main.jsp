<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html> 
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
	<option value="0">산업디자인</option>
	<option value="1">웹디자인</option>
	<option value="2">건축디자인</option>
	</select>
	</form>	

	<form onchange="javascript:click_check2()" name="sel_order">
	<select name="order" size=1>
	<option>순서</option>
	<option value=0>최신순</option>
	<option value=1>인기순</option>
	</select>
	</form>
	<form method="post" name="sel_option" action="co_main.do">
	<select name="option" size=1>
	<option>SEARCH</option>
	<option value=0>제목</option>
	<option value=1>설명</option>
	</select>
	<input type="text" name="search" size="15" maxlength="50">
	<input type="submit" value="검색">
	</form>
	
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
										
									<%-- <a href="/semi_project/File/${item.f_filename}" class="modal"> --%>
									<a href="co_detail.do?id=${item.p_id}&num=${item.f_num}" target="_blank">
 									<img src="/semi_project/File/${item.f_filename}" />
 									</a>
 									</span>
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
						location.href="co_main.do?category=산업디자인"
					else if(sel_category.category.options[sel_category.category.selectedIndex].value=="1")
						location.href="co_main.do?category=웹디자인"
					else if(sel_category.category.options[sel_category.category.selectedIndex].value=="2")
						location.href="co_main.do?category=건축디자인"
				}
				
				function click_check2(){
					sel_order=document.sel_order;
					if(sel_order.order.options[sel_order.order.selectedIndex].value=="0")
						location.href="co_main.do?order=0"
					
					else
						location.href="co_main.do?order=1"
				}
			</script>
			
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	</body>
</html>