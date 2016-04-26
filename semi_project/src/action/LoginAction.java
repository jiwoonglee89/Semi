package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

public class LoginAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con=new Connection();
		SqlSession session=con.connection();
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String passwd=request.getParameter("passwd");
		String confirm=session.selectOne("co_member.confirm", id);
		if(request.getParameter("per_or_cor").equals("per")){
			request.setAttribute("select", new Integer(1));
		}else{
			request.setAttribute("select", new Integer(2));
		}
		
		HttpSession httpsession=request.getSession();
		if(confirm.equals(passwd)){
			httpsession.setAttribute("co_id", id);
			return "loginPro.jsp";
		}
		else {
			return "main.jsp";
		}
	}

}
