package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import DB.Co_MemBean;
import sql.*;



public class ModifyProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		HttpSession httpsession=request.getSession();
		String co_id=(String)httpsession.getAttribute("co_id");
		Connection con=new Connection();
		SqlSession session=con.connection();
		Co_MemBean co_member=new Co_MemBean();
		co_member=session.selectOne("co_member.get", co_id);
		
		co_member.setCo_passwd(request.getParameter("co_passwd"));
		co_member.setCo_number(Integer.parseInt(request.getParameter("co_number")));
		co_member.setCo_com(request.getParameter("co_com"));
		co_member.setCo_boss(request.getParameter("co_boss"));
		co_member.setCo_tel(request.getParameter("co_tel"));
		co_member.setCo_category(request.getParameter("co_category"));
		co_member.setCo_subjob(request.getParameter("co_subjob"));
		co_member.setCo_job(request.getParameter("co_job"));
		co_member.setCo_name(request.getParameter("co_name"));
		co_member.setCo_email(request.getParameter("co_email"));
		co_member.setCo_phone(request.getParameter("co_phone"));
		
		int success=session.update("co_member.modify", co_member);
		if(success>0){
			session.commit();
			request.setAttribute("co", co_member);
		}else
			System.out.println("수정이 수행되지 않았습니다.");
		return "co_modifyPro.jsp";
	}
}
