package zipcode;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import action.CommandAction;
import per.action.Connection;

public class Zipcode_DB implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		Connection con = new Connection();
		SqlSession session = con.connection();
	
		ResultSet rs = null;
		Vector vecList = new Vector();
		
		try {
			
			
			ZipcodeBean zipbean = new ZipcodeBean();
			String zipcode = zipbean.getZipcode();
			String area1 = zipbean.getArea1();
			String area2 = zipbean.getArea2();
			String area3 = zipbean.getArea3();
			String area4 = zipbean.getArea4();	
			
			rs = (ResultSet) session.selectList("zipcode",zipbean);
			
			while (rs.next()) {
				zipbean.setZipcode(zipcode);
				zipbean.setArea1(area1);
				zipbean.setArea2(area2);
				zipbean.setArea3(area3);
				zipbean.setArea4(area4);
				vecList.addElement(zipbean);
			}
			request.setAttribute("zipbean", zipbean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ZipcodeBean check = new ZipcodeBean();
		int success = session.update("", check);
		return "";
	}

}
