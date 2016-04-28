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
		request.setAttribute("people", people);
		request.setAttribute("file", file);
		System.out.println(request.getParameter("category"));
		return "co_main.jsp";
	}

}
