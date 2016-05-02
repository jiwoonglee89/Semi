package per.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.FileBean;
import DB.MessageBean;
import DB.P_MemBean;
import action.CommandAction;
import action.Connection;

public class Per_MainViewAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		Connection con = new Connection();
		SqlSession session = con.connection();

		HttpSession session2 = request.getSession();
		String p_id = (String) session2.getAttribute("p_id");
		ServletContext app = (ServletContext) request.getAttribute("app");

		System.out.println("app::::" + app);

		List mbean = session.selectList("message.m_list",p_id);
		
		P_MemBean p_list = session.selectOne("per_member.find", p_id);
		List fileList = session.selectList("file.all", p_id);
		System.out.println("fileList.size():::" + fileList.size());

		String search = request.getParameter("search");

		if (search != null) {
			String searchn = request.getParameter("searchn");
			if (search.equals("0")) {

				fileList = session.selectList("file.ca", searchn);

			} else if (search.equals("1")) {

				fileList = session.selectList("file.ti", searchn);

			} else if (search.equals("2")) {

				fileList = session.selectList("file.de", searchn);

			}
		}

		request.setAttribute("mbean", mbean);
		request.setAttribute("p_list", p_list);

		request.setAttribute("fileList", fileList);
		request.setAttribute("app", app);

		return "/person/p_mainview.jsp";
	}

}
