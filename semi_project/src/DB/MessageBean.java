package DB;

import java.sql.Timestamp;

public class MessageBean {
	String p_id;
	String co_id;
	String co_com;
	String m_title;
	String m_context;
	Timestamp m_regdate;
	int m_count;
	String m_countdes;

	public MessageBean() {
	}

	
	public String getM_countdes() {
		return m_countdes;
	}

	public void setM_countdes(String m_countdes) {
		this.m_countdes = m_countdes;
	}
	public String getCo_com() {
		return co_com;
	}

	public void setCo_com(String co_com) {
		this.co_com = co_com;
	}

	public int getM_count() {
		return m_count;
	}

	public void setM_count(int m_count) {
		this.m_count = m_count;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getCo_id() {
		return co_id;
	}

	public void setCo_id(String co_id) {
		this.co_id = co_id;
	}

	public String getM_title() {
		return m_title;
	}

	public void setM_title(String m_title) {
		this.m_title = m_title;
	}

	public String getM_context() {
		return m_context;
	}

	public void setM_context(String m_context) {
		this.m_context = m_context;
	}

	public Timestamp getM_regdate() {
		return m_regdate;
	}

	public void setM_regdate(Timestamp m_regdate) {
		this.m_regdate = m_regdate;
	}

}
