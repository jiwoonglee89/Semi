package DB;

import java.sql.Timestamp; 

public class FileBean {
	String p_id;
	String realpath;
	Timestamp f_regdate;
	String f_description;
	String f_title;
	int f_readcount;
	String f_category; 
	int f_num;
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getRealpath() {
		return realpath;
	}
	public void setRealpath(String realpath) {
		this.realpath = realpath;
	}
	public Timestamp getF_regdate() {
		return f_regdate;
	}
	public void setF_regdate(Timestamp f_regdate) {
		this.f_regdate = f_regdate;
	}
	public String getF_description() {
		return f_description;
	}
	public void setF_description(String f_description) {
		this.f_description = f_description;
	}
	public String getF_title() {
		return f_title;
	}
	public void setF_title(String f_title) {
		this.f_title = f_title;
	}
	public int getF_readcount() {
		return f_readcount;
	}
	public void setF_readcount(int f_readcount) {
		this.f_readcount = f_readcount;
	}
	public String getF_category() {
		return f_category;
	}
	public void setF_category(String f_category) {
		this.f_category = f_category;
	}
	public int getF_num() {
		return f_num;
	}
	public void setF_num(int f_num) {
		this.f_num = f_num;
	}
	
	
	
	
	
}
