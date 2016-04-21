<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	session.setAttribute("memId", id);
%>
<%-- 
<%
	member.setReg_date(new Timestamp(System.currentTimeMillis()));
	LogonDBBean manager = LogonDBBean.getInstance();
	manager.insertMember(member);

	response.sendRedirect("loginForm.jsp");
%> --%>
<body>
	<c:if test="${success==0 }">
		<script>
			alert("회원가입에실패하였습니다 정보를 다시 입력해주세요");
			histroy.go(-1);
		</script>
	</c:if>

	<c:if test="${success!=0 }">
		<script>
			alert("회원가입에성공하였습니다");
		</script>
		<c:redirect url="/main.do" context="/semi_project">
			<c:param name="memId" value="${id}"></c:param>
		</c:redirect>
	</c:if>

</body>