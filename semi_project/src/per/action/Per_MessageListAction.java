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

			String m_countdes = null;
			int m_count = 0;
			System.out.println("여기까진됨");
			int m_count_request = Integer.parseInt(request.getParameter("m_count"));
			int m_num = Integer.parseInt(request.getParameter("m_num"));
			if (m_num != 0 ) {
				session.update("message.increascount", m_num);

				if (m_count_request > 0) {
					m_countdes = "읽음";
				}
				
				MessageBean mbean = new MessageBean();
				mbean.setM_countdes(m_countdes);
				mbean.setM_num(m_num);
				
				session.update("message.insertdes", mbean);
			}
			
			System.out.println("m_num:::"+m_num);
			System.out.println("m_count_request:::" + m_count_request);

			HttpSession session2 = request.getSession();
			String p_id = (String) session2.getAttribute("p_id");	

			System.out.println("p_id:::"+p_id);
			
			
			
			List dataList = session.selectList("message.m_list", p_id);
			
			request.setAttribute("dataList", dataList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "p_messageList.jsp";
	}

}
