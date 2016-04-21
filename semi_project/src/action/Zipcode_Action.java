package action;

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
		
		try{
			ZipcodeBean =new ZipcodeBean();
			
			ZipcodeBean.setZipcode(request.getParameter("zipcode"));
			ZipcodeBean.setArea1(request.getParameter("area1"));
			ZipcodeBean.setArea2(request.getParameter("area2"));
			ZipcodeBean.setArea3(request.getParameter("area3")); 
			ZipcodeBean.setArea4(request.getParameter("area4"));
			
			 
			int success = session.insert("Zipcode.add", ZipcodeBean);
			if(success>0){
				session.commit();
			}else
				session.rollback();
			request.setAttribute("success", success);
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("È®ÀÎ¿ë");
		return "Zipcheck.jsp";
	}

}
