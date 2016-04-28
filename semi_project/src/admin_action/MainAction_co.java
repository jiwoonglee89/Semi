package admin_action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import action.CommandAction;

public class MainAction_co implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con = new Connection();
		SqlSession session = con.connection();

		int num2 = Integer.parseInt(request.getParameter("who_co"));
		request.setAttribute("who_co", num2);

		List corporation = session.selectList("admin.all_co");

		request.setAttribute("coporation", corporation);

		return "/admin_main.jsp";

	}

}
