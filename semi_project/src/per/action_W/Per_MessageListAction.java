package per.action_W;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.Co_MemBean;
import DB.MessageBean;
import action.CommandAction;
import per.action_W.Connection;

public class Per_MessageListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		try {

			request.setCharacterEncoding("UTF-8");

			Connection con = new Connection();
			SqlSession session = con.connection();

			String co_id = request.getParameter("co_id");
			int m_count = 0;
			int m_count_request = Integer.parseInt(request.getParameter("m_count"));
			String m_countdes = null;

			
			Co_MemBean coBean = (Co_MemBean) session.selectList("message.co_list", co_id);

			MessageBean mBean = session.selectOne("message.m_list", co_id);

			
			request.setAttribute("co_com", coBean.getCo_com());
			request.setAttribute("m_title", mBean.getM_title());
			request.setAttribute("m_regdate", mBean.getM_regdate());

			if (m_count == m_count_request) {
				m_countdes = "읽지않음";
			} else {
				m_countdes = "읽음";
			}
			request.setAttribute("m_countdes", m_countdes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/person/p_messageList.jsp";
	}

}
