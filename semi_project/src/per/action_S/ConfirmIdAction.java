package per.action_S;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import action.CommandAction;
import action.Connection;


public class ConfirmIdAction implements CommandAction {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		System.out.println("½ÇÇà");
		
		request.setCharacterEncoding("UTF-8");
		Connection con=new Connection();
		SqlSession session = con.connection();
		String p_id=request.getParameter("p_id");
		
		String id = session.selectOne("per_member.confirmId", p_id);
		int check;
		if(id==null){
			check=-1;
		}else
			check=1;
		request.setAttribute("check", check);	
		return "per_confirmId.jsp";
	}

}
