package qna_action;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import DB.Co_MemBean;
import DB.QNABean;
import action.CommandAction;
import action.Connection;


public class QNA_updateFormAction implements CommandAction {
	 
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		Connection con=new Connection();
		SqlSession session=con.connection();
		int q_num=Integer.parseInt(request.getParameter("q_num"));
		String pageNum=request.getParameter("pageNum");
		
		
		DB.QNABean article=new DB.QNABean();
		article=session.selectOne("QNA_board.get", new Integer(q_num));
		
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
			
		return "QNA_updateForm.jsp";
		}
}
