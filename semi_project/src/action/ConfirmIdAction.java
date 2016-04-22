package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

public class ConfirmIdAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		String co_id=request.getParameter("id");
		Connection con=new Connection();
		SqlSession session = con.connection();
		String id = session.selectOne("co_member.confirmId", co_id);
		int check;
		if(id==null){
			check=-1;
		}else
			check=1;
		request.setAttribute("check", check);	
		return "confirmId.jsp";
	}

}
