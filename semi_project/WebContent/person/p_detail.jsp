<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>Lens by HTML5 UP</title>
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
						<h1>${filename}</h1>
						<p>Just another fine responsive site template by <a href="http://html5up.net">HTML5 UP</a></p>
						<ul class="icons">
							<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
							<li><a href="#" class="icon fa-github"><span class="label">Github</span></a></li>
							<li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
						</ul>
					</header>

				<!-- Thumbnail -->
					<section id="thumbnails">
					<c:forEach var="f" items="${fileList}">
						<article>
							<a class="thumbnail" href="/semi_project/File/${f.f_filename}" data-position="left center"><img src="/semi_project/File/${f.f_filename}" alt="" /></a>
							<h2>${f.f_title}</h2>
							<p>${f.f_description}</p>
						</article>
						
						<!-- 폼생성 후 삭제해야함 -->
						<input type="hidden" name="filename" value="${f.f_filename}"/>
					</c:forEach>
						<!-- <article>
							<a class="thumbnail" href="images/fulls/02.jpg"><img src="images/thumbs/02.jpg" alt="" /></a>
							<h2>Vivamus convallis libero</h2>
							<p>Sed velit lacus, laoreet at venenatis convallis in lorem tincidunt.</p>
						</article>
						<article>
							<a class="thumbnail" href="images/fulls/03.jpg" data-position="top center"><img src="images/thumbs/03.jpg" alt="" /></a>
							<h2>Nec accumsan enim felis</h2>
							<p>Maecenas eleifend tellus ut turpis eleifend, vitae pretium faucibus.</p>
						</article>
						<article>
							<a class="thumbnail" href="images/fulls/04.jpg"><img src="images/thumbs/04.jpg" alt="" /></a>
							<h2>Donec maximus nisi eget</h2>
							<p>Tristique in nulla vel congue. Sed sociis natoque parturient nascetur.</p>
						</article>
						<article>
							<a class="thumbnail" href="images/fulls/05.jpg" data-position="top center"><img src="images/thumbs/05.jpg" alt="" /></a>
							<h2>Nullam vitae nunc vulputate</h2>
							<p>In pellentesque cursus velit id posuere. Donec vehicula nulla.</p>
						</article>
						<article>
							<a class="thumbnail" href="images/fulls/06.jpg"><img src="images/thumbs/06.jpg" alt="" /></a>
							<h2>Phasellus magna faucibus</h2>
							<p>Nulla dignissim libero maximus tellus varius dictum ut posuere magna.</p>
						</article>
						<article>
							<a class="thumbnail" href="images/fulls/07.jpg"><img src="images/thumbs/07.jpg" alt="" /></a>
							<h2>Proin quis mauris</h2>
							<p>Etiam ultricies, lorem quis efficitur porttitor, facilisis ante orci urna.</p>
						</article>
						<article>
							<a class="thumbnail" href="images/fulls/08.jpg"><img src="images/thumbs/08.jpg" alt="" /></a>
							<h2>Gravida quis varius enim</h2>
							<p>Nunc egestas congue lorem. Nullam dictum placerat ex sapien tortor mattis.</p>
						</article>
						<article>
							<a class="thumbnail" href="images/fulls/09.jpg"><img src="images/thumbs/09.jpg" alt="" /></a>
							<h2>Morbi eget vitae adipiscing</h2>
							<p>In quis vulputate dui. Maecenas metus elit, dictum praesent lacinia lacus.</p>
						</article>
						<article>
							<a class="thumbnail" href="images/fulls/10.jpg"><img src="images/thumbs/10.jpg" alt="" /></a>
							<h2>Habitant tristique senectus</h2>
							<p>Vestibulum ante ipsum primis in faucibus orci luctus ac tincidunt dolor.</p>
						</article>
						<article>
							<a class="thumbnail" href="images/fulls/11.jpg"><img src="images/thumbs/11.jpg" alt="" /></a>
							<h2>Pharetra ex non faucibus</h2>
							<p>Ut sed magna euismod leo laoreet congue. Fusce congue enim ultricies.</p>
						</article>
						<article>
							<a class="thumbnail" href="images/fulls/12.jpg"><img src="images/thumbs/12.jpg" alt="" /></a>
							<h2>Mattis lorem sodales</h2>
							<p>Feugiat auctor leo massa, nec vestibulum nisl erat faucibus, rutrum nulla.</p>
						</article> -->
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