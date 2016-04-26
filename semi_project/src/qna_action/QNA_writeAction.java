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
				
			
	        
				int q_num =0,Q_ref=1;
				
				try{
					if(request.getParameter("q_num")!=null){
						q_num = Integer.parseInt(request.getParameter("q_num"));
						Q_ref = Integer.parseInt(request.getParameter("Q_ref"));
						
						request.setAttribute("q_num", new Integer(q_num));
						request.setAttribute("Q_ref", new Integer(Q_ref));
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				//QNA_writeForm.jsp
				
				QNABean article = session.selectOne("QNA_board.add", request.getParameter("q_num"));
				
				request.setAttribute("article", article);
				
				int success;
				
				success = session.insert("add", article);
				 
					if(success>0){

						return "QNA_writePro.jsp";
					}
				
				else{
						return "QNA_writeForm.jsp";
				
			}
			
		 }
}
//QNA_writePro.jsp
	

