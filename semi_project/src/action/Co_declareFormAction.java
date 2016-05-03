package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

public class Co_declareFormAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		Connection con=new Connection();
		SqlSession sqlsession=con.connection();
		
		String p_id=request.getParameter("id");
		String m_title=request.getParameter("title");
		DB.P_MemBean person=sqlsession.selectOne("per_member.find", p_id);
		request.setAttribute("m_title", m_title);
		request.setAttribute("person", person);
		return "/declare/co2per_declare.jsp";
	}

}
