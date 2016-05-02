package per.action_W;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import sql.*;
import DB.Co_MemBean;
import DB.FileBean;
import action.CommandAction;
import action.Connection;

public class Per_FileModifyFormAction implements CommandAction{
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	request.setCharacterEncoding("UTF-8");
		
		Connection con=new Connection();
		SqlSession sqlsession=con.connection();
		
		String f_filename=request.getParameter("f_filename");
		FileBean file= new FileBean();
		f_filename = sqlsession.selectOne("file.info", request.getParameter("f_filename"));

		
		request.setAttribute("f_file", file);
		request.setAttribute("f_filename", f_filename);
		
		return "p_filemodifyForm.jsp";
	}

} 

	

	