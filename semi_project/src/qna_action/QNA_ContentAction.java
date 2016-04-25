package qna_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import DB.QNABean;

import action.*;
import sql.*;


public class QNA_ContentAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		
		request.setCharacterEncoding("UTF-8");
		Connection con = new Connection();
		SqlSession session = con.connection();
		
		QNABean QNA_board = new QNABean();
		
			
			int success;
			
			String id = session.selectOne("QNA_board.list", request.getAttribute("num"));
		
			
			
			
			if(id.equals(request.getAttribute("id"))){
				success=session.selectOne("QNA_board.get", request.getAttribute("num"));
			
			}
			
				else{
					success=0;
				}
				
				if(success>0){
					return "QNA_board/main.jsp";
				}
			
			else{
					return "QNA_board/QNA_content.jsp";
			
		}
	

	
}
}
	





