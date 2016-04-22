package per.action_S;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import DB.Co_MemBean;
import DB.MessageBean;
import action.CommandAction;
import per.action_W.Connection;

public class Message_Action implements CommandAction {

	String res = "config.xml";

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		Connection con = new Connection();
		SqlSession session = con.connection();

		ResultSet rs = null;
		Vector vecList = new Vector();

		try {

			Co_MemBean check = new Co_MemBean();
			MessageBean check2 = new MessageBean();

			String co_com = check.getCo_com();
			String m_title = check2.getM_title();
			Timestamp m_regdate = check2.getM_regdate();
			int count = check2.getCount();

			request.setAttribute("co_com", co_com);
			request.setAttribute("m_title", m_title);
			request.setAttribute("m_regdate", m_regdate);
			request.setAttribute("m_count", count);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/person/message_box.jsp";
	}

}
