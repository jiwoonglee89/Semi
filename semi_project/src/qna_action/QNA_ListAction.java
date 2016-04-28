package qna_action;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.QNABean;
import action.*;

public class QNA_ListAction implements CommandAction{//글목록 처리

    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {
    	Connection con=new Connection();
    	SqlSession session=con.connection();
    	HttpSession httpsession=request.getSession();
        String pageNum = request.getParameter("pageNum");//페이지 번호
        
        String search=request.getParameter("search");
        String search_context=request.getParameter("search_context");
                
        if (pageNum == null) {
            pageNum = "1";
        }
        int pageSize = 10;//한 페이지의 글의 개수
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;//한 페이지의 시작글 번호
        int endRow = currentPage * pageSize;//한 페이지의 마지막 글번호
        int count = 0;
        int number=0;
        
        Map map=new HashMap();
        map.put("start", startRow);
        map.put("end", endRow);
        map.put("search", search);
        map.put("search_context", search_context);
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
        	
        	articleList=session.selectList("QNA_board.searchContext", map);
        	System.out.println(search);
        	System.out.println(search_context);
        	System.out.println(articleList.size());
        	count=articleList.size();
        	
        	request.setAttribute("search", search);
            request.setAttribute("search_context", search_context);
        }
        number=count-(currentPage-1)*pageSize;//글목록에 표시할 글번호
        
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
        request.setAttribute("number", new Integer(number));
        request.setAttribute("articleList", articleList);
       
        return "QNA_list.jsp";//해당 뷰
    }
}