package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import DB.Co_MemBean;
import sql.*;



public class ModifyProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		HttpSession httpsession=request.getSession();
		String id=(String)httpsession.getAttribute("memId");
		Connection con=new Connection();
		SqlSession session=con.connection();
		Co_MemBean co_member=new Co_MemBean();
		co_member=session.selectOne("co_member.get", id);
		int success=session.update("co_member.modify", co_member);
		if(success>0){
			request.setAttribute("co", co_member);
		}else
			System.out.println("수정이 수행되지 않았습니다.");
		return "co_modifyPro.jsp";
	}
}
