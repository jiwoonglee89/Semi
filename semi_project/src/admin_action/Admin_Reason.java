package admin_action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import action.CommandAction;

public class Admin_Reason implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		Connection con = new Connection();
		SqlSession session = con.connection();
		
		String id = request.getParameter("id");
		List reasonList = null;
		int kind = 0;
		
		if (session.selectOne("per_member.find",id)!=null) {
			reasonList = session.selectList("black.info_p",id);
			kind = 1;
		}else {
			reasonList = session.selectList("black.info",id);
			kind = 2;
		}
		
		request.setAttribute("kind", kind);
		request.setAttribute("reasonList", reasonList);
		
		
		return "admin_reason.jsp";
	}

}
