<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>포트폴리오상세보기</title>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="detail/assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<noscript><link rel="stylesheet" href="detail/assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-loading-0 is-loading-1 is-loading-2">

		<!-- Main -->
			<div id="main">

				<!-- Header -->
					<header id="header">
						<p>${pbean.p_name}님의 포트폴리오 </p>
						<ul class="icons">
							<li><a href="p_mainview.do" class="icon fa-internet-explorer"><span class="label"></span>메인페이지로</a></li>
						</ul>
					</header>

				<!-- Thumbnail -->
				<section id="thumbnails">
					<c:forEach var="f" items="${fileList}">
						<article>
							<a class="thumbnail" href="/semi_project/File/${f.f_filename}" data-position="left center"><img src="/semi_project/File/${f.f_filename}" alt="" /></a>
							<h2>${f.f_title}</h2>
							<p>${f.f_description}</p>
							<p>${f.f_filename }</p>
							<form action = "fileModify.do">
								<input type="hidden" name="f_filename" value="${f.f_filename}"/>
								<input type="submit" value="수정"/>
							</form>
							<form action = "filedelete.do">
								<input type="hidden" name="f_filename" value="${f.f_filename}"/>
								<input type="submit" value="삭제"/>
							</form>
						</article>
					</c:forEach>
						
				</section>

				<!-- Footer -->
					<footer id="footer">
						<ul class="copyright">
							<li>&copy; Untitled.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a>.</li>
						</ul>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="detail/assets/js/jquery.min.js"></script>
			<script src="detail/assets/js/skel.min.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="detail/assets/js/main.js"></script>

	</body>
</html>