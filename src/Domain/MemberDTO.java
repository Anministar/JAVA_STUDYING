package Domain;

public class MemberDTO implements DTO {
	private int userId;
	private String memId;
	private String pwd;
	private String name;
	private String phone;
	private String addr;
	private String email;
	private int perm;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	public MemberDTO(int userId, String memId, String pwd, String name, String phone, String addr, String email, int perm) {
		super();
		this.userId = userId;
		this.memId = memId;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.email = email;
		this.perm = perm;
		
	}
	
	
	//Getter and Settr 만들기
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPerm() {
		return perm;
	}
	public void setPerm(int perm) {
		this.perm = perm;
	}
	
	
	
	
	//toString() 재정의
	
	@Override
	public String toString() {
		return "MemberDTO [userId=" + userId + ", memId=" + memId + ", pwd=" + pwd + ", name=" + name + ", phone="
				+ phone + ", addr=" + addr + ", email=" + email + ", perm=" + perm + "]";
	}
	
	
}
