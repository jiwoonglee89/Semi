package qna_action;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import DB.Co_MemBean;
import DB.QNABean;
import action.CommandAction;
import action.Connection;

public class QNA_updateFormAction {
	 
	public String requestPro(HttpServletRequest request,
	        HttpServletResponse response) throws Throwable {
		  
		    request.setCharacterEncoding("UTF-8");
			Connection con = new Connection();
			SqlSession session = con.connection();
	        QNABean article = new QNABean();
			int q_num = Integer.parseInt(request.getParameter("q_num"));
	        String pageNum = request.getParameter("pageNum");

	        
			
			//System.out.println(session.getAttribute("co_id"));
			article=session.selectOne("QNA_board.find", q_num);
			
			//해당 뷰에서 사용할 속성
	        request.setAttribute("pageNum", new Integer(pageNum));
	        request.setAttribute("article", article);

	        return "/MVC/updateForm.jsp"; //해당 뷰를 보려면 폴더명안에 파일을 찾는다.
	    }
	}
