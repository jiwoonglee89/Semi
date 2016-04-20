<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="DB.Co_MemBean"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<%
	String co_id = request.getParameter("co_id");
	String co_passwd = request.getParameter("co_passwd");

	LogonDBBean manager = LogonDBBean.getInstance();
	int check = manager.userCheck(co_id, co_passwd);

	if (check == 1) {
		session.setAttribute("co_id", co_id);
		response.sendRedirect("main.jsp");
	} else if (check == 0) {
%>
<script>
	alert("비밀번호가 맞지 않습니다.");
	history.go(-1);
</script>
<%
	} else {
%>
<script>
	alert("아이디가 맞지 않습니다..");
	history.go(-1);
</script>
<%
	}
%>