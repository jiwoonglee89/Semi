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

public class PerToCo_shinProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");

		Connection con = new Connection();
		SqlSession session = con.connection();

		HttpSession session2 = request.getSession();
		String p_id = (String) session2.getAttribute("p_id");
		
		//여기수정해야함
		String co_id = request.getParameter("co_id");
		String reason = request.getParameter("reason");

		
		
		
		Black_db black = new Black_db();
		black.setCo_id(co_id);
		black.setReason(reason);

		int success = session.insert("black.addCo", black);

		if (success == 1) {
			session.commit();
		} else {
			session.rollback();
		}

		//Black_db blacklist = session.selectOne("black.info", co_id);

		request.setAttribute("success", success);
		

		return "per2co_declare.jsp";
	}

}
