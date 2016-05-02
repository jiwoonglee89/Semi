package per.action;

import java.util.Arrays;
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
			System.out.println("여기까진됨");
			int m_count_request = Integer.parseInt(request.getParameter("m_count"));
			String m_countdes = null;

			System.out.println("m_count_request:::" + m_count_request);

			HttpSession session2 = request.getSession();
			String p_id = (String) session2.getAttribute("p_id");
			String co_id = "1";

			if (m_count == m_count_request) {
				m_countdes = "읽지않음";
			} else {
				m_countdes = "읽음";
			}
			System.out.println("m_countdes::::" + m_countdes);

			List dataList = session.selectList("message.m_list", p_id);

			MessageBean mbean = new MessageBean();
			mbean.setM_countdes(m_countdes);
			
			MessageBean mbeanList = session.selectOne("message.m_listbyco", co_id);
			
			int m_num = mbeanList.getM_num();
			mbean.setM_num(m_num);
			
			session.update("message.insertdes", mbean);

			request.setAttribute("m_num", new Integer(m_num));
			request.setAttribute("co_id", co_id);
			request.setAttribute("dataList", dataList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "p_messageList.jsp";
	}

}
