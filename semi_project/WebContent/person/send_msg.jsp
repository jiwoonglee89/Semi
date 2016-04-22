<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>메세지보내기</title>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="main_msg/assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>
	<section id="three">
	<h2>메세지보내기</h2>
	<p>마음에 드는 사용자에게 메세지를 보내세요</p>
	<div class="row">
		<div class="8u 12u$(small)">
			<form method="post" action="#">
				<div class="row uniform 50%">
					<div class="6u 12u$(xsmall)">
						<input type="text" name="name" id="name" placeholder="담당자이름" />
					</div>
					<div class="6u$ 12u$(xsmall)">
						<input type="email" name="email" id="email" placeholder="담당자 Email" />
					</div>
					<div class="12u$">
						<textarea name="message" id="message" placeholder="Message"
							rows="4"></textarea>
					</div>
				</div>
			</form>
			<ul class="actions">
				<li><input type="submit" value="메세지보내기" /></li>
			</ul>
		</div>
		<div class="4u$ 12u$(small)">
			<ul class="labeled-icons">
				<li>
					<h3 class="icon fa-home">
						<span class="label">Address</span>
					</h3> 서울특별시<br /> 강남구<br /> 태혜란로
				</li>
				<li>
					<h3 class="icon fa-mobile">
						<span class="label">Phone</span>
					</h3> 000-000-0000
				</li>
				<li>
					<h3 class="icon fa-envelope-o">
						<span class="label">Email</span>
					</h3> <a href="#">hello@untitled.tld</a>
				</li>
			</ul>
		</div>
	</div>
</section>
</body>
</html>