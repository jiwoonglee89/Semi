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

public class fileCategoryAction implements CommandAction{ //목록 처리

    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {
    	
    	Connection con=new Connection();
    	SqlSession session=con.connection();
    	String pageNum = request.getParameter("pageNum");
        String category=null;
          
        
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
        map.put("category", category);
        
        
        List FileList = null;
        List forcount=null;
        
       
        
        if(count>=0){
        	forcount=session.selectList("co_board.all_file");
        	count = forcount.size();
        }
        if (count > 0) {
            FileList = session.selectList("co_board.getFileInfo", map);
        } else {
            FileList = Collections.EMPTY_LIST;
        }     
        if(request.getParameter("category")!=null){
        	category=request.getParameter("category");
        	count=session.selectOne("co_board.categoryCount", map);
        	FileList=session.selectList("co_board.categoryList", map);
        	request.setAttribute("category", new String(category));
            
        }
        
        if(category.equals("0")){
        	category=request.getParameter("category");
        	count=session.selectOne("co_board.sanup_categoryCount", map);
        	FileList=session.selectList("co_board.sanup_categoryList", map);
        	request.setAttribute("category", new String(category));
        }
        if(category.equals("1")){
        	category=request.getParameter("category");
        	count=session.selectOne("co_board.web_categoryCount", map);
        	FileList=session.selectList("co_board.web_categoryList", map);
        	request.setAttribute("category", new String(category));
        }
        
        if(category.equals("2")){
        	category=request.getParameter("category");
        	count=session.selectOne("co_board.sigak_categoryCount", map);
        	FileList=session.selectList("co_board.sigak_categoryList", map);
        	request.setAttribute("category", new String(category));
        }
       // 각 카테코리 당 출력되는 파일수랑 형태랑 다르게 하기 위함
        
        number=count-(currentPage-1)*pageSize;//글목록에 표시할 글번호
        
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
        request.setAttribute("number", new Integer(number));
        request.setAttribute("FileList", FileList);
       
        return "co_main.jsp";//해당 뷰
    }
}