package per.action_S;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import DB.MessageBean;
import action.CommandAction;
import per.action_W.Connection;

public class Message implements CommandAction {

	String res = "config.xml";

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		Connection con = new Connection();
		SqlSession session = con.connection();

		try {
			request.setCharacterEncoding("UTF-8");

			String p_id = request.getParameter("p_id");
			String co_id = request.getParameter("co_id");
			String m_title = request.getParameter("m_title");
			String m_context = request.getParameter("m_context");
			Timestamp m_regdate = new Timestamp(System.currentTimeMillis());

			MessageBean check = new MessageBean(p_id, co_id, m_title, m_context, m_regdate);

			int success = session.update("message.add", check);

			if (success > 0) {
				session.commit(); 
			} else {
				session.rollback();
			}

			request.setAttribute("success", success);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/login/message.jsp";
	}
}
