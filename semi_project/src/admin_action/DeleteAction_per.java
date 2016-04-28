package admin_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import action.*;

public class DeleteAction_per implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con = new Connection();
		SqlSession session = con.connection();

		String p_id = request.getParameter("id");

		int success_p = session.insert("admin.remove_per", p_id);
		int success_count_p = session.update("admin.countup_per", p_id);

		if (success_p > 0 || success_count_p > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		return "admin_main.jsp";

	}

}
