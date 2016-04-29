package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import DB.Co_MemBean;

public class ConfirmIdAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
<<<<<<< HEAD
		String co_id = request.getParameter("co_id");
		Connection con = new Connection();
=======
		
		Connection con=new Connection();
>>>>>>> branch 'master' of https://github.com/jiwoonglee89/Semi
		SqlSession session = con.connection();
<<<<<<< HEAD
		String id = session.selectOne("co_member.confirmId", co_id);

		int co_check = 0;

		if (id == co_id) {
			co_check = 1;
		} else{
			co_check = -1;
		}
		request.setAttribute("co_check", co_check);
		request.setAttribute(co_id, id);
=======
		String id = session.selectOne("co_member.confirmId", request.getParameter("co_id"));
		
		
		int check;
		if(id==null){
			check=-1;
		}else
			check=1;
		request.setAttribute("check", new Integer(check));
		request.setAttribute("co_id", id);
>>>>>>> branch 'master' of https://github.com/jiwoonglee89/Semi
		return "confirmId.jsp";
	}

}
