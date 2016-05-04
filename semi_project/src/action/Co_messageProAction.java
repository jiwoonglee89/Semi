package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

public class Co_messageProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Connection con=new Connection();
		SqlSession sqlsession=con.connection();
		HttpSession httpsession=request.getSession();
		String co_id=(String)httpsession.getAttribute("co_id");
		String title=request.getParameter("m_title");
		String context=request.getParameter("m_context");
		String p_id=request.getParameter("id");
		
		Map map=new HashMap();
		map.put("p_id", p_id);
		map.put("co_id", co_id);
		map.put("m_title", title);
		map.put("m_context", context);
		
		String com=sqlsession.selectOne("message.find_com", co_id);
		map.put("co_com", com);
		if(sqlsession.insert("message.add", map)>0){
			sqlsession.commit();
		}else{
			sqlsession.rollback();
		}
		
		return "co_messagePro.jsp";
	}

}
