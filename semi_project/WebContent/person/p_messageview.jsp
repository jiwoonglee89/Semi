<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="declare/assets/css/main.css" />
</head>

<body>
	<section id="footer">

	<div class="container">

		<header class="major">

		<h2>�޼�����</h2>
		<table width="600" border="1" cellspacing="0" cellpadding="3"
			align="center">
			<tr>
				<td width="200">������</td>
				<td width="400">${m_title}</td>
			</tr>
			<tr>
				<td width="200">�����</td>
				<td width="400">${co_com}</td>
			<tr>
				<td width="200">������̸�</td>
				<td width="400">${co_name}</td>
			</tr>
			<tr>
				<td width="200">����ڿ���ó</td>
				<td width="400">${co_phone}</td>
			</tr>
			<tr>
				<td width="200">�����E-Mail</td>
				<td width="400">${co_email}</td>
			</tr>
			<tr>
				<td width="200">����:</td>
				<td width="400" height="400">${m_context}</td>
			</tr>
			<%-- <tr>
				<td>����:</td>
				<td>${m_title}</td>
			</tr>
			<tr>
				<td>ȸ���̸�:</td>
				<td>${co_com}</td>
			</tr>
			<tr>
				<td>������̸�:</td>
				<td>${co_name}</td>
			</tr>
			<tr>
				<td>������ڵ���:</td>
				<td>${co_phone}</td>
			</tr>
			<tr>
				<td>�����E-Mail:</td>
				<td>${co_email}</td>
			</tr>
			<tr>
				<td>����:</td>
				<td>${m_context}</td>
			</tr> --%>
			<tr>
				<form method="get" action="p_messageList.do">
					<input type="hidden" name="m_count" value="${m_count}" /> <input
						type="hidden" name="m_num" value="${m_num}" /> <input
						type="submit" value="Ȯ��" />
				</form>
			</tr>
		</table>
		</header>
	</div>

	</section>

	<!-- Scripts -->
	<script src="declare/assets/js/jquery.min.js"></script>
	<script src="declare/assets/js/jquery.scrollex.min.js"></script>
	<script src="declare/assets/js/jquery.scrolly.min.js"></script>
	<script src="declare/assets/js/skel.min.js"></script>
	<script src="declare/assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="declare/assets/js/main.js"></script>

</body>
</html>