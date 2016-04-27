package qna_action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import DB.QNABean;
import action.CommandAction;
import action.Connection;

public class QNA_writeFormAction implements CommandAction {//�� �Է� �� ó��

    public String requestPro(HttpServletRequest request,
        HttpServletResponse response)throws Throwable {
       //����۰� �亯���� ����
        int q_num=0,q_refnumber=1; 
        try{ 
          if(request.getParameter("q_num")!=null){
		 q_num=Integer.parseInt(request.getParameter("q_num"));
		 q_refnumber=Integer.parseInt(request.getParameter("q_refnumber"));
		 
	   }
	}catch(Exception e){e.printStackTrace();}
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("num", new Integer(q_num));
		request.setAttribute("q_refnumber", new Integer(q_refnumber));
		

		return "QNA_writeForm.jsp"; //�ش� �並 ������ ������ �ȿ� ������ ã�´�.
	}
}
