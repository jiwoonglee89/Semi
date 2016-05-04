package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

public class Co_deleteProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con=new Connection();
		SqlSession session=con.connection();
		HttpSession httpsession=request.getSession();
		String co_id=(String)httpsession.getAttribute("co_id");
		String passwd=session.selectOne("co_member.find_passwd", co_id);
		int success;
		if(passwd.equals(request.getParameter("co_passwd"))){
			success=session.delete("co_member.remove", co_id);
		}else{
			success=0;
		}
		if(success<=0){
			return "../main.jsp";
		}else
			session.commit();
			return "co_deletePro.jsp";
	}

}
