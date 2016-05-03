package per.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;

public class Per_DeleteFormAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String p_id = (String) session.getAttribute("p_id");
		
		request.setAttribute("p_id", p_id);
		
		return "p_deleteForm.jsp";
	}

}
