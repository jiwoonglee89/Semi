package per.action;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import DB.FileBean;
import action.CommandAction;

public class Per_FileDeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		Connection con = new Connection();
		SqlSession session = con.connection();

		// HttpSession session2 = request.getSession();

		/*
		 * String context = request.getContextPath();
		 * System.out.println("context:::::"+context);
		 */

		ServletContext app = (ServletContext) request.getAttribute("app");
		String directory = app.getRealPath("/File");

		String f_filename = new String(request.getParameter("f_filename").getBytes("8859_1"), "UTF-8");
		System.out.println("f_filename::::" + f_filename);

		int success = session.delete("file.delete", f_filename);
		System.out.println("success:::" + success);
		if (success != 0) {
			session.commit();
		}

		File file = new File(directory+"/"+f_filename);

		//System.out.println("file.path :::" + file.getPath());

		try {
			file.delete();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "p_detail.jsp";
	}
}
