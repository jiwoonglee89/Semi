package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.P_MemBean;

public class LoginAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con = new Connection();
		SqlSession session = con.connection();
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		int count=0;
		
		String a = request.getParameter("per_or_cor");
		System.out.println("a:::"+a);

		String confirm_co = session.selectOne("co_member.confirm", id);
		String confirm_per = session.selectOne("per_member.findpass", id);
		String confirm_admin = session.selectOne("admin.confirm", id);

		HttpSession httpsession = request.getSession();
		
		request.setAttribute("count", new Integer(count));
		
		if(request.getParameter("per_or_cor") == null){
			if(confirm_admin.equals(passwd)){
				httpsession.setAttribute("admin_id", id);
				request.setAttribute("select", new Integer(0));
			}
			else{
				return "errorPage.jsp";
			}
		}else if (request.getParameter("per_or_cor").equals("cor")) {
			if(session.selectOne("co_member.areyoublack", id)!=null){
				count=session.selectOne("co_member.areyoublack", id);
				request.setAttribute("count", new Integer(count));
			}
			if (confirm_co.equals(passwd)) {
				httpsession.setAttribute("co_id", id);
				request.setAttribute("select", new Integer(2));
				return "loginPro.jsp";
			} else {
				return "errorPage.jsp";
			}

		}else {
			if(session.selectOne("per_member.areyoublack", id)!=null){
				count=session.selectOne("per_member.areyoublack", id);
				request.setAttribute("count", new Integer(count));
			}
			if (confirm_per.equals(passwd)) {
				httpsession.setAttribute("p_id", id);
				request.setAttribute("select", new Integer(1));
				return "loginPro.jsp";
			} else {
				return "errorPage.jsp";
			}

		}
		return "loginPro.jsp";
	}

}
