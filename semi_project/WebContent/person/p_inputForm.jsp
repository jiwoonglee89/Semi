<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../view/color.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>회원가입</title>
<link href="view/style.css" rel="stylesheet" type="text/css">
<script>
	function checkIt() {
		var userinput = eval("document.userinput");

		if (!userinput.p_id.value) {
			alert("ID를 입력하세요");
			return false;
		}

		if (!userinput.p_passwd.value) {
			alert("비밀번호를 입력하세요");
			return false;
		}
		if (userinput.p_passwd.value != userinput.p_passwd2.value) {
			alert("비밀번호를 동일하게 입력하세요");
			return false;
		}

		if (!userinput.p_name.value) {
			alert("사용자 이름을 입력하세요");
			return false;
		}

		if (!userinput.jumin1.value || !userinput.jumin2.value) {
			alert("주민등록번호를 입력하세요");
			return false;
		}
		return true;
	}

	// 아이디 중복 여부를 판단
	function openConfirmid(userinput) {
		// 아이디를 입력했는지 검사
		if (userinput.p_id.value == "") {
			alert("아이디를 입력하세요");
			return;
		}
		// url과 사용자 입력 id를 조합합니다.
		url = "per_confirmId.do?id=" + userinput.p_id.value;

		// 새로운 윈도우를 엽니다.
		open(
				url,
				"confirm",
				"toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300,height=200");
	}

	function zipCheck() {

		url = "zipcheck.do?check=y";
		/* check의 속성값을 y로 보내줌  */

		window.open(url,"post",
						"toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
</script>
<body bgcolor="<%=bodyback_c%>">

	<form method="get" action="p_inputPro.do" name="userinput"
		onSubmit="return checkIt()">
		<table width="600" border="1" cellspacing="0" cellpadding="3"
			align="center">
			<tr>
				<td colspan="2" height="39" align="center" bgcolor="<%=value_c%>">
					<font size="+1"><b>회원가입</b></font>
				</td>
			</tr>
			<tr>
				<td width="200" bgcolor="<%=value_c%>"><b>아이디 입력</b></td>
				<td width="400" bgcolor="<%=value_c%>"></td>
			</tr>

			<tr>
				<td width="200">사용자 ID</td>
				<td width="400">
				<input type="text" name="p_id" size="10" maxlength="12"> 
				<input type="button" name="confirm_id" value="ID중복확인" OnClick="openConfirmid(this.form)"></td>
					<!-- this.form 버튼이 속해있는  폼의 값을 들고 호출  -->
			</tr>
			<tr>
				<td width="200">비밀번호</td>
				<td width="400">
				<input type="password" name="p_passwd" size="15" maxlength="12"></td>
			<tr>
				<td width="200">비밀번호 확인</td>
				<td width="400">
				<input type="password" name="p_passwd2" size="15" maxlength="12"></td>
			</tr>

			<tr>
				<td width="200" bgcolor="<%=value_c%>"><b>개인정보 입력</b></td>
				<td width="400" bgcolor="<%=value_c%>"></td>
			<tr>
			<tr>
				<td width="200">이름</td>
				<td width="400">
				<input type="text" name="p_name" size="15" maxlength="10"></td>
			</tr>
			<tr>
				<td width="200">주민등록번호</td>
				<td width="400"><input type="text" name="jumin1" size="7" maxlength="6"> 
				-<input type="text" name="jumin2" size="7" maxlength="7"></td>
			</tr>
			<tr>
				<td width="200">성별</td>
				<td width="400">
				<input type="radio" name="p_gender" size="40" maxlength="30" value="male" checked="checked">남성
				<input type="radio" name="p_gender" size="40" maxlength="30" value="female">여성</td>
			</tr>
			<tr>
				<td width="200">Tel</td>
				<td width="400"><input type="text" name="p_tel" size="40" maxlength="30"></td>
			</tr>
			<tr>
				<td width="200">E-Mail</td>
				<td width="400"><input type="text" name="p_email" size="40"
					maxlength="30"></td>
			</tr>
			<tr>
				<td width="200">생년월일</td>
				<td width="400"><input type="number" name="p_birth" size="40" maxlength="30" value="ex)19910101"></td>
			</tr>
			<tr>
				<td width="200">우편번호</td>
				<td><input type="text" name="p_zipcode" size="7">
					<input type="button" value="우편번호찾기" onClick="zipCheck()"> 우편번호를 검색하세요.</td>
			</tr>
			<tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="p_address" size="70"></td>
			</tr>
			<tr>
				<td width="200">디자인분류</td>
				<td width="400">
				<select name="p_category">
					<option>분야선택</option>
					<option value="0">산업디자인</option>
					<option value="1">웹디자인</option>
					<option value="2">건축디자인</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>경력사항</td>
				<td><textarea rows="30" cols="70" name="p_career"></textarea></td>
			</tr>
			
			<tr>
				<td>수상이력</td>
				<td><textarea rows="30" cols="70" name="p_award"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center" bgcolor="<%=value_c%>">
				<input type="submit" name="confirm" value="회원가입"> 
				<!-- <input type="reset" name="reset" value="다시입력">  -->
				<input type="button" value="취소" onclick="javascript:window.location='main.do'"></td>
			</tr>
		</table>
	</form>
	${gender1}
</body>
</html>