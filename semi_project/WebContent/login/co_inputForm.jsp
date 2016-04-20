<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="DB.Co_MemBean"%>
<%@ include file="./view/color.jspf"%>
<html>
<head>
<title>기업 회원가입</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript">

function checkIt() {
	var userinput = eval("document.userinput");

	if (!userinput.co_id.value) {
		alert("ID를 입력하세요. ");
		return false;
	}

	if (!userinput.co_passwd.value) {
		alert("비밀번호를 입력하세요. ");
		return false;
	}
	if (userinput.co_passwd.value != userinput.co_passwd2.value) {
		alert("비밀번호를 동일하게 입력하세요");
		return false;
	}

	if (userinput.co_number.value == "") {
		alert("사업자 번호를 입력하세요.");
		return false;
	}
	return true;
}

function openConfirmid(userinput) {
	// 아이디를 입력했는지 검사
	if (userinput.co_id.value == "") {
		alert("아이디를 입력하세요");
		return;
	}
	// url과 사용자 입력 id를 조합합니다.
	url = "confirmId.jsp?id=" + userinput.co_id.value;

	// 새로운 윈도우를 엽니다.
	open(
			url,
			"confirm",
			"toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300,height=200");
	}
</script>
</head>


<body bgcolor="${bodyback_c}">
	<form method="post" action="inputPro.do" name="userinput"
		onSubmit="return checkIt()">
		<table width="600" border="1" cellspacing="0" cellpadding="3"
			align="center">
			<tr>
				<td colspan="2" height="39" align="center" bgcolor="${value_c}">
					<font size="+1"><b>기업회원 회원가입</b></font>
				</td>
			</tr>

			<tr>
				<td width="200">아이디 :</td>
				<td width="400"><input type="text" name="co_id" size="10" maxlength="12"> 
					<input type="button" name="confirm_id" value="ID중복확인" OnClick="openConfirmid(this.form)"></td>
			</tr>
			<tr>
				<td width="200">패스워드 :</td>
				<td width="400"><input type="password" name="co_passwd"	size="15" maxlength="20"></td>
			<tr>
				<td width="200">패스워드 확인 :</td>
				<td width="400"><input type="password" name="co_passwd2" size="15" maxlength="20"></td>
			</tr>
			<tr>
				<td width="200">사업자 번호 :</td>
				<td width="400"><input type="text" name="co_number" size="15" maxlength="20"></td>
			</tr>
			<tr>
				<td width="200" bgcolor="${value_c}"><b>기업 정보</b></td>
				<td width="400" bgcolor="${value_c}"></td>
			<tr>
			<tr>
				<td width="200">기업 이름 :</td>
				<td width="400"><input type="text" name="co_com" size="15" maxlength="20"></td>
			</tr>
			<tr>
				<td width="200">회사 전화번호 :</td>
				<td width="400"><input type="text" name="co_tel" size="15" maxlength="20"></td>
			</tr>
			<tr>
				<td width="200">업종 :</td>
				<td width="400"><input type="text" name="co_job" size="15"></td>
				<select name="co_job" size="1" >
				<option value="0" >웹디자인 </option>
				<option value="1" >산업디자인 </option>
				<option value="2" >게임디자인</option>
				</select>
			</tr>
			<tr>
				<td width="200">상세업종 :</td>
				<td width="400"><input type="text" name="co_subjob" size="15"></td>
				<select name="co_subjob" size="1" >
				<option value="0" >웹디자인 </option>
				<option value="1" >산업디자인 </option>
				<option value="2" >게임디자인</option>
				</select>
			</tr>
			<tr>
				<td width="200">기업기관분류 :</td>
				<td><input type="text" name="co_category" size="15">
				<select name="co_category" size="1" >
				<option value="0" >중소기업 </option>
				<option value="1" >중견기업 </option>
				<option value="2" >대기업</option>
				</select>
			</tr>

			<tr>
				<td width="200" bgcolor="${value_c}"><b>담당자 정보</b></td>
				<td width="400" bgcolor="${value_c}"></td>
			</tr>

			<tr>
				<td width="200">담당자 이름 :</td>
				<td width="400"><input type="text" name="co_name" size="15" maxlength="30"></td>
			<tr>
				<td width="200">담당자 E-Mail :</td>
				<td width="400"><input type="text" name="co_email" size="15" maxlength="30"></td>
			</tr>
			<tr>
				<td width="200">담당자 전화번호 :</td>
				<td width="400"><input type="text" name="co_phone" size="15" maxlength="20"></td>
			</tr>


			<tr>
				<td colspan="2" align="center" bgcolor="${value_c}"><input
					type="submit" name="confirm" value="회원가입"> <input
					type="button" value="취소"
					onclick="javascript:window.location='main.jsp'"></td>
			</tr>
		</table>
	</form>




</body>
</html>