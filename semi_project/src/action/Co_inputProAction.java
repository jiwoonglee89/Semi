package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import DB.Co_MemBean;
import sql.*;

public class Co_inputProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		Connection con=new Connection();
		SqlSession session = con.connection();
		
		try{
			Co_MemBean co_member=new Co_MemBean();
			
			co_member.setCo_id(request.getParameter("co_id"));
			co_member.setCo_passwd(request.getParameter("co_passwd"));
			co_member.setCo_boss(request.getParameter("co_boss"));
			co_member.setCo_category(request.getParameter("co_category"));
			co_member.setCo_com(request.getParameter("co_com"));
			co_member.setCo_email(request.getParameter("co_email"));
			co_member.setCo_job(request.getParameter("co_job"));
			co_member.setCo_name(request.getParameter("co_name"));
			co_member.setCo_number(Integer.parseInt(request.getParameter("co_number")));
			co_member.setCo_phone(request.getParameter("co_phone"));
			co_member.setCo_subjob(request.getParameter("co_subjob"));
			co_member.setCo_tel(request.getParameter("co_tel"));
			 
			int success=session.insert("co_member.add", co_member);
			if(success>0){
				session.commit();
			}else
				session.rollback();
			request.setAttribute("success", success);
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("È®ÀÎ¿ë");
		return "co_inputPro.jsp";
	}

}
