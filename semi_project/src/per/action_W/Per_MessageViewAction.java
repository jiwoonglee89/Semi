package per.action_W;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import DB.Co_MemBean;
import DB.MessageBean;
import action.CommandAction;

public class Per_MessageViewAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		
		Connection con = new Connection();
		SqlSession session = con.connection();
		
		String m_num = request.getParameter("m_num");
		int m_count = 1;
		
		MessageBean mlist = session.selectOne("message.m_list2seq", m_num);

		String co_id = mlist.getCo_com();
		
		Co_MemBean colist = session.selectOne("message.co_list",co_id);
		
		
		
		request.setAttribute("m_title", mlist.getM_title());
		request.setAttribute("co_com", colist.getCo_com());
		request.setAttribute("co_name", colist.getCo_name());
		request.setAttribute("co_phone", colist.getCo_phone());
		request.setAttribute("co_email", colist.getCo_email());
		request.setAttribute("m_context", mlist.getM_context());
		request.setAttribute("m_count", new Integer(m_count));
		
		return "p_messageview.jsp";
	}
}
