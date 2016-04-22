package qna_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import DB.QNABean;
import action.CommandAction;
import action.Connection;
import sql.*;

public class QNA_DeleteAction implements CommandAction {//�ۻ��� ��

    public String requestPro(HttpServletRequest request, HttpServletResponse response) 
    		throws Throwable 
    {
    	request.setCharacterEncoding("UTF-8");
		Connection con = new Connection();
		SqlSession session = con.connection();

		
			int success;
			QNABean QNA_board = new QNABean();
			QNA_board.setQ_passwd(request.getParameter("q_passwd"));
			String q_passwd=session.selectOne("QNA_board.find_passwd", request.getAttribute("num"));
			
			if(q_passwd.equals(request.getParameter("q_passwd"))){
				success=session.delete("QNA_board.remove", request.getParameter("num"));
			}else{
				success=0;
			}
			if(success>0){
				return "QNA_board/QNA_list.jsp";
			}else
				return "QNA_board/QNA_deleteForm.jsp";
		
           
		}
	}



