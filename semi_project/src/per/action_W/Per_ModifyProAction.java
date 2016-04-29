package per.action_W;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.P_MemBean;
import action.CommandAction;
import per.action_W.Connection;

public class Per_ModifyProAction implements CommandAction {

	String res = "config.xml";

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		Connection con = new Connection();
		SqlSession session = con.connection();
		HttpSession session2 = request.getSession();
		try {

			String memId = (String) session2.getAttribute("memId");

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
			String phone=request.getParameter("p_phone");
			P_MemBean check = new P_MemBean(passwd, name, gender, jumin1, jumin2, email, birth, tel, career, award,
					zipcode, address, category, 0, phone);

			int success = session.update("per_member.modify", memId);

			if (success > 0) {
				session.commit();
			} else {
				session.rollback();
			}

			request.setAttribute("success", success);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/login/p_mainview.jsp";
	}

}
