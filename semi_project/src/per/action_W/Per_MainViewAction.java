package per.action_W;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

<<<<<<< HEAD
import DB.FileBean;
=======
import DB.P_MemBean;
>>>>>>> branch 'master' of https://github.com/jiwoonglee89/Semi
import action.CommandAction;
import action.Connection;

public class Per_MainViewAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
<<<<<<< HEAD

		Connection con = new Connection();
		SqlSession session = con.connection();

		String search= null;
		
		String searchn = request.getParameter("searchn");

		FileBean fBean = new FileBean();

		if (searchn != null) {
			search = request.getParameter("search");
			if (search.equals("0")) {
				
				search  = "f_category";
				
			
				
			}else if(search.equals("1")){
				search  = "f_title";
				
	
				
			}else if(search.equals("2")){
				search  = "f_description";
				
			}
		}

		fBean = session.selectOne("member.search",searchn);
		
		
		request.setAttribute("dataList",fBean);
		request.setAttribute("realpath", fBean.getRealpath());
		request.setAttribute("f_title", fBean.getF_title());
		
		request.setAttribute("f_description", fBean.getF_description());
		request.setAttribute("f_regdate", fBean.getF_regdate());
		
		
		//request.setAttribute("search", search);
		
		
		return "/person/p_mainview.jsp";
=======
		// TODO Auto-generated method stub
		
		Connection con=new Connection();
		SqlSession session=con.connection();
		
		
		HttpSession session2 = request.getSession();
		String p_id = (String) session2.getAttribute("p_id");
		
		P_MemBean pbean = session.selectOne("per_member.find",p_id);
			
		request.setAttribute("p_name",pbean.getP_name());
				
		return "p_mainview.jsp";
>>>>>>> branch 'master' of https://github.com/jiwoonglee89/Semi
	}

}
