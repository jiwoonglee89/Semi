package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import DB.QNABean;
import sql.*;

public class QNA_DeleteFormAction implements CommandAction {//글삭제 폼

    public String requestPro(HttpServletRequest request, HttpServletResponse response) 
    		throws Throwable 
    {
    	request.setCharacterEncoding("UTF-8");
		Connection con = new Connection();
		SqlSession session = con.connection();
		
		try{
			QNABean QNA_board = new QNABean();
			
			QNA_board.setQ_passwd(request.getParameter("q_passwd"));
			
			
			int success = session.delete("QNA_board.remove", QNA_board);
			
			if(success>0){
				session.commit();
			}else
				session.rollback();
			request.setAttribute("success", success);
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("확인용");
		return "co_inputPro.jsp"; // 다시 
		
	}

}

