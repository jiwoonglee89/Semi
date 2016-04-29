package per.action_W;

import java.io.File;

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
		
		String app = (String) request.getAttribute("app");
		
		
		
		int f_num = (int)request.getAttribute("f_num");
		
		
		FileBean fbean = session.selectOne("file.allbyfname",f_num);
		
		String filename = fbean.getF_filename();
		
		
		app+="/"+filename;
		File file = new File(app); 
		
		try {
			file.delete();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "p_mainview.jsp";
	}

}
