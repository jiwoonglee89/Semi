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
		
		
		 
			int success;
			int q_num = Integer.parseInt(request.getParameter("q_num"));
			String pageNum = request.getParameter("pageNum");
			
			QNABean article = session.selectOne("QNA_board.get", q_num);
			
			request.setAttribute("q_num", new Integer(q_num));
			request.setAttribute("pageNum", new Integer(pageNum));
			request.setAttribute("article", article);
			
			
		     String co_id = request.getParameter("co_id");
		     String p_id = request.getParameter("p_id");
			
			
			
			if(co_id.equals(request.getParameter("co_id"))){
				success = session.selectOne("QNA_board.get", q_num);
			}
			if(p_id.equals(request.getParameter("p_id"))){
				success = session.selectOne("QNA_board.get", q_num);
			}
			
				else{
					success=0;
				}
				
				if(success>0){
					return "QNA_content.jsp";
				}
			
			else{
					return "QNA_list.jsp";
			
		}
	}
}  //QNA_content.jsp






