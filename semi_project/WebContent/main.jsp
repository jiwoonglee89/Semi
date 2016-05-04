<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>

<html>
<head>
<title>메인</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="view/assets/css/main.css" type="text/css" />
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
</head>
<body class="landing" onLoad="focusIt();" marginheight="230">

	<!-- Banner -->
	<section id="banner">
		<i class="icon fa-diamond"></i>
		<table width=250 cellpadding="0" cellspacing="0" align="center" border="3 solid">
			<tr>
				<form name="inform" method="post" action="loginPro.do" onSubmit="return checkIt();">
					<td width="50" align="right">아이디</td>
					<td width="50"><input type="text" name="id" size="15" maxlength="15"></td>
			</tr>
			<tr>
				<td width="50" align="right">패스워드</td>
				<td width="50"><input type="password" name="passwd" size="15" maxlength="15"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<div class="fa fa-user fa-2x"></div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<div class="fa fa-building fa-2x"></div> <br> 
					<div class="4u 12u$(xsmall)">
						<input type="radio" id="per" value="per" name="per_or_cor">
						<label for="per">개인회원</label>
						<input type="radio" id="cor" value="cor" name="per_or_cor">
						<label for="cor">기업회원</label>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
				<input type="submit" name="Submit" value="로그인"> 
				<input type="button" value="회원가입" onclick="javascript:window.location='join.jsp'"></td>
			</tr>
			</form>
		</table>
	</section>

	<!-- Scripts -->
	<script>
		function focusIt() {
			document.inform.id.focus();//내가 작업하고 있는 문서의 inform이라는 곳에 id에 커서를 가져다 줌
		}
		function checkIt() {
			inputForm = eval("document.inform");
			if (!inputForm.id.value) {
				alert("아이디를 입력하세요..");
				inputForm.id.focus();
				return false;
			}
			if (!inputForm.passwd.value) {
				alert("패스워드를 입력하세요..");
				inputForm.passwd.focus();
				return false;
			}
		}
	</script>
	<script src="view/assets/js/jquery.min.js"></script>
	<script src="view/assets/js/skel.min.js"></script>
	<script src="view/assets/js/util.js"></script>
	<script src="view/assets/js/main.js"></script>
</body>
</html>