package per.action_W;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import DB.FileBean;
import action.CommandAction;

public class Per_FileDeleteProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		Connection con=new Connection();
		SqlSession session = con.connection();
		
		//HttpSession session2 = request.getSession();
		
		
		/*String context = request.getContextPath();
		System.out.println("context:::::"+context);
		*/
		
		ServletContext app =  (ServletContext)request.getAttribute("app");
		String directory =app.getRealPath("/File");

		String f_filename = new String(request.getParameter("f_filename").getBytes("8859_1"), "UTF-8");
		System.out.println("f_filename::::"+f_filename);
		
		FileBean fbean = new FileBean();
		fbean.setF_filename(f_filename);
		int success = session.delete("file.delete", fbean);
		if (success ==0) {
			return "p_detail.jsp";
		}
		
		
		File file = new File(directory,f_filename);
		
		
		System.out.println("filepath:::"+file.getPath());
		System.out.println("절대경로?"+file.isAbsolute());
		
		if (file.getName().equals(f_filename)) {
			try {
				file.delete();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
		
		return "p_detail.jsp";
	}

}
