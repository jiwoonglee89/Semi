package qna_action;

import java.util.List;

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
				
				
				List W_boardList = null;
			
				QNABean W_board = new QNABean();
				
				W_boardList = session.selectList("QNA_board.get", W_board);
				request.setAttribute("W_boardList", W_boardList);
				
				
				
				int	success = session.insert("QNA_board.add", W_boardList);
				 
					if(success>0){

						return "QNA_writePro.jsp";
					}
				
				else{
						return "QNA_writeForm.jsp";
				
			}
			
		 }
}
//QNA_writePro.jsp
	

