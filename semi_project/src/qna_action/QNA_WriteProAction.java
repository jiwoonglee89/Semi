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
		
		System.out.println(request.getParameter("q_num"));
		System.out.println(request.getParameter("qref_number"));
		
		if(httpsession.getAttribute("co_id")!=null)
			article.setCo_id((String)httpsession.getAttribute("co_id"));
		else if(httpsession.getAttribute("p_id")!=null)
			article.setP_id((String)httpsession.getAttribute("p_id"));
		else if(httpsession.getAttribute("admin_id")!=null)
			article.setAdmin_id((String)httpsession.getAttribute("admin_id"));
		article.setContext(request.getParameter("context"));
		article.setQ_passwd(request.getParameter("q_passwd"));
		article.setQ_regdate(new Timestamp(System.currentTimeMillis()));
		article.setQna_title(request.getParameter("qna_title"));
		article.setQref_number(Integer.parseInt(request.getParameter("qref_number")));
		article.setReadcount(new Integer(0));
		
		if(Integer.parseInt(request.getParameter("qref_number"))>0){
			article.setQ_step(Integer.parseInt(request.getParameter("q_num")));
		}
		
		int success=0;
		if(httpsession.getAttribute("co_id")!=null){
			if(Integer.parseInt(request.getParameter("qref_number"))==0){
				success=sqlsession.insert("QNA_board.add_cor", article);
			}else
				success=sqlsession.insert("QNA_board.add_cor2", article);
		}
		else if(httpsession.getAttribute("p_id")!=null)
			if(Integer.parseInt(request.getParameter("qref_number"))==0){
				success=sqlsession.insert("QNA_board.add_per", article);
			}else
				success=sqlsession.insert("QNA_board.add_per2", article);
		else if(httpsession.getAttribute("admin_id")!=null){
			if(Integer.parseInt(request.getParameter("qref_number"))==0){
				success=sqlsession.insert("QNA_board.add_admin", article);
			}
			else
				success=sqlsession.insert("QNA_board.add_admin2", article);
		}
		if(success>0)
			sqlsession.commit();
		else
			sqlsession.rollback();
		
		
		request.setAttribute("articleList", article);
		return "QNA_writePro.jsp";
	}

}
