package qna_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import DB.QNABean;
import action.CommandAction;
import action.Connection;
import sql.*;

public class QNA_DeleteAction implements CommandAction {//±Û»èÁ¦ Æû

    public String requestPro(HttpServletRequest request, HttpServletResponse response) 
    		throws Throwable 
    {
    	request.setCharacterEncoding("UTF-8");
		Connection con = new Connection();
		SqlSession session = con.connection();

		QNABean article = new QNABean();
			
			int q_num = Integer.parseInt(request.getParameter("q_num"));
			String pageNum = request.getParameter("pageNum"); 
			
			request.setAttribute("q_num", new Integer(q_num));
			request.setAttribute("pageNum", new Integer(pageNum));
				   
			String q_passwd = session.selectOne("QNA_board.find_passwd", new Integer(q_num));
		    
		    int success;
			
		    
			if(q_passwd.equals(request.getParameter("q_passwd"))){
				success=session.delete("QNA_board.remove", new Integer(q_num));
			}else{
				success=0;
			}
			request.setAttribute("check", success);
			
			if(success>0){
				session.commit();
				return "QNA_deletePro.jsp";
			}else
				return "QNA_deleteForm.jsp";
		
           
		}
	}



