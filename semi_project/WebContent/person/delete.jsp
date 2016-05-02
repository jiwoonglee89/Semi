<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="pds.service.IncreaseDownloadCountService" %>
<%@ page import="pds.service.DecreaseDownloadCountService" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="pds.service.PdsItemNotFoundException" %>
<%@ page import="pds.file.*" %>
<%@ page import="pds.model.PdsItem" %>
<%@ page import="pds.service.GetPdsItemService" %>
<%
	int id=Integer.parseInt(request.getParameter("id"));
	PdsItem item=GetPdsItemService.getInstance().getPdsItem(id);
	FileDeleteHelper.delete(item.getRealPath()); 
	DecreaseDownloadCountService.getInstance().decreaseCount(id);
%>
<html>
<body>
<script>
	alert("파일이 지워졌습니다.")
	history.go(-1);
</script>
</body>
</html>