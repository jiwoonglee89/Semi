package per.action_W;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import DB.P_MemBean;
import action.CommandAction;

public class Per_InputProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String res = "config.xml";
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			Connection con=new Connection();
			SqlSession session = con.connection();
			
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			String name = request.getParameter("name");
			int gender1 = Integer.parseInt(request.getParameter("gender1"));
			int gender2 = Integer.parseInt(request.getParameter("gender2"));
			String email = request.getParameter("email");
			int birth = Integer.parseInt(request.getParameter("birth"));
			String phone = request.getParameter("phone");
			String tel = request.getParameter("tel");
			String jumin1 = request.getParameter("jumin1");
			String jumin2 = request.getParameter("jumin2");
			String career = request.getParameter("career");
			String award = request.getParameter("award");
			String zipcode = request.getParameter("zipcode");
			String address = request.getParameter("address");
			String category = request.getParameter("category");
			

			P_MemBean p_bean = new P_MemBean(id, passwd, name, gender1, email,birth, phone, tel, jumin1, jumin2, career, award, zipcode, address, category,0);
			
			int success = session.insert("per_member.add", p_bean);
		
			if (success >0) {
				session.commit();
			}else {
				session.rollback();
			}
			
			request.setAttribute("success", success);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return "/person/p_inputPro.jsp";
	}
 
}