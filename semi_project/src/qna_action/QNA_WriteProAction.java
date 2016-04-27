package qna_action;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import action.CommandAction;

public class QNA_WriteProAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		Connection con=new Connection();
		SqlSession sqlsession=con.connection();
		HttpSession httpsession=request.getSession();
		
		DB.QNABean article=new DB.QNABean();
		article.setCo_id((String)httpsession.getAttribute("co_id"));
		article.setContext(request.getParameter("context"));
		article.setQ_passwd(request.getParameter("q_passwd"));
		article.setQ_regdate(new Timestamp(System.currentTimeMillis()));
		article.setQna_title(request.getParameter("qna_title"));
		article.setQref_number(new Integer(0));
		article.setReadcount(new Integer(0));
		
		int success=sqlsession.insert("QNA_board.add", article);
		
		if(success>0)
			sqlsession.commit();
		else
			System.out.println("QNA 게시판 추가에 실패하였습니다.");
		
		request.setAttribute("articleList", article);
		return "QNA_writePro.jsp";
	}

}
