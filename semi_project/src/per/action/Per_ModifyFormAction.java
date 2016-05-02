package per.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.P_MemBean;
import action.CommandAction;
import action.Connection;

public class Per_ModifyFormAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		Connection con=new Connection();
		SqlSession sqlsession=con.connection();
		HttpSession session=request.getSession();
		String p_id=(String)session.getAttribute("p_id");
		P_MemBean pbean=new P_MemBean();
		pbean=sqlsession.selectOne("per_member.find", p_id);

		request.setAttribute("name", pbean.getP_name());
		request.setAttribute("passwd", pbean.getP_passwd());
		request.setAttribute("name", pbean.getP_name());
		request.setAttribute("gender", pbean.getP_gender());
		request.setAttribute("email", pbean.getP_email());
		request.setAttribute("birth", pbean.getP_birth());
		request.setAttribute("tel", pbean.getP_tel());
		request.setAttribute("jumin1", pbean.getJumin1());
		request.setAttribute("jumin2", pbean.getJumin2());
		request.setAttribute("career", pbean.getP_career());
		request.setAttribute("award", pbean.getP_award());
		request.setAttribute("zipcode", pbean.getP_zipcode());
		request.setAttribute("address", pbean.getP_address());
		request.setAttribute("category", pbean.getP_category());
		

		session.setAttribute("p_id", p_id);
		

		return "p_modifyForm.jsp";
	}

}
