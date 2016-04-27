package per.action_W;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.Black_db;
import DB.Co_MemBean;
import DB.MessageBean;
import DB.P_MemBean;
import action.CommandAction;
import per.action_W.Connection;

public class PerToCo_shinAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");

		Connection con = new Connection();
		SqlSession session = con.connection();

		HttpSession session2 = request.getSession();
		String p_id = (String) session2.getAttribute("p_id");
		
		String co_id = request.getParameter("co_id");
		String reason = request.getParameter("reason");

		Co_MemBean coBean = session.selectOne("co_member.find", co_id);

		
		//시퀀스넘버로 메세지타이틀가져옴
		int m_num = Integer.parseInt(request.getParameter("m_num"));
		MessageBean mbean = session.selectOne("message.m_list2seq",m_num);
		
		
		Black_db black = new Black_db();

		black.setCo_id(co_id);
		black.setReason(reason);

		int success = session.insert("black.addCo", black);

		if (success == 1) {
			session.commit();
		} else {
			session.rollback();
		}

		Black_db blacklist = session.selectOne("black.info", co_id);

		
		if (coBean!=null) {
			request.setAttribute("coBean", coBean);
			request.setAttribute("m_title", mbean.getM_title());
			request.setAttribute("success", success);
		}

		return "p_mainview.jsp";
	}

}
