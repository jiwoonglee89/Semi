<%@ page contentType="text/html; charset=euc-kr"%>
<%-- <%@ include file="color.jsp"%> --%>
<html>
<head>
<title>ȸ������</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript">
	function checkIt() {
		var userinput = eval("document.userinput");

		if (!userinput.id.value) {
			alert("ID�� �Է��ϼ���");
			return false;
		}

		if (!userinput.passwd.value) {
			alert("��й�ȣ�� �Է��ϼ���");
			return false;
		}
		if (userinput.passwd.value != userinput.passwd2.value) {
			alert("��й�ȣ�� �����ϰ� �Է��ϼ���");
			return false;
		}

		if (!userinput.name.value) {
			alert("����� �̸��� �Է��ϼ���");
			return false;
		}

		if (!userinput.jumin1.value || !userinput.jumin2.value) {
			alert("�ֹε�Ϲ�ȣ�� �Է��ϼ���");
			return false;
		}
		return true;
	}

	// ���̵� �ߺ� ���θ� �Ǵ�
	function openConfirmid(userinput) {
		// ���̵� �Է��ߴ��� �˻�
		if (userinput.id.value == "") {
			alert("���̵� �Է��ϼ���");
			return;
		}
		// url�� ����� �Է� id�� �����մϴ�.
		url = "confirmId.do?id=" + userinput.id.value;

		// ���ο� �����츦 ���ϴ�.
		open(
				url,
				"confirm",
				"toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300,height=200");
	}

	function zipCheck() {

		url = "zipcheck.do?check=y";
		/* check�� �Ӽ����� y�� ������  */

		window
				.open(
						url,
						"post",
						"toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
</script>
<body bgcolor="#000000">

	<form method="get" action="inputPro.do" name="userinput"
		onSubmit="return checkIt()">
		<table width="600" border="1" cellspacing="0" cellpadding="3"
			align="center">
			<tr>
				<td colspan="2" height="39" align="center" bgcolor="#000000">
					<font size="+1"><b>ȸ������</b></font>
				</td>
			</tr>
			<tr>
				<td width="200" bgcolor="#000000"><b>���̵� �Է�</b></td>
				<td width="400" bgcolor="#000000"></td>
			</tr>

			<tr>
				<td width="200">����� ID</td>
				<td width="400"><input type="text" name="id" size="10"
					maxlength="12"> <input type="button" name="confirm_id"
					value="ID�ߺ�Ȯ��" OnClick="openConfirmid(this.form)"></td>
					<!-- this.form ��ư�� �����ִ�  ���� ���� ��� ȣ��  -->
			</tr>
			<tr>
				<td width="200">��й�ȣ</td>
				<td width="400"><input type="password" name="passwd" size="15"
					maxlength="12"></td>
			<tr>
				<td width="200">��й�ȣ Ȯ��</td>
				<td width="400"><input type="password" name="passwd2" size="15"
					maxlength="12" onblur=""></td>
			</tr>

			<tr>
				<td width="200" bgcolor="#000000"><b>�������� �Է�</b></td>
				<td width="400" bgcolor="#000000"></td>
			<tr>
			<tr>
				<td width="200">����� �̸�</td>
				<td width="400"><input type="text" name="name" size="15"
					maxlength="10"></td>
			</tr>
			<tr>
				<td width="200">����</td>
				<td width="400"><input type="radio" name="gender" size="15"
					maxlength="10"></td>
			</tr>
			<tr>
				<td width="200">�ֹε�Ϲ�ȣ</td>
				<td width="400"><input type="text" name="jumin1" size="7"
					maxlength="6"> -<input type="text" name="jumin2" size="7"
					maxlength="7"></td>
			</tr>
			<tr>
				<td width="200">E-Mail</td>
				<td width="400"><input type="text" name="email" size="40"
					maxlength="30"></td>
			</tr>
			<tr>
				<td width="200">Blog</td>
				<td width="400"><input type="text" name="blog" size="60"
					maxlength="50"></td>
			</tr>
			<tr>
				<td width="200">������ȣ</td>
				<td><input type="text" name="zipcode" size="7" readonly>
					<input type="button" value="������ȣã��" onClick="zipCheck()">
					������ȣ�� �˻��ϼ���.</td>
			</tr>
			<tr>
			<tr>
				<td>�ּ�</td>
				<td><input type="text" name="address" size="70"> �ּҸ� ����
					�ּ���.</td>
			</tr>
			<tr>
				<td colspan="2" align="center" bgcolor="#000000"><input
					type="submit" name="confirm" value="��   ��"> <input
					type="reset" name="reset" value="�ٽ��Է�"> <input
					type="button" value="���Ծ���"
					onclick="javascript:window.location='main.do'"></td>
			</tr>
		</table>
	</form>
</body>
</html>