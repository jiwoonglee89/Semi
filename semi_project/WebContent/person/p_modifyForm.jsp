<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../view/color.jsp"%>
<html>
<head>
<title>개인회원정보수정</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
	function checkIt() {
		var userinput = eval("document.userinput");

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
	function zipCheck() {

		url = "zipcheck.do?check=y";
		/* check의 속성값을 y로 보내줌  */

		window.open(url,"post",
						"toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
</script>
<body bgcolor="<%=bodyback_c%>">

	<form method="get" action="p_modifyPro.do" name="userinput"
		onSubmit="return checkIt()">
		<table width="600" border="1" cellspacing="0" cellpadding="3" align="center">
			<tr>
				<td colspan="2" height="39" align="center" bgcolor="<%=value_c%>">
					<font size="+1"><b>개인회원정보수정</b></font>
				</td>
			</tr>
			<tr>
				<td width="200">사용자 ID</td>
				<td width="400">${p_id}</td>
			</tr>
			<tr>
				<td width="200">비밀번호</td>
				<td width="400"><input type="password" name="p_passwd" size="15" maxlength="12"></td>
			<tr>
				<td width="200">비밀번호 확인</td>
				<td width="400"><input type="password" name="p_passwd2" size="15" maxlength="12"></td>
			</tr>

			<tr>
				<td width="200" bgcolor="<%=value_c%>" colspan="2" align="center"><b>개인정보 입력</b></td>
		<%-- 		<td width="400" bgcolor="<%=value_c%>"></td> --%>
			<tr>
			<tr>
				<td width="200">이름</td>
				<td width="400"><input type="text" name="p_name" size="15" maxlength="10" value="${name}"></td>
			</tr>
			<tr>
				<td width="200">주민등록번호</td>
				<td width="400">
				<input type="text" name="jumin1" size="7" maxlength="6" value="${jumin1}"> 
				-<input type="text" name="jumin2" size="7" maxlength="7" value="${jumin2}"></td>
			</tr>
			<tr>
				<td width="200">성별</td>
				<td width="400">
				<input type="radio" name="p_gender" size="40" maxlength="30" value="male" checked="checked">남성
				<input type="radio" name="p_gender" size="40" maxlength="30" value="female">여성</td>
			</tr>
			<tr>
				<td width="200">Tel</td>
				<td width="400"><input type="text" name="p_tel" size="40" maxlength="30" value="${tel}"></td>
			</tr>
			<tr>
				<td width="200">E-Mail</td>
				<td width="400">
				<input type="text" name="p_email" size="40" maxlength="30" value="${email}"></td>
			</tr>
			<tr>
				<td width="200">생년월일</td>
				<td width="400">
				<input type="number" name="p_birth" size="40" maxlength="30" value="${birth}"></td>
			</tr>
			<tr>
				<td width="200">우편번호</td>
				<td><input type="text" name="p_zipcode" size="7" value="${zipcode}">
					<input type="button" value="우편번호찾기" onClick="zipCheck()">
					우편번호를 검색하세요.</td>
			</tr>
			<tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="p_address" size="70" value="${address}"></td>
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
				<td><textarea rows="30" cols="70" name="p_career" value="${career}"></textarea></td>
			</tr>
			
			<tr>
				<td>수상이력</td>
				<td><textarea rows="30" cols="70" name="p_award" value="${award}"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center" bgcolor="<%=value_c%>">
				<input type="submit" name="confirm" value="수정"> 
				<!-- <input type="reset" name="reset" value="다시입력">  -->
				<input type="button" value="취소" onclick="javascript:window.location=history.go(-1)"></td>
			</tr>
		</table>
	</form>
</body>
