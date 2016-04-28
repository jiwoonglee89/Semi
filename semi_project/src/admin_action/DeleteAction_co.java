package admin_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import action.CommandAction;

public class DeleteAction_co implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con = new Connection();
		SqlSession session = con.connection();

		String co_id = request.getParameter("co_id");
		//System.out.println(co_id);
		int success_co = session.insert("admin.remove_co", co_id);
		int success_count_co = session.update("admin.countup_co", co_id);

		if (success_co > 0 || success_count_co > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		return "admin_main.jsp";
	}

}
