package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.P_MemBean;

public class LoginAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con=new Connection();
		SqlSession session=con.connection();
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String passwd=request.getParameter("passwd");
		
		
		String confirm_co=session.selectOne("co_member.confirm", id);
		String confirm_per=session.selectOne("per_member.findpass", id);
		
		
		HttpSession httpsession=request.getSession();
		
		if(request.getParameter("per_or_cor").equals("cor")){
			if(confirm_co.equals(passwd)){
				httpsession.setAttribute("co_id", id);
				request.setAttribute("select", new Integer(2));
				return "loginPro.jsp";
			}
			else {
				return "main.jsp";
			}
			
		}
		else{
			if(confirm_per.equals(passwd)){
				httpsession.setAttribute("p_id", id);
				request.setAttribute("select", new Integer(1));
				return "loginPro.jsp";
			}
			else {
				return "main.jsp";
			}
			
		}
		
		
		
		/*HttpSession httpsession=request.getSession();
		if(confirm_co.equals(passwd)){
			httpsession.setAttribute("co_id", id);
			return "loginPro.jsp";
		}
		else {
			return "main.jsp";
		}*/
	}

}
