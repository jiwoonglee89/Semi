package DB;

import java.sql.Timestamp;
 
public class MessageBean {
	String p_id;
	String co_id;
	String m_title;
	String m_context;
	Timestamp m_regdate;
	int m_count;
	
	public MessageBean(){} 
	
	public MessageBean( String m_title, Timestamp m_regdate,int m_count){
		super();
		this.m_title = m_title;
		this.m_regdate = m_regdate;
	}
	
	public MessageBean(String p_id,String co_id,String m_title, String m_context,Timestamp m_regdate){
		
		super();
		this.p_id = p_id;
		this.co_id = co_id;
		this.m_title = m_title;
		this.m_context = m_context;
		this.m_regdate = m_regdate;
	}
	
	

	public int getCount() {
		return m_count;
	}
	public void setCount(int m_count) {
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
