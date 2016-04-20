package DB;

import java.sql.Timestamp;

public class QNABean {
	int q_num;
	String p_id;
	String co_id;
	String qna_title; 
	String q_passwd;
	Timestamp q_regdate;
	int qref_number; 
	int readcount;
	String content;
	public int getQ_num() {
		return q_num;
	}
	public void setQ_num(int q_num) {
		this.q_num = q_num;
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
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQ_passwd() {
		return q_passwd;
	}
	public void setQ_passwd(String q_passwd) {
		this.q_passwd = q_passwd;
	}
	public Timestamp getQ_regdate() {
		return q_regdate;
	}
	public void setQ_regdate(Timestamp q_regdate) {
		this.q_regdate = q_regdate;
	}
	public int getQref_number() {
		return qref_number;
	}
	public void setQref_number(int qref_number) {
		this.qref_number = qref_number;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
