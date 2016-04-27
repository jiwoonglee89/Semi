package per.action_W;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import DB.FileBean;
import action.CommandAction;
import action.Connection;

public class Per_MainViewAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {


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
	}
		
	

}
