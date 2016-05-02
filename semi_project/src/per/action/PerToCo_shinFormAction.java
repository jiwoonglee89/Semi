package per.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.Co_MemBean;
import DB.MessageBean;
import action.CommandAction;

public class PerToCo_shinFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");

		Connection con = new Connection();
		SqlSession session = con.connection();

		HttpSession session2 = request.getSession();
		String p_id = (String) session2.getAttribute("p_id");

		
		
		String co_id = request.getParameter("co_id");

		Co_MemBean coBean = session.selectOne("co_member.find", co_id);

		// 시퀀스넘버로 메세지타이틀가져옴
		int m_num = Integer.parseInt(request.getParameter("m_num"));
		MessageBean mbean = session.selectOne("message.m_list2seq", m_num);

		if (coBean != null) {
			request.setAttribute("co_id", co_id);
			request.setAttribute("coBean", coBean);
			request.setAttribute("success", new Integer(0));
			request.setAttribute("m_title", mbean.getM_title());
		}
		return "per2co_declare.jsp";
	}

}
