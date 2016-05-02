package per.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import DB.Black_db;
import DB.MessageBean;
import DB.P_MemBean;
import action.CommandAction;

public class CoToPer_shinAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {


		Connection con = new Connection();
		SqlSession session = con.connection();
		
		String p_id = request.getParameter("p_id");
		String reason = request.getParameter("reason");
		
		P_MemBean pbean = session.selectOne("per_member.find",p_id);
		
		Black_db black = new Black_db();
		black.setP_id(p_id);
		black.setReason(reason);
		
		int m_num = Integer.parseInt(request.getParameter("m_num"));
		MessageBean mbean = session.selectOne("message.m_list2seq",m_num);
		
		int success = session.insert("black.addPer",black);
		if (success >0) {
			session.commit();
			System.out.println("블랙Db 개인 아이디 입력됨");
		}else {
			session.rollback();
			System.out.println("블랙Db 개인 아이디 입력안됨");
		}
		
		
		request.setAttribute("pbean", pbean);
		request.setAttribute("m_title", mbean.getM_title());
		
		return "co_main.jsp";
	}

}
