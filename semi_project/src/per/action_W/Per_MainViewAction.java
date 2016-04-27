package per.action_W;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.P_MemBean;
import action.CommandAction;
import action.Connection;

public class Per_MainViewAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		Connection con=new Connection();
		SqlSession session=con.connection();
		
		
		List fileList = null;
		
		HttpSession session2 = request.getSession();
		String p_id = (String) session2.getAttribute("p_id");
		
		//P_MemBean pbean = session.selectOne("per_member.find",p_id);
			
		
		fileList = session.selectList("file.all",p_id );
		P_MemBean p_list = session.selectOne("per_member.find",p_id);
		
		request.setAttribute("fileList", fileList);
		request.setAttribute("p_list",p_list);
				
		return "p_mainview.jsp";
	}

}
