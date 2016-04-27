package file.action;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import DB.FileBean;
import action.*;

public class fileSearchAction implements CommandAction{//글목록 처리

    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {
    	
    	Connection con=new Connection();
    	SqlSession session=con.connection();
       
        String search=null;
        String search_content=null;
       
        int count = 0;
        int number=0;
        
        Map map=new HashMap();
       
        map.put("search", search);
        map.put("search_content", search_content);
        List articleList = null;
        List forcount=null;
        
        if(count>0){
        	forcount=session.selectList("co_board.all_file");
        	count = forcount.size();
        }
        if (count > 0) {
            articleList = session.selectList("co_board.getFileInfo", map);
        } else {
            articleList = Collections.EMPTY_LIST;
        }     
        if(request.getParameter("search")!=null){
        	search=request.getParameter("search");
        	search_content=request.getParameter("search_content");
        	count=session.selectOne("co_board.searchCount", map);
        	articleList=session.selectList("co_board.searchContent", map);
        	request.setAttribute("search", new String(search));
            request.setAttribute("search_content", new String(search_content));
        }
       
        
        
        request.setAttribute("count", new Integer(count));
        request.setAttribute("number", new Integer(number));
        request.setAttribute("articleList", articleList);
       
        return "co_main.jsp";//해당 뷰
    }
}