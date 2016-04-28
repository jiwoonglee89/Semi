package per.action_W;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.P_MemBean;
import action.CommandAction;

public class Per_InputProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		Connection con=new Connection();
		SqlSession session = con.connection();
		int success = 0;
		
		String p_id = null;
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			
			p_id = request.getParameter("p_id");
			String p_passwd = request.getParameter("p_passwd");
			String p_name = request.getParameter("p_name");
			String p_gender = request.getParameter("p_gender");
			String p_email = request.getParameter("p_email");
			int p_birth = Integer.parseInt(request.getParameter("p_birth"));
			String p_tel = request.getParameter("p_tel");
			String jumin1 = request.getParameter("jumin1");
			String jumin2 = request.getParameter("jumin2");
			String p_career = request.getParameter("p_career");
			String p_award = request.getParameter("p_award");
			String p_zipcode = request.getParameter("p_zipcode");
			String p_address = request.getParameter("p_address");
			String p_category = request.getParameter("p_category");
			
			if (p_category != null) {
				if (p_category.equals("0")) {
					p_category = "sanup";
				}else if (p_category.equals("1")) {
					p_category = "web";
				}else if (p_category.equals("2")) {
					p_category = "guncuck";
				}
			}

			P_MemBean p_bean = new P_MemBean(p_id, p_passwd, p_name, p_gender, jumin1, jumin2, p_email, p_birth, p_tel,  p_career, p_award, p_zipcode, p_address, p_category,0);
			
			success = session.insert("per_member.add", p_bean);
		
			if (success >0) {
				session.commit();
				
			}else {
				session.rollback();
			}
			
			System.out.println(success);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		request.setAttribute("success", new Integer(success));
		HttpSession session2 = request.getSession();
		session2.setAttribute("memId", p_id);
		
		return "p_inputPro.jsp";
	}
 
}