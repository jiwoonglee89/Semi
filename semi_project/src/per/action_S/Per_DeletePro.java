package per.action_S;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import DB.P_MemBean;
import action.CommandAction;
import action.Connection;

public class Per_DeletePro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con = new Connection();
		SqlSession session = con.connection();

		try{
		P_MemBean p_bean = new P_MemBean();

		String p_id = p_bean.getP_id();
		String passwd1 = p_bean.getP_passwd();
		String p_name = p_bean.getP_name();
		String jumin1 = p_bean.getJumin1();
		String jumin2 = p_bean.getJumin2();
		String p_gender = p_bean.getP_gender();
		String p_tel = p_bean.getP_tel();
		String p_email = p_bean.getP_email();
		int p_birth = p_bean.getP_birth();
		String p_zipcode = p_bean.getP_zipcode();
		String p_address = p_bean.getP_address();
		String p_category = p_bean.getP_category();
		String p_carrer = p_bean.getP_career();
		String p_award = p_bean.getP_award();

		String passwd2 = request.getParameter("p_passwd");

		if (passwd1.equals(passwd2)) {
			session.delete("p_id", p_id);
			session.delete("p_passwd", passwd1);
			session.delete("p_name", p_name);
			session.delete("jumin1", jumin1);
			session.delete("jumin2", jumin2);
			session.delete("p_gender", p_gender);
			session.delete("p_tel", p_tel);
			session.delete("p_email", p_email);
			session.delete("p_birth", p_birth);
			session.delete("p_zipcode", p_zipcode);
			session.delete("p_address", p_address);
			session.delete("p_category", p_category);
			session.delete("p_career", p_carrer);
			session.delete("p_award", p_award);

			session.commit();
		} else {
			session.rollback();
		}

		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
