<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="view/color.jspf"%>

<html>
<head>
<title>기업회원 정보수정</title>
<link href="view/style.css" rel="stylesheet" type="text/css">


<script>
   function checkIt() { 
		var userinput = eval("document.userinput");

		if (!userinput.co_passwd.value) {
			alert("비밀번호를 입력하세요.");
			return false;
		}
		if (userinput.co_com.value == "") {
			alert("기업 이름을 입력하세요.");
			return false;
		}
		if (userinput.co_boss.value == "") {
			alert("대표자명을 입력하세요.");
			return false;
		}
		if (userinput.co_tel.value == "") {
			alert("회사 번호를 입력하세요.");
			return false;
		}
		if (userinput.co_job.value == "") {
			alert("업종을 선택해주세요.");
			return false;
		}
		if (userinput.co_subjob.value == "-1") {
			alert("상세업종을 선택해주세요.");
			return false;
		}
		if (userinput.co_name.value == "") {
			alert("담당자 이름을 입력해주세요.");
			return false;
		}
		if (userinput.co_email.value == "") {
			alert("담당자 이메일을 입력해주세요.");
			return false;
		}
		if (userinput.co_phone.value == "") {
			alert("담당자 휴대폰 번호를 입력해주세요.");
			return false;
		}
		return true;
	}
</script>


