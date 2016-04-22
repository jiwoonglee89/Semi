package DB;

public class P_MemBean {
	String p_id;
	String p_passwd;
	String p_name;
	String p_gender; 
	String p_email;
	int p_birth;
	String p_tel;
	String jumin1;
	String jumin2;
	String p_career;
	String p_award;
	String p_zipcode;
	String p_address;
	String p_category;
	int p_count;
	
	public P_MemBean (String id, String passwd, String name, int gender, String email, int birth, String phone, String tel, String jumin12, String jumin22, String career, String award, String zipcode, String address, String category, int i){}
	
	public P_MemBean (String p_id, String p_passwd){  
		super();
		this.p_id = p_id;
		this.p_passwd = p_passwd;
	}
	
	public P_MemBean(String p_id, String p_passwd, String p_name, String p_gender, String jumin1, String jumin2,String p_email, int p_birth,
			 String p_tel,  String p_career, String p_award,
			String p_zipcode, String p_address, String p_category,int p_count) {
		super();
		this.p_id = p_id;
		this.p_passwd = p_passwd;
		this.p_name = p_name;
		this.p_gender = p_gender;
		this.p_email = p_email; 
		this.p_birth = p_birth;
		
		this.p_tel = p_tel;
		this.jumin1 = jumin1;
		this.jumin2 = jumin2;
		this.p_career = p_career;
		this.p_award = p_award;
		this.p_zipcode = p_zipcode;
		this.p_address = p_address;
		this.p_category = p_category;
		this.p_count = p_count;
	}

	public P_MemBean() {
		// TODO Auto-generated constructor stub
	}

	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_passwd() {
		return p_passwd;
	}
	public void setP_passwd(String p_passwd) {
		this.p_passwd = p_passwd;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_gender() {
		return p_gender;
	}
	public void setP_gender(String p_gender) {
		this.p_gender = p_gender;
	}
	public String getP_email() {
		return p_email;
	}
	public void setP_email(String p_email) {
		this.p_email = p_email;
	}
	public int getP_birth() {
		return p_birth;
	}
	public void setP_birth(int p_birth) {
		this.p_birth = p_birth;
	}
	
	public String getP_tel() {
		return p_tel;
	}
	public void setP_tel(String p_tel) {
		this.p_tel = p_tel;
	}
	public String getJumin1() {
		return jumin1;
	}
	public void setJumin1(String jumin1) {
		this.jumin1 = jumin1;
	}
	public String getJumin2() {
		return jumin2;
	}
	public void setJumin2(String jumin2) {
		this.jumin2 = jumin2;
	}
	public String getP_career() {
		return p_career;
	}
	public void setP_career(String p_career) {
		this.p_career = p_career;
	}
	public String getP_award() {
		return p_award;
	}
	public void setP_award(String p_award) {
		this.p_award = p_award;
	}
	public String getP_zipcode() {
		return p_zipcode;
	}
	public void setP_zipcode(String p_zipcode) {
		this.p_zipcode = p_zipcode;
	}
	public String getP_address() {
		return p_address;
	}
	public void setP_address(String p_address) {
		this.p_address = p_address;
	}
	public String getP_category() {
		return p_category;
	}
	public void setP_category(String p_category) {
		this.p_category = p_category;
	}
	public int getP_count() {
		return p_count;  
	}
	public void setP_count(int p_count) {
		this.p_count = p_count;
	}
} 
