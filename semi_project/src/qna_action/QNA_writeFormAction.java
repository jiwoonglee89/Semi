package qna_action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import DB.QNABean;
import action.CommandAction;
import action.Connection;

public class QNA_writeFormAction implements CommandAction {//글 입력 폼 처리

    public String requestPro(HttpServletRequest request,
        HttpServletResponse response)throws Throwable {
       //제목글과 답변글의 구분
        int q_num=0,q_refnumber=1; 
        try{ 
          if(request.getParameter("q_num")!=null){
		 q_num=Integer.parseInt(request.getParameter("q_num"));
		 q_refnumber=Integer.parseInt(request.getParameter("q_refnumber"));
		 
	   }
	}catch(Exception e){e.printStackTrace();}
		//해당 뷰에서 사용할 속성
		request.setAttribute("num", new Integer(q_num));
		request.setAttribute("q_refnumber", new Integer(q_refnumber));
		

		return "QNA_writeForm.jsp"; //해당 뷰를 보려면 폴더명 안에 파일을 찾는다.
	}
}
