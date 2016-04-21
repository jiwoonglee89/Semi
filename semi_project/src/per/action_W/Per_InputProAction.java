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
		Connection con=new Connection();
		SqlSession session = con.connection();
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			
			String id = request.getParameter("p_id");
			String passwd = request.getParameter("p_passwd");
			String name = request.getParameter("p_name");
			String gender = request.getParameter("p_gender");
			String email = request.getParameter("p_email");
			int birth = Integer.parseInt(request.getParameter("p_birth"));
			String tel = request.getParameter("p_tel");
			String jumin1 = request.getParameter("jumin1");
			String jumin2 = request.getParameter("jumin2");
			String career = request.getParameter("p_career");
			String award = request.getParameter("p_award");
			String zipcode = request.getParameter("zipcode");
			String address = request.getParameter("p_address");
			String p_category = request.getParameter("p_category");
			
			System.out.println(id +"\n"+passwd +"\n"+name
					+"\n"+gender +"\n"+email +"\n"+birth
					+"\n"+tel+"\n"+jumin1+"\n"+jumin2+"\n"+career+"\n"+award
					+"\n"+zipcode+"\n"+address+"\n"+p_category);
			
			if (p_category != null) {
				if (p_category.equals("0")) {
					p_category = "sanup";
				}else if (p_category.equals("1")) {
					p_category = "web";
				}else if (p_category.equals("2")) {
					p_category = "guncuck";
				}
			}
			
			
			

			P_MemBean p_bean = new P_MemBean(id, passwd, name, gender, email, birth, tel, jumin1, jumin2, career, award, zipcode, address, p_category,0);
			
			int success = session.insert("per_member.add", p_bean);
		
			if (success >0) {
				session.commit();
				
			}else {
				session.rollback();
			}
			
			System.out.println(success);
			
			request.setAttribute("success", new Integer(success));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return "/person/p_inputPro.jsp";
	}
 
}