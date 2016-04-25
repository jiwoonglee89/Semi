package per.action_S;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.P_MemBean;
import action.CommandAction;
import per.action_W.Connection;

public class Per_LoginPro implements CommandAction{

	String res = "config.xml";
	
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con=new Connection();
		SqlSession session = con.connection();
		
		try{
			HttpSession session2 = request.getSession();
		
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		P_MemBean p_bean = new P_MemBean();
		P_MemBean check = session.selectOne("member.find",p_bean.getP_id());
		
		if(check.equals(id)){
			if((p_bean.getP_passwd()).equals(passwd)){
				
				String mem_id = (String)session2.getAttribute("memId");
				request.setAttribute("p_id", mem_id);
				
				session.commit();
				System.out.println("로그인 성공");
			}else{
				session.rollback();
				System.out.println("로그인 실패"); 
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
