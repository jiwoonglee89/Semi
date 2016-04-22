package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

public class DeleteAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con=new Connection();
		SqlSession session=con.connection();
		String passwd=session.selectOne("co_member.find_passwd", request.getAttribute("id"));
		int success;
		if(passwd.equals(request.getParameter("co_passwd"))){
			success=session.delete("co_member.remove", request.getParameter("id"));
		}else{
			success=0;
		}
		if(success>0){
			return "/main.jsp";
		}else
			return "deleteForm.jsp";
	}

}
