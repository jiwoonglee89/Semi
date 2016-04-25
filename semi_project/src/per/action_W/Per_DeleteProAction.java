package per.action_W;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.P_MemBean;
import action.CommandAction;

public class Per_DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

		Connection con = new Connection();
		SqlSession session = con.connection();
		
		try {
			HttpSession session2 = request.getSession();
			String id = (String) session2.getAttribute("memId");
			String passwd = request.getParameter("passwd");
			int success = 0;

			P_MemBean p_memInfo = session.selectOne("per_member.find", id);
			
			if (p_memInfo != null) {
				if ((p_memInfo.getP_passwd()).equals(passwd)) {
					session2.invalidate();
					success = 1;
				}
			}
			
			request.setAttribute("success", new Integer(success));
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "main.jsp";
	}

}
