package per.action;

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

		HttpSession session2 = request.getSession();
		String p_id = (String) session2.getAttribute("p_id");
		String passwd = request.getParameter("passwd");

		P_MemBean p_memInfo = session.selectOne("per_member.find", p_id);

		if (p_memInfo != null) {
			if ((p_memInfo.getP_passwd()).equals(passwd)) {
				session.delete("per_member.remove", p_id);
				session.commit();
				session2.invalidate();
			}
			return "p_deletePro.jsp";
			
		}


		return "p_deleteForm.jsp";
	}

}
