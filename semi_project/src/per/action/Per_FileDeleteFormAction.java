package per.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class Per_FileDeleteFormAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String f_filename = request.getParameter("f_filename");
		
		System.out.println("form filename"+f_filename);
		request.setAttribute("f_filename", f_filename);
		
		return "p_filedeleteForm.jsp";
	}

}
