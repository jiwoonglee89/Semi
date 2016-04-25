package qna_action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import action.*;
import DB.QNABean;

public class QNA_listAtion implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con=new Connection();
		SqlSession session=con.connection();
		
		QNABean QNA_board = new QNABean();
		
		String pageNum = request.getParameter("pageNum") ;
		String search = request.getParameter("search");
		 //수정 미완
		int searchn = 0;
		
		if(pageNum == null) { pageNum = "1"; }

	    if(search == null)
		{
			search = "";
		}
		else
		{
			searchn = Integer.parseInt(request.getParameter("searchn"));
		}
		
		int pageSize = 10 ;
		int currentPage = Integer.parseInt(pageNum) ;
		int startRow = (currentPage - 1) * pageSize + 1 ;
		int endRow = currentPage * pageSize; ;
		int count = 0 ;
		int number = 0 ;
		
		List articleList = null ;
	
		if(search.equals("") || search == null)
			count = session.selectOne("QNA_board.getArticle");
		else{
			if(searchn==0)
				count = session.selectOne("QNA_board.writer_article");
			else if(searchn==1)
				count=session.selectOne("QNA_board.subject_article");
			else if(searchn==2)
				count=session.selectOne("QNA_board.content_article");
		}
		if(count > 0)
		{
		  if(search.equals("") || search == null)
			
			articleList = session.selectOne("Board.getArticle",request.getAttribute("num"));
		  else
				articleList = session.selectOne("Board.getArticle", request.getAttribute("searchn"));
		  
			System.out.println("articleList.size():::"+articleList.size());
		}
		else
		{
			articleList = Collections.EMPTY_LIST ;
		}
		
		number = count - (currentPage - 1 ) * pageSize ;
		
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
        request.setAttribute("number", new Integer(number));
        request.setAttribute("articleList", articleList);
       
        return "/mvc_board/list.jsp";//해당 뷰
	}

}
