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
		
		
		
		String id = request.getParameter("p_id");
		String passwd = request.getParameter("p_passwd");
		P_MemBean check = new P_MemBean(id,passwd);
		P_MemBean p_id = session.selectOne("member.pcheck",check.getP_id());
		
		if((p_id.getP_id()).equals(p_id)){
			if((p_id.getP_passwd()).equals(passwd)){
				session.commit();
				System.out.println("�α��� ����");
			}else{
				System.out.println("�α��� ����"); 
			}
		}else{
			System.out.println("�α��� ����");
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
