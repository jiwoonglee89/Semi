package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import action.CommandAction;
import per.action_W.Connection;

public class File_Up implements CommandAction {

	private static Random random = new Random();

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con = new Connection();
		SqlSession session = con.connection();

		long curruntTime = System.currentTimeMillis();
		int randomValue = random.nextInt(50);
		String fileName = Long.toString(curruntTime) + "_" + Integer.toString(randomValue);

		FileInputStream is = null;
		FileOutputStream os = null;

		ResultSet rs = null;

		FileUpload fBean = new FileUpload();

		int f_num = fBean.getF_num();
		String p_id = fBean.getP_id();
		String realpath = fBean.getRealpath();
		Timestamp f_regdate = fBean.getF_regdate();
		String f_title = fBean.getF_title();
		String f_description = fBean.getF_description();
		int f_readcount = fBean.getF_readcount();
		String c_category = fBean.getF_category();

		rs = (ResultSet) session.selectList("f_num", f_num);

		File file = new File(realpath, fileName);
		
		try {

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
				return file.getAbsolutePath();
			}
		}
		return "/file/file.jsp";

	}

}
