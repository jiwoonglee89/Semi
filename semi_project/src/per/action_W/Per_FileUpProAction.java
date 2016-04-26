package per.action_W;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.session.SqlSession;

import DB.FileBean;
import DB.P_MemBean;
import action.CommandAction;

public class Per_FileUpProAction implements CommandAction {

	private static Random random = new Random();

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con = new Connection();
		SqlSession session = con.connection();

		String f_title = null;
		String f_description = null;
		String f_category = null;
		String realpath = null;

		FileBean filebean = new FileBean();

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = upload.parseRequest(request);
		System.out.println("items.size():::" + items.size());
		// DB에 저장할 파일의 정보들
		Iterator<FileItem> iter = items.iterator();
		while (iter.hasNext()) {
			FileItem item = iter.next();
			System.out.println("item.getName():::" + item.getFieldName());
			if (item.isFormField()) {
				String name = item.getFieldName();
				if (name.equals("p_category")) {
					f_category = item.getString();
					System.out.println("f_title:::" + f_category);
				} else if (name.equals("f_title")) {
					f_title = item.getString();
				} else if (name.equals("f_description")) {
					f_description = item.getString();
				}
			} else {
				String name = item.getFieldName();
				if (name.equals("file")) {
					realpath = fileup(f_title, item);
					request.setAttribute("f_filename", item.getName());
				}
			}
		}
		// String f_description = request.getParameter("f_description");
		// String realpath = request.getParameter("realpath");

		// P_MemBean pbean = new P_MemBean();

		// 세션값가져오기
		 HttpSession session1 = request.getSession();
		 String p_id = (String) session1.getAttribute("p_id");

		// String realPath = file.getAbsolutePath();
		// 아이디에맞는 카테고리 가져오기
		// String p_category = session.selectOne("per_member.find", p_id);

		// String p_category = request.getParameter("p_category");

		System.out.println(/* p_id+"\n"+ */realpath + "\n" + f_title + "\n" + f_description + "\n" + f_category);

		if (f_category.equals("0")) {
			f_category = "sanup";
		}else if (f_category.equals("1")) {
			f_category = "web";
		}else if (f_category.equals("2")) {
			f_category = "gun";
		}
		
		filebean.setP_id(p_id);
		filebean.setRealpath(realpath);
		filebean.setF_regdate(new Timestamp(System.currentTimeMillis()));
		filebean.setF_title(f_title);
		filebean.setF_description(f_description);
		filebean.setF_readcount(0);
		filebean.setF_category(f_category);
		
		int success = session.insert("per_member.fileadd", filebean);
		if (success > 0) {
			session.commit();
			System.out.println("업로드성공");
		} else {
			session.rollback();
			System.out.println("업로드 실패");
		}
		
		
		request.setAttribute("f_category", f_category);
		request.setAttribute("f_title", filebean.getF_title());
		request.setAttribute("f_description", filebean.getF_description());
		request.setAttribute("f_regdate", filebean.getF_regdate());
		request.setAttribute("realpath", filebean.getRealpath());
		request.setAttribute("success", success);

		return "/person/p_mainview.jsp";

	}

	public String fileup(String f_title, FileItem item) {
		System.out.println("fileup()");
		String directory = "C:/Users/wonmo/Desktop/workspaces/semi_project/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/semi_project/File";

		int randomValue = random.nextInt(50);
		// String fileName = f_title + "_" + Integer.toString(randomValue);
		String fileName = item.getName();
		System.out.println("fileName:::"+fileName);
		File file = new File(directory, fileName);
		String realpath = file.getAbsolutePath();
		System.out.println(realpath);
		FileOutputStream os = null;

		
		InputStream is;
		try {
			is = item.getInputStream();
			os = new FileOutputStream(file);

			byte[] data = new byte[8096];
			int len = -1;
			while ((len = is.read(data)) != -1) {
				os.write(data, 0, len);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return realpath;
	}
}
