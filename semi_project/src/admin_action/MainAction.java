package admin_action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

public class MainAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con=new Connection();
		SqlSession session=con.connection();
		List people=session.selectList("admin.all_per");
		List corporation=session.selectList("admin.all_cor");
		request.setAttribute("people", people);
		request.setAttribute("corporation", corporation);
		return "admin_main.jsp";
	}

}
