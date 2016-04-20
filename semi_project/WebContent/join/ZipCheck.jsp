<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="java.util.*,DB.*"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%request.setCharacterEncoding("euc-kr"); %>
<html>
<head>
<title>우편번호검색</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
	function dongCheck() {
		if (document.zipForm.area4.value == "") {
			alert("동이름을 입력하세요");
			document.zipForm.area4.focus();
			return;
		}
		document.zipForm.submit();
	}

	function sendAddress(zipcode, area1, area2, area3 ,area4) {
		var address = area1 + " " + area2 + " "  + area3 + " "  + area4;
		opener.document.userinput.zipcode.value = zipcode;
		opener.document.userinput.address.value = address;
		self.close();
	}
</script>
</head>
<body align="center" bgcolor="#FFFFCC">
	
		<b>우편번호 찾기</b>
		<form name="zipForm" method="post" action="zipcheck.do">
		<table>
			
				<tr>
					<td><br> 도로명 주소 입력 : <input name="area4" type="text">
						<input type="button" value="검색" onclick="dongCheck();">
						<input type="hidden" name="check" value="n">
						</td>
				</tr>
					
		
			
			<c:if test="${check=='n'}">
			
				<c:if test="${totalList==0 }">
				<tr>
					<td align="center"><br>검색된 결과가 없습니다.</td>
				</tr>
				</c:if>
				
				<c:if test="${totalList!=0 }"> 
				<tr>
					<td align="center"><br> ※검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.</td>
				</tr>
		
			<c:forEach var="i" items="${zipcodeList}">
				<c:set var="tempZipcode" value="${i.zipcode}" />
				<c:set var="temptArea1" value="${i.area1}"/>
				<c:set var="temptArea2" value="${i.area2}"/>
				<c:set var="temptArea3" value="${i.area3}"/>
				<c:set var="temptArea4" value="${i.area4}"/>
			<tr>
				<!-- 출력되는 주소에 a태그 걸려있음 -->
				<td><a href="javascript:sendAddress('${tempZipcode}','${temptArea1}',
				'${temptArea2}','${temptArea3}','${temptArea4}')">
	${tempZipcode}&nbsp;${temptArea1}&nbsp;${temptArea2}&nbsp; ${temptArea3}&nbsp; ${temptArea4}</a><br>
					
				</td>
				</tr>
				</c:forEach>
				</c:if>
				
			</c:if>
			</td>
			</tr>	
			
			
			<tr>
				<td align="center"><br>
				<a href="javascript:this.close();">닫기</a>
			<tr>
				</td>
		</table>
	</form>

</body>
</html>