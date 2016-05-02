package per.action_W;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.FileBean;
import action.CommandAction;

public class Per_DetailAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		Connection con = new Connection();
		SqlSession session = con.connection();
		List fileList = null;
		
		HttpSession session2 = request.getSession();
		String p_id = (String) session2.getAttribute("p_id");
		
		fileList = session.selectList("file.all",p_id);
		
		//String fileName = request.getParameter("f_filename");
		
		//FileBean fbean = session.selectOne("file.info",fileName);
		
		//FileBean fbean = session.selectOne("file.f_filename",)
		
		//FileBean fbean = (FileBean) session.selectList("file.all",p_id);
		
		
		
		request.setAttribute("fileList", fileList);
		//request.setAttribute("fbean", fbean);
		return "p_detail.jsp";
	}

}
