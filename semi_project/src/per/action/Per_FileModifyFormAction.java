package per.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import DB.FileBean;
import action.CommandAction;

public class Per_FileModifyFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		Connection con = new Connection();
		SqlSession session = con.connection();
		
		String f_filename = request.getParameter("f_filename");
		
		FileBean fbean = session.selectOne("file.info",f_filename);
		
		
		request.setAttribute("fbean", fbean);
		
		
		
		return "filemodifyForm.jsp";
	}

}
