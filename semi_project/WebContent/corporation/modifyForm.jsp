<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="DB.Co_MemBean"%>
<%@ include file="./view/color.jspf"%>

<html>
<head>
<title>기업회원 정보수정</title>
<link href="style.css" rel="stylesheet" type="text/css">


<script language="JavaScript">
   <!--
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
 
-->
</script>

<%
    String co_id = (String)session.getAttribute("co_id");
  
    LogonDBBean manager = LogonDBBean.getInstance();
    LogonDataBean c = manager.getMember(co_id);

try{
%>

<body bgcolor="${bodyback_c}>">
	<form method="post" action="modifyPro.jsp" name="userinput"
		onsubmit="return checkIt()">

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
				<td width="400" bgcolor="${value_c}"></td>
			<tr>
			<tr>
				<td width="200">아이디</td>
				<td width="400"><%=c.getco_Id()%></td>
			</tr>

			<tr>
				<td width="200">패스워드</td>
				<td width="400"><input type="password" name="co_passwd" size="10" maxlength="20" value="<%=c.getPasswd()%>"></td>
			<tr>
				<td width="200">사업자번호</td>
				<td width="400"><%=c.getco_number()%> 
				<input type="text"name="co_number" size="15" maxlength="20" value="<%=c.getco_number()%>"></td>
			</tr>
			<tr>
			<tr>
				<td width="200" bgcolor="${value_c}"><b>기업정보</b></td>
				<td width="400" bgcolor="${value_c}"></td>
			<tr>
			<tr>
				<td width="200">기업 이름 :</td>
				<td width="400"><input type="text" name="co_com" size="15" maxlength="20" value="<%=c.getco_com()%>"></td>
			</tr>
			<tr>
				<td width="200">회사전화번호</td>
				<td width="400"><input type="text" name="co_tel" size="15" maxlength="20" value="<%=c.getco_tel()%>"></td>
			</tr>
			<tr>
				<td width="200">업종</td>
				<td width="400">
					<%if(c.getco_job()==null){%> 
					<input type="text" name="co_job">
					<%}else{%> 
					<input type="text" name="co_job" size="40" maxlength="30" value="<%=c.getco_job()%>"> <%}%>
				</td>
			</tr>
			<tr>
				<td width="200">상세업종</td>
				<td width="400">
					<%if(c.getco_subjob()==null){%> 
					<input type="text" name="co_subjob">
					<%}else{%> <input type="text" name="co_subjob" size="60" maxlength="50" value="<%=c.getco_subjob()%>"> <%}%>
				</td>
			</tr>

			<tr>
				<td width="200" bgcolor="${value_c}"><b>담당자 정보</b></td>
				<td width="400" bgcolor="${value_c}"></td>
			<tr>
			<tr>
				<td width="200">담당자 이름 :</td>
				<td width="400"><input type="text" name="co_name" size="15" maxlength="20" value="<%=c.getco_name()%>">
			</tr>

			<tr>
				<td width="200">담당자 E-Mail :</td>
				<td width="400"><input type="text" name="co_email" size="15" maxlength="20" value="<%=c.getco_email()%>">
			</tr>
			<tr>
				<td width="200">담당자 전화번호</td>
				<td width="400"><input type="text" name="co_phone" size="15" maxlength="20" value="<%=c.getco_phone()%>"></td>
			
			
			<tr>
				<td colspan="2" align="center" bgcolor="${value_c}>"><input
					type="submit" name="modify" value="수   정"> <input
					type="button" value="취  소"
					onclick="javascript:window.location='main.jsp'"></td>
			</tr>
		</table>
	</form>
</body>
<%}catch(Exception e){}%>
</html>