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
	QNABean QNA_board = new QNABean();

	int q_num = Integer.parseInt(request.getParameter("q_num"));
	String pageNum = request.getParameter("pageNum");
	
	
	QNA_board= session.selectOne("QNA_board.get", q_num);
	String q_passwd=session.selectOne("QNA_board.find_passwd", q_num);
	
	int success;
	if(q_passwd.equals(request.getParameter("q_passwd"))){
		success=session.update("QNA_board.modify", request.getParameter("q_num"));
	}else{
			success=0;
		}
		if(success>0){
			return "QNA_board/QNA_list.jsp";
		}else
			return "QNA_board/QNA_updateForm.jsp";
	}
}