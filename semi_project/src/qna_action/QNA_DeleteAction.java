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

		QNABean QNA_board = new QNABean();
			
			int q_num = Integer.parseInt(request.getParameter("q_num"));
			String PageNum = request.getParameter("PageNum");
			String q_passwd = request.getParameter("q_passwd");
			
			
			QNA_board= session.selectOne("QNA_board.get", q_num);
			
			
			int success;
			
			if(q_passwd.equals(request.getAttribute("q_passwd"))){
				success=session.delete("QNA_board.remove", q_num);
			}else{
				success=0;
			}
			if(success>0){
				return "QNA_board/QNA_list.jsp";
			}else
				return "QNA_board/QNA_deleteForm.jsp";
		
           
		}
	}



