package action;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import sql.*;

import DB.ZipcodeBean;


public class Zipcode_Action implements CommandAction{

	private ZipcodeBean ZipcodeBean;
	private SqlSession session;

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		Connection con=new Connection();
		session=con.connection();
		
		try{
			String check=request.getParameter("check");
			String area4=request.getParameter("area4");
			List result = session.selectList("zipcode.find", area4);
			int totalList=result.size();
			request.setAttribute("zipcodeList", result);
			request.setAttribute("totalList", totalList);
			request.setAttribute("check", check);
			request.setAttribute("area4", area4);
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "ZipCheck.jsp";
	}

}
