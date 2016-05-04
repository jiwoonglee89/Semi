package per.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.P_MemBean;
import action.CommandAction;
import per.action.Connection;

public class Per_LoginProAction implements CommandAction{

	String res = "config.xml";
	
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con=new Connection();
		SqlSession session = con.connection();
		
		try{
			HttpSession session2 = request.getSession();
		
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String memId = null;
		
		P_MemBean check = session.selectOne("per_member.find",id);
		
		if(check != null){
			if((check.getP_passwd()).equals(passwd)){
				
				memId = id;
				request.setAttribute("memId", memId);
				
				session.commit();
			}else{
				session.rollback();
			}
		}else{
			session.rollback();
			System.out.println("로그인 실패");
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return "/login/loginPro.jsp";
	}

}
