package per.action_W;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import sql.*;
import DB.FileBean;
import action.CommandAction;
import action.Connection;

public class Per_FileModifyProAction implements CommandAction{
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	request.setCharacterEncoding("UTF-8");
	
	Connection con=new Connection();
	SqlSession sqlsession=con.connection();
	
	
	String f_filename = request.getParameter("f_filename");
	
	
	
	FileBean file= new FileBean();
	
	file.setF_title("f_title");
	file.setRealpath("realpath");
	file.setF_description("f_description");
	file.setF_category("f_catrgory");
	
	
	int success=sqlsession.update("file.modify", file);
	
	 if(success>0){
			sqlsession.commit();
			
		}
		else
			System.out.println("수정이 수행되지 않았습니다.");
		
	 	request.setAttribute("f_filename", f_filename);
		
	 	return "p_filemodifyPro.jsp";
	
}
	}