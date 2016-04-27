package per.action_S;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import DB.QNABean;
import action.CommandAction;
import per.action_W.Connection;

public class QnA_ListSearchForm implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con = new Connection();
		SqlSession session = con.connection();

		String p_id = request.getParameter("p_id");
		String co_id = request.getParameter("co_id");

		QNABean qBean = new QNABean();

		qBean.getQ_num();
		qBean.getQna_title();

		String search = null;
		String searchn = request.getParameter("searchn");

		List pMem = session.selectOne("qna.p_check", p_id);
		List coMem = session.selectOne("qna.co_check", co_id);

		if (searchn != null) {
			search = request.getParameter("search");
			if (search.equals("0")) {
				search = "id";
			} else if (search.equals("1")) {
				search = "name";
			}
		}

		qBean = session.selectOne("qna.search", searchn);

		request.setAttribute("qBean", qBean);
		request.setAttribute("pMem", pMem);
		request.setAttribute("coMem", coMem);

		return null;
	}

}
