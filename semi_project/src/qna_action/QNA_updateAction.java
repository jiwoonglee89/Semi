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

public class QNA_updateAction implements CommandAction {
	
	
 public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {
	
	request.setCharacterEncoding("UTF-8");
	Connection con = new Connection();
	SqlSession session = con.connection();
	QNABean article = new QNABean();

	String pageNum = request.getParameter("pageNum");
	String q_passwd = request.getParameter("q_passwd");
	
	
	article.setQ_num(Integer.parseInt(request.getParameter("q_num")));
    article.setCo_id(request.getParameter("co_id"));
    article.setQna_title(request.getParameter("qna_title"));
    article.setContext(request.getParameter("context"));
    article.setQ_passwd(request.getParameter("q_passwd"));
    
  
  if(q_passwd.equals(request.getParameter("q_passwd"))){
	   int Update = session.update("QNA_board.find",request.getParameter("q_num"));
  }
	
	int check = session.update("QNA_board.modify", article);
	
	
	request.setAttribute("check", new Integer(check));
	request.setAttribute("pageNum", new Integer(pageNum));
	request.setAttribute("article", article);
	int success;
	
	
	if(q_passwd.equals(request.getParameter("q_passwd"))){
		success = session.update("QNA_board.modify", request.getParameter("q_num"));
	} else{
			success=0;
		}
		if(success>0){
			return "QNA_updatePro.jsp";
		}else
			return "QNA_updateForm.jsp";
	}
}

//QNA_updatePro.jsp