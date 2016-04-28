package per.action_S;

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

public class Per_QnA_Sin implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");

		Connection con = new Connection();
		SqlSession session = con.connection();

		HttpSession session2 = request.getSession();

		String p_id = (String) session2.getAttribute("p_id");
		String co_id = request.getParameter("co_id");
		//String m_title = request.getParameter("m_title");

		//List pMem = session.selectList("black.p_mem", p_id);
		List coMem = session.selectList("black.co_mem", co_id);
		List mMem = session.selectList("black.m_title", p_id);

		String reason = null;

		Black_db list = session.selectOne("black.search", co_id);

		try {

			if (mMem!=null) {
				if (coMem!=null) {

					request.setAttribute("mMem", mMem);
					request.setAttribute("coMem", coMem);
					//request.setAttribute("pMem", pMem);
					reason = request.getParameter("reason");

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("reason", reason);

		int success = session.insert("black.add", list);

		if (success == 1) {
			session.commit();
		} else {
			session.rollback();
		}

		return null;
	}

}
