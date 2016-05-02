package per.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import action.CommandAction;
import action.Connection;

public class ConfirmIdAction implements CommandAction {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("UTF-8");
		Connection con=new Connection();
		SqlSession session = con.connection();
		
		String p_id = session.selectOne("per_member.confirmId", request.getParameter("p_id"));
		int check;
		if(p_id==null){
			check=-1;
		}else
			check=1;
		
		request.setAttribute("p_id", p_id);
		request.setAttribute("check", new Integer(check));
		return "per_confirmId.jsp";
	}

}
