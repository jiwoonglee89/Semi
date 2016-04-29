<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<%
	request.setCharacterEncoding("UTF-8");
%>
<body>
	<c:if test="${success==0 }">
		<script>
			alert("회원가입에실패하였습니다 정보를 다시 입력해주세요");
		</script>
			
			</c:if>
			<c:if test="${success==0 }">
		<c:redirect url="p_inputForm.do" context="/semi_project"/>
	</c:if>

	<c:if test="${success!=0 }">
		<script>
			alert("회원가입에성공하였습니다");
		</script>
		<c:redirect url="/main.do" context="/semi_project">
			<%-- <c:param name="memId" value="${memId}"></c:param> --%>
		</c:redirect>
	</c:if>

</body>
</html>