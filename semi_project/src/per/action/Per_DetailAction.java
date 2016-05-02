package per.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.FileBean;
import DB.P_MemBean;
import action.CommandAction;

public class Per_DetailAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		Connection con = new Connection();
		SqlSession session = con.connection();

		
		HttpSession session2 = request.getSession();
		String p_id = (String) session2.getAttribute("p_id");
		
		List fileList = session.selectList("file.all",p_id);
		
		P_MemBean pbean = session.selectOne("per_member.find",p_id);
		
		
		request.setAttribute("pbean", pbean);
		request.setAttribute("fileList", fileList);
		
		return "p_detail.jsp";
	}
}
