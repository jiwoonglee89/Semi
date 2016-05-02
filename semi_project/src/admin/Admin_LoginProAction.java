package admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import DB.AdminBean;
import action.CommandAction;
import per.action.Connection;

public class Admin_LoginProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		Connection con = new Connection();
		SqlSession session = con.connection();
		
		try{
		String admin_id = request.getParameter("admin_id");
		String admin_passwd = request.getParameter("admin_passwd");
		
		AdminBean aBean = session.selectOne("admin.find",admin_id);
		
		if(aBean != null){
			if(aBean.getAdmin_passwd().equals(admin_passwd)){
				session.commit();
			}else{
				session.rollback();
				}
		}else{
			session.rollback();
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return "/login/loginPro.jsp";
	}

}
