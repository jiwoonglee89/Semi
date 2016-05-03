package qna_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.*;

public class QNA_WriteFormAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		int q_num=0, qref_number=1;
		try{
			if(request.getParameter("q_num")!=null){
				q_num=Integer.parseInt(request.getParameter("q_num"));
				qref_number=Integer.parseInt(request.getParameter("qref_number"));
			}
		}catch(Exception e){e.printStackTrace();}
		
		request.setAttribute("q_num", new Integer(q_num));
		request.setAttribute("qref_number", new Integer(qref_number));
		
		return "QNA_writeForm.jsp";
	}

}
