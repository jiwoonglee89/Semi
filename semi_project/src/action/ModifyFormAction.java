package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.Co_MemBean;

public class ModifyFormAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("memId");
		Co_MemBean co_member=new Co_MemBean();
		
		request.setAttribute("c", c);
		return "modifyForm.jsp";
	}

}
