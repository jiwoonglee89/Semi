package per.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.FileBean;
import DB.P_MemBean;
import action.CommandAction;
import action.Connection;

public class Per_MainViewAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		Connection con = new Connection();
		SqlSession session = con.connection();

		List dataList = null;

		String search = request.getParameter("search");
		// 검색내용

		//FileBean fBean = new FileBean();

		if (search != null) {
			String searchn = request.getParameter("searchn");
			if (search.equals("0")) {

				search = "f_category";

				dataList = session.selectList("file.ca", searchn);

			} else if (search.equals("1")) {
				search = "f_title";

				dataList = session.selectList("file.ti", searchn);

			} else if (search.equals("2")) {
				search = "f_description";

				dataList = session.selectList("file.de", searchn);

			}
		}

		HttpSession session2 = request.getSession();
		String p_id = (String) session2.getAttribute("p_id");
		ServletContext app = (ServletContext) request.getAttribute("app");

		System.out.println("app::::" + app);

		P_MemBean p_list = session.selectOne("per_member.find", p_id);
		List fileList = session.selectList("file.all", p_id);

		request.setAttribute("p_list", p_list);
		request.setAttribute("fileList", fileList);
		request.setAttribute("app", app);

		request.setAttribute("dataList", dataList);

		/*
		 * request.setAttribute("realpath", fBean.getRealpath());
		 * request.setAttribute("f_title", fBean.getF_title());
		 * 
		 * request.setAttribute("f_description", fBean.getF_description());
		 * request.setAttribute("f_regdate", fBean.getF_regdate());
		 */

		request.setAttribute("search", search);

		return "/person/p_mainview.jsp";
	}

}
