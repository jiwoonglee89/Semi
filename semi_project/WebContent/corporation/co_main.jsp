<%@ page contentType="text/html; charset=UTF-8"%>
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
	기업용 페이지	
	<a href="QNA_board.do">QnA</a> <a href="co_modify.do">정보수정</a> <a href="../main.do">로그아웃</a>
	<br>
	<form method="post">
	<select name="category" size=1>
	<option>디자인분류</option>
	<option value=0>산업디자인</option>
	<option value=1>웹디자인</option>
	<option value=2>시각디자인</option>
	</select>
	</form>
	<form>
	<select name="order" size=1>
	<option>순서</option>
	<option value=0>최신순</option>
	<option value=1>인기순</option>
	</select>
	</form>
	<form>
	<select name="search" size=1>
	<option>SEARCH</option>
	<option value=0>제목</option>
	<option value=1>설명</option>
	</select>
	<input type="text" name="co_name" size="15" maxlength="30">
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
									제목 : <br> 
									설명 :	 <br>
									날짜 : <br>
								</article>
								<article class="style2">
									<span class="image">
										<img src="images/pic02.jpg" alt="" />
									</span>
									<a href="generic.html">
										<h2>Lorem</h2>
										<div class="content">
											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
										</div>
									</a>
								</article>
								<article class="style3">
									<span class="image">
										<img src="images/pic03.jpg" alt="" />
									</span>
									<a href="generic.html">
										<h2>Feugiat</h2>
										<div class="content">
											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
										</div>
									</a>
								</article>
								<article class="style4">
									<span class="image">
										<img src="images/pic04.jpg" alt="" />
									</span>
									<a href="generic.html">
										<h2>Tempus</h2>
										<div class="content">
											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
										</div>
									</a>
								</article>
								<article class="style5">
									<span class="image">
										<img src="images/pic05.jpg" alt="" />
									</span>
									<a href="generic.html">
										<h2>Aliquam</h2>
										<div class="content">
											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
										</div>
									</a>
								</article>
								<article class="style6">
									<span class="image">
										<img src="images/pic06.jpg" alt="" />
									</span>
									<a href="generic.html">
										<h2>Veroeros</h2>
										<div class="content">
											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
										</div>
									</a>
								</article>
								<article class="style2">
									<span class="image">
										<img src="images/pic07.jpg" alt="" />
									</span>
									<a href="generic.html">
										<h2>Ipsum</h2>
										<div class="content">
											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
										</div>
									</a>
								</article>
								<article class="style3">
									<span class="image">
										<img src="images/pic08.jpg" alt="" />
									</span>
									<a href="generic.html">
										<h2>Dolor</h2>
										<div class="content">
											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
										</div>
									</a>
								</article>
								<article class="style1">
									<span class="image">
										<img src="images/pic09.jpg" alt="" />
									</span>
									<a href="generic.html">
										<h2>Nullam</h2>
										<div class="content">
											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
										</div>
									</a>
								</article>
								<article class="style5">
									<span class="image">
										<img src="images/pic10.jpg" alt="" />
									</span>
									<a href="generic.html">
										<h2>Ultricies</h2>
										<div class="content">
											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
										</div>
									</a>
								</article>
								<article class="style6">
									<span class="image">
										<img src="images/pic11.jpg" alt="" />
									</span>
									<a href="generic.html">
										<h2>Dictum</h2>
										<div class="content">
											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
										</div>
									</a>
								</article>
								<article class="style4">
									<span class="image">
										<img src="images/pic12.jpg" alt="" />
									</span>
									<a href="generic.html">
										<h2>Pretium</h2>
										<div class="content">
											<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
										</div>
									</a>
								</article>
							</section>
						</div>
					</div>
			</div>

		<!-- Scripts -->
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