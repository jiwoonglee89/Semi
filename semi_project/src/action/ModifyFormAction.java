package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.Co_MemBean;

public class ModifyFormAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		Connection con=new Connection();
		SqlSession sqlsession=con.connection();
		HttpSession session=request.getSession();
		String co_id=(String)session.getAttribute("co_id");
		Co_MemBean co_member=new Co_MemBean();
		co_member=sqlsession.selectOne("co_member.find", session.getAttribute("co_id"));

		
		request.setAttribute("co", co_member);
		session.setAttribute("co_id", co_id);
		return "co_modifyForm.jsp";
	}

} 
