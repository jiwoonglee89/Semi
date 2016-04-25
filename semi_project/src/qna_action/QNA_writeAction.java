package qna_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import DB.QNABean;
import action.CommandAction;
import action.Connection;


public class QNA_writeAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable
		 {
		    	request.setCharacterEncoding("UTF-8");
				Connection con = new Connection();
				SqlSession session = con.connection();
				QNABean QNA_board = new QNABean();
	
				int num = Integer.parseInt(request.getParameter("num"));
				String q_passwd = session.selectOne("QNA_board.list", request.getAttribute("num"));
			
				int success;
				
				
				if(q_passwd.equals(request.getParameter("q_passwd"))){
					
					success = session.insert("QNA_board.add", QNA_board);
				
				}
				
					else{
						success=0;
					}
					
					if(success>0){
						return "QNA_board/QNA_list.jsp";
					}
				
				else{
						return "QNA_board/QNA_content.jsp";
				
			}
			
		 }
}
	

