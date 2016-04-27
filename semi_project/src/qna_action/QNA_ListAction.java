package qna_action;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import DB.QNABean;
import action.*;

public class QNA_ListAction implements CommandAction{//�۸�� ó��

    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {
    	Connection con=new Connection();
    	SqlSession session=con.connection();
        String pageNum = request.getParameter("pageNum");//������ ��ȣ
        String search=null;
        String search_content=null;
       
        
        if (pageNum == null) {
            pageNum = "1";
        }
        int pageSize = 10;//�� �������� ���� ����
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;//�� �������� ���۱� ��ȣ
        int endRow = currentPage * pageSize;//�� �������� ������ �۹�ȣ
        int count = 0;
        int number=0;
        
        Map map=new HashMap();
        map.put("start", startRow);
        map.put("end", endRow);
        map.put("search", search);
        map.put("search_content", search_content);
        List articleList = null;
        List forcount=null;
        
        if(count>=0){
        	forcount=session.selectList("QNA_board.all");
        	count = forcount.size();
        }
        if (count > 0) {
            articleList = session.selectList("QNA_board.getA", map);
        } else {
            articleList = Collections.EMPTY_LIST;
        }     
        if(request.getParameter("search")!=null){
        	search=request.getParameter("search");
        	search_content=request.getParameter("search_content");
        	count=session.selectOne("QNA_board.searchCount", map);
        	articleList=session.selectList("QNA_board.searchContent", map);
        	request.setAttribute("search", new String(search));
            request.setAttribute("search_content", new String(search_content));
        }
        number=count-(currentPage-1)*pageSize;//�۸�Ͽ� ǥ���� �۹�ȣ
        
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
        request.setAttribute("number", new Integer(number));
        request.setAttribute("articleList", articleList);
       
        return "QNA_list.jsp";//�ش� ��
    }
}