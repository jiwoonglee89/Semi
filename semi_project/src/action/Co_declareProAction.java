package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

public class Co_declareProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con=new Connection();
		SqlSession session=con.connection();
		String p_id=request.getParameter("p_id");
		String reason=request.getParameter("reason");
		Map map=new HashMap();
		map.put("p_id", p_id);
		map.put("reason", reason);
		int success=session.insert("black.addPer", map);
		if(success>0){
			session.commit();
			session.update("per_member.countup");
			session.commit();
		}
		else
			session.rollback();
		request.setAttribute("success", new Integer(success));
		return "co_declarePro.jsp";
	}

}
