package per.action_W;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import DB.Co_MemBean;
import DB.MessageBean;
import action.CommandAction;

public class Per_MessageListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		try {

			request.setCharacterEncoding("UTF-8");

			Connection con = new Connection();
			SqlSession session = con.connection();

			int m_count = 0;
			System.out.println("���������");
			int m_count_request = Integer.parseInt(request.getParameter("m_count"));
			String m_countdes = null;

			System.out.println("m_count_request:::"+m_count_request);
			
			HttpSession session2 = request.getSession();
			String p_id = (String) session2.getAttribute("memId");
			
			if (m_count == m_count_request) {
				m_countdes = "��������";
			} else {
				m_countdes = "����";
			}
			
			int insertdes = session.insert("message.insertdes", m_countdes);
			
			List dataList = session.selectList("message.m_list", p_id);
			
			System.out.println(dataList.toArray());
			
			request.setAttribute("dataList", dataList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "p_messageList.jsp";
	}

}
