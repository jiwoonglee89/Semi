package qna_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.*;

public class QNA_WriteFormAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		int q_num=0, Q_ref=1;
		try{
			if(request.getParameter("q_num")!=null){
				q_num=Integer.parseInt(request.getParameter("q_num"));
				Q_ref=Integer.parseInt(request.getParameter("q_ref"));
			}
		}catch(Exception e){e.printStackTrace();}
		
		request.setAttribute("q_num", new Integer(q_num));
		request.setAttribute("q_ref", new Integer(Q_ref));
		
		return "QNA_writeForm.jsp";
	}

}
