package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

public class Co_detailAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con=new Connection();
		SqlSession session=con.connection();
		
		String p_id=request.getParameter("id");
		int num=Integer.parseInt(request.getParameter("num"));
		Map map=new HashMap();
		map.put("p_id", p_id);
		map.put("f_num", num);
		DB.P_MemBean person=session.selectOne("co_board.who_per", p_id);
		DB.FileBean file=session.selectOne("co_board.who_item", map);
		int success=session.update("co_board.countup", num);
		if(success>0){
			session.commit();
		}
		else
			session.rollback();
		request.setAttribute("person", person);
		request.setAttribute("file", file);
		
		return "co_detail.jsp";
	}

}
