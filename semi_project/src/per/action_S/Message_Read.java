package per.action_S;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Co_MemBean;
import DB.MessageBean;
import action.CommandAction;

public class Message_Read implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		try {
			request.setCharacterEncoding("UTF-8");

			Co_MemBean check = new Co_MemBean();
			MessageBean check2 = new MessageBean();

			String m_title = check2.getM_title();
			String co_com = check.getCo_com();
			String co_name = check.getCo_name();
			String co_tel = check.getCo_tel();
			String co_email = check.getCo_email();
			String m_context = check2.getM_context();

			request.setAttribute("m_title", m_title);
			request.setAttribute("co_com", co_com);
			request.setAttribute("co_name", co_name);
			request.setAttribute("co_tel", co_tel);
			request.setAttribute("co_email", co_email);
			request.setAttribute("m_context", m_context);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/person/messege_view.jsp";
	}

}
