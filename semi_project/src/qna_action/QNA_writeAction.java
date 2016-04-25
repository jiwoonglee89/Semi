package qna_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import DB.QNABean;
import action.CommandAction;
import action.Connection;


public class QNA_writeAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {
	{
			    request.setCharacterEncoding("UTF-8");
				Connection con = new Connection();
				SqlSession session = con.connection();
				
				QNABean QNA_board = new QNABean();
	        
				int q_num =0,Q_ref=1;
				
				try{
					if(request.getParameter("q_num")!=null){
						q_num = Integer.parseInt(request.getParameter("q_num"));
						Q_ref = Integer.parseInt(request.getParameter("Q_ref"));
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				request.setAttribute("q_num", q_num);
				request.setAttribute("Q_ref", Q_ref);
		 
				q_num = Integer.parseInt(request.getParameter("q_num"));
				String q_passwd = session.selectOne("QNA_board.add", request.getAttribute("q_num"));
			
				int success;
				
				
				if(q_passwd.equals(request.getParameter("q_num"))){
					
					success = session.insert("QNA_board.add", QNA_board);
				
				}
				
					else{
						success=0;
					}
					
					if(success>0){
<<<<<<< HEAD
						return "QNA_board/QNA_list.jsp";
=======
						return "/main.jsp";
>>>>>>> branch 'master' of https://github.com/jiwoonglee89/Semi.git
					}
				
				else{
						return "QNA_board/QNA_list.jsp";
				
			}
			
		 }
}
	

