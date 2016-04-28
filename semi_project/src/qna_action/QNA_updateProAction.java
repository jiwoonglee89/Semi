package qna_action;

import java.util.Collections;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

import DB.QNABean;
import action.*;

public class QNA_updateProAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {
		Connection con=new Connection();
		SqlSession session=con.connection();
		request.setCharacterEncoding("UTF-8");
		int check=0;
		String pageNum=request.getParameter("pageNum");
		
		DB.QNABean article=new DB.QNABean();
		article.setContext(request.getParameter("context"));
		article.setQ_num(Integer.parseInt(request.getParameter("q_num")));
		article.setQna_title(request.getParameter("qna_title"));
		int q_num=Integer.parseInt(request.getParameter("q_num"));
		
		String passwd=session.selectOne("QNA_board.find_passwd", new Integer(q_num));
		if(passwd.equals(request.getParameter("q_passwd"))){
			check=session.update("QNA_board.modify", article);
			session.commit();
		}
		else{
			session.rollback();
			check=0;
		}
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", new Integer(check));
		
		return "QNA_updatePro.jsp";
	}
}
//QNA_updatePro.jsp