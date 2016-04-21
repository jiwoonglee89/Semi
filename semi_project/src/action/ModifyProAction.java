package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ssol.logon.LogonDBBean;
import ssol.logon.LogonDataBean;

public class ModifyProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		String passwd=request.getParameter("passwd");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String blog=request.getParameter("blog");
		
		LogonDataBean member=new LogonDataBean();
		LogonDBBean manager=LogonDBBean.getInstance();
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("memId");
		member=manager.getMember(id);		
		
		member.setPasswd(passwd);
		member.setName(name);
		member.setEmail(email);
		member.setBlog(blog);
		
		manager.updateMember(member);

		return "modifyPro.jsp";
	}

}
