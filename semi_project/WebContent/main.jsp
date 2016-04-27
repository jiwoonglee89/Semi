<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ include file="./view/color.jsp"%>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="view/style.css" rel="stylesheet" type="text/css">

<html>
<head><title>메인입니다..</title>
<script>
	function focusIt(){     
   		document.inform.id.focus();//내가 작업하고 있는 문서의 inform이라는 곳에 id에 커서를 가져다 줌
	}
	function checkIt(){
		inputForm=eval("document.inform");
		if(!inputForm.id.value){
			alert("아이디를 입력하세요..");
			inputForm.id.focus();
			return false;
			}
	   if(!inputForm.passwd.value){
		   alert("패스워드를 입력하세요..");
		   inputForm.passwd.focus();
		   return false;
		   }
	}
</script>
</head>
  
<body onLoad="focusIt();" bgcolor="<%= bodyback_c%>">
  <table width=250 cellpadding="0" cellspacing="0"  align="center" border="1" >
      <tr>
       <form name="inform" method="post" action="loginPro.do"  onSubmit="return checkIt();">
	   <td bgcolor="<%=title_c%>"  width="50" align="right">아이디</td>
       <td width="50" bgcolor="<%=value_c%>">
       <input type="text" name="id" size="15" maxlength="10"></td>
      </tr>
      <tr >
         <td bgcolor="<%=title_c%>"  width="50" align="right">패스워드</td>
         <td width="50" bgcolor="<%=value_c%>">
            <input type="password" name="passwd" size="15" maxlength="10"></td>
       </tr>
       <tr>
       	<td colspan="3" bgcolor="<%=title_c%>" align="center">
       		<a href="#" class="fa fa-user fa-2x"></a>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       		<a href="#" class="fa fa-building fa-2x"></a>
       		<br/>
       		<input type="radio" name="per_or_cor" value="per">개인회원
			<input type="radio" name="per_or_cor" value="cor">기업회원
       	</td>
       </tr>
       <tr>
          <td colspan="3" bgcolor="<%=title_c%>"   align="center">
            <input type="submit" name="Submit" value="로그인">
            <input type="button"  value="회원가입" onclick="javascript:window.location='join.jsp'">
          </td>
       </tr>
       </form>   
       </table>
     <br>
</body>
</html>