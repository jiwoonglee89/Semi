package qna_action;

import java.sql.Timestamp;
import java.util.List;

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
			try{
				QNABean article = new QNABean();
				
				article.setQ_num(Integer.parseInt(request.getParameter("q_num")));
				article.setCo_id(request.getParameter("co_id"));
				article.setP_id(request.getParameter("p_id"));
				article.setContent(request.getParameter("content"));
				article.setQ_passwd(request.getParameter("q_passwd"));
				article.setQ_regdate(new Timestamp(System.currentTimeMillis()));
				article.setQref_number(Integer.parseInt(request.getParameter("qref_number")));
				article.setReadcount(Integer.parseInt(request.getParameter("readcount")));
				article.setQna_title(request.getParameter("qna_title"));
				
				int success=session.insert("QNA_board.add", article);
				if(success>0){
					session.commit();
				}else
					session.rollback();
				request.setAttribute("success", success);
				session.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("È®ÀÎ¿ë");
			return "QNA_writePro.jsp";
		}

	}
//QNA_writePro.jsp
	

