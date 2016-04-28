package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import DB.Co_boardBean;

public class Co_mainAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		Connection con=new Connection();
		SqlSession session=con.connection();
		List people=session.selectList("co_board.all_per");
		List file=session.selectList("co_board.all_file");
		System.out.println(file.size());
		String search=null;
		
		if(request.getParameter("category")!=null){
			String category=request.getParameter("category");
			file =session.selectList("co_board.getCategory", category);
		}
		if(request.getParameter("order")!=null){
		
			
			if(request.getParameter("order").equals("0")){
				
				file = session.selectList("co_board.getDateOrder");
			}
			else 
				file= session.selectList("co_board.getReadOrder");
		}
		
		if(request.getParameter("option")!=null){
			search=request.getParameter("search");
			if(request.getParameter("option").equals("0")){
				file = session.selectList("co_board.getTitle", search);
		}
		else 
			file =session.selectList("co_board.getDescription", search);
	}
		request.setAttribute("people", people);
		request.setAttribute("file", file);
		return "co_main.jsp";
	}

}
