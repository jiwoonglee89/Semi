package qna_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.QNABean;

import action.*;
import sql.*;


public class QNA_ContentAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		Connection con = new Connection();
		SqlSession session = con.connection();
		HttpSession httpsession=request.getSession();
			
		int q_num = Integer.parseInt(request.getParameter("q_num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		int up_count=session.update("QNA_board.countup", new Integer(q_num));
		if(up_count>0){
			session.commit();
		}
		else
			session.rollback();
		QNABean article = session.selectOne("QNA_board.get", q_num);
		request.setAttribute("q_num", new Integer(q_num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
			
		
		return "QNA_content.jsp";
	}
}  