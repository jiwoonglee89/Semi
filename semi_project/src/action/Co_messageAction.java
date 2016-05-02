package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

public class Co_messageAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con=new Connection();
		SqlSession session=con.connection();
		String p_id=request.getParameter("id");
		DB.P_MemBean person=session.selectOne("per_member.find", p_id );
		
		request.setAttribute("person", person);
		
		
		return "co_message.jsp";
	}

}