<%try{%>
</head>
<body bgcolor="${bodyback_c}>">
	<form method="post" action="co_modifyPro.do" name="userinput" onsubmit="return checkIt()">

		<table width="600" border="1" cellspacing="0" cellpadding="3"
			align="center">
			<tr>
				<td colspan="2" height="39" bgcolor="${title_c}" align="center">
					<font size="+1"><b>기업회원 정보수정</b></font>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="normal" align="center">회원의 정보를 수정합니다.</td>
			</tr>
			<tr>
				<td width="200" bgcolor="${value_c}"><b>아이디</b></td>
				<td width="400" bgcolor="${value_c}">${co_id}</td>
			<tr>
			

			<tr>
				<td width="200">패스워드</td>
				<td width="400"><input type="password" name="co_passwd" size="10" maxlength="20" value="${co.co_passwd}"></td>
			<tr>
				<td width="200">사업자번호</td>
				<td width="400">
				<input type="text"name="co_number" size="15" maxlength="20" value="${co.co_number}"></td>
			</tr>
			<tr>
			<tr>
				<td width="200" bgcolor="${value_c}"><b>기업정보</b></td>
				<td width="400" bgcolor="${value_c}"></td>
			<tr>
			<tr>
				<td width="200">기업 이름 :</td>
				<td width="400"><input type="text" name="co_com" size="15" maxlength="20" value="${co.co_com}"></td>
			</tr>
			<tr>
				<td width="200">대표자 명 :</td>
				<td width="400"><input type="text" name="co_boss" size="15" maxlength="20" value="${co.co_boss}"></td>
			</tr>
			
			<tr>
				<td width="200">회사전화번호</td>
				<td width="400"><input type="text" name="co_tel" size="15" maxlength="20" value="${co.co_tel}"></td>
			</tr>
			
			
			<tr>
				<td width="200">업종 :</td>
				<td width="400">
				<select name="co_job" size="1">
				<option value="0" >제조업 </option>
				<option value="1" >정보통신업 </option>
				<option value="2" >건설 토목업</option>
				<option value="3" >개인 가사서비스업</option>
				<option value="4" >공공 의료 사회기반사업</option>
				<option value="5" >여행 숙박 음식점업</option>
				<option value="6" >기타</option>
				</select>
			
				</td>
			</tr>
			
			<tr>
				<td width="200">상세업종 :</td>
				<td width="400">
				<select name="co_subjob" size="1" >
				<option value="-1">----- 제조업 ----- </option>
				<option value="0" >농업 임업 어업 광업</option>
				<option value="1" >가죽 가방 신발</option>
				<option value="2" >기계 조선 자동차 운송장비</option>
				<option value="3" >컴퓨터 하드웨어 장비</option>
				<option value="4" >생활 용품 화장품</option>
				<option value="5" >전자 전기 반도체</option>
				<option value="6" >제조업 기타</option>
				<option value="-1">----- 정보통신업 -----</option>
				<option value="0" >네트워크 통신</option>
				<option value="1" >소프트웨어 솔루션 ASP</option>
				<option value="2" >인터넷 포털 컨텐츠 게임</option>
				<option value="3" >쇼핑몰 전자상거래 오픈마켓</option>
				<option value="4" >웹 에이전시 IT 컨설팅</option>
				<option value="5" >모바일 무선 </option>
				<option value="6" >디자인 CAD</option>
				<option value="-1">----- 건설토목업 -----</option>
				<option value="0" >건설 건축 토목 조경</option>
				<option value="1" >인테리어 디자인</option>
				<option value="2" >건축사 감리회사</option>
				<option value="3" >부동산 개발 시행 분양</option>
				<option value="4" >토목 ENG CM 시험 측량</option>
				<option value="5" >건설자재 중장비 </option>
				<option value="6" >전기 설비 환경 플랜트</option>
				<option value="-1">-----개인 가사서비스업-----</option>
				<option value="0" >건설 건축 토목 조경</option>
				<option value="1" >수리업</option>
				<option value="2" >하수 폐기물 청소</option>
				<option value="3" >개인서비스</option>
				<option value="4" >가사 서비스</option>
				<option value="-1">-----공공 의료 사회기반 사업-----</option>
				<option value="0" >의약 보건 사회복지</option>
				<option value="1" >정부 비영리 단체</option>
				<option value="2" >전기 가스 수도 에너지</option>
				<option value="3" >국제 및 외국 기관</option>
				<option value="-1">-----여행 숙박 음식점업-----</option>
				<option value="0" >호텔 여행 항공</option>
				<option value="1" >식음료 외식(프랜차이즈)</option>
				
				</select>				
				</td>
			</tr>
			<tr>
				<td width="200">기업기관분류</td>
				<td width="400">
					<c:if test="${co.co_category==null}"> 
					<select name="co_category" size="1" >
					<option value="0" >일반기업</option>
					<option value="1" >서치펌 </option>
					<option value="2" >파견 대행 기업</option>
					<option value="3" >교육 기관</option>
					<option value="4" >기타</option>
				
				</select>
					</c:if>
					
					<c:if test="${co.co_category!=null}">
					<select name="co_category" size="1" >
						<option value="0" >일반기업</option>
						<option value="1" >서치펌 </option>
						<option value="2" >파견 대행 기업</option>
						<option value="3" >교육 기관</option>
						<option value="4" >기타</option>
				
				</select>
				</c:if>
				</td>
			</tr>

			<tr>
				<td width="200" bgcolor="${value_c}"><b>담당자 정보</b></td>
				<td width="400" bgcolor="${value_c}"></td>
			<tr>
			<tr>
				<td width="200">담당자 이름 :</td>
				<td width="400"><input type="text" name="co_name" size="15" maxlength="20" value="${co.co_name}"></td>
			</tr>

			<tr>
				<td width="200">담당자 E-Mail :</td>
				<td width="400"><input type="text" name="co_email" size="15" maxlength="20" value="${co.co_email}"></td>
			</tr>
			
			<tr>
				<td width="200">담당자 휴대폰 : </td>
				<td width="400"><input type="text" name="co_phone" size="15" maxlength="20" value="${co.co_phone}"></td>
			</tr>
			
			
			<tr>
				<td colspan="2" align="center" bgcolor="${value_c}>">
				<input type="submit" name="modify" value="수   정"> 
				<input type="button" name="co_delete" value="탈   퇴" onclick="javascript:window.location='co_deleteForm.jsp'">
				<input type="button" value="취  소" onclick="javascript:window.location=history.go(-1)"></td>
			</tr>
		</table>
	</form>
</body>
<%}catch(Exception e){}%>
</html>