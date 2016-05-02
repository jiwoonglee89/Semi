package per.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.P_MemBean;
import action.CommandAction;
import per.action.Connection;

public class Per_ModifyProAction implements CommandAction {

	String res = "config.xml";

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		Connection con = new Connection();
		SqlSession session = con.connection();
		HttpSession session2 = request.getSession();
		try {

			String p_id = (String) session2.getAttribute("p_id");

			
			P_MemBean pbean = session.selectOne("per_member.find",p_id);
			
			String passwd = request.getParameter("p_passwd");
			String name = request.getParameter("p_name");
			String gender = request.getParameter("p_gender");
			String email = request.getParameter("p_email");
			int birth = Integer.parseInt(request.getParameter("P_birth"));
			String tel = request.getParameter("p_tel");
			String jumin1 = request.getParameter("jumin1");
			String jumin2 = request.getParameter("jumin2");
			String career = request.getParameter("p_career");
			String award = request.getParameter("p_award");
			String zipcode = request.getParameter("p_zipcode");
			String address = request.getParameter("p_address");
			String category = request.getParameter("p_category");
			
			P_MemBean check = new P_MemBean(passwd, name, gender, jumin1, jumin2, email, birth, tel, career, award,
					zipcode, address, category, 0);

			int success = session.update("per_member.modify", p_id);

			if (success > 0) {
				session.commit();
			} else {
				session.rollback();
			}
			
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
			
			request.setAttribute("success", success);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/login/p_mainview.jsp";
	}

}
