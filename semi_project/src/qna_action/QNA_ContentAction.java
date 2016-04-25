package qna_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import DB.QNABean;
import action.CommandAction;
import action.Connection;
import sql.*;


public class QNA_ContentAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {
		
		request.setCharacterEncoding("UTF-8");
		Connection con = new Connection();
		SqlSession session = con.connection();
		
		
			
			int success;
			int num = Integer.parseInt(request.getParameter("num"));
			String q_passwd=session.selectOne("QNA_board.get", request.getAttribute("num"));
			
			//수정 진행중
			
			if(q_passwd.equals(request.getParameter("q_passwd"))){
				success=session.insert("QNA_board.co_add", request.getParameter("num"));
			}else{
					success=0;
				}
				if(success>0){
					return "/main.jsp";
				}else
					return "/QNA_content.jsp";
			
		}
	
}

	


