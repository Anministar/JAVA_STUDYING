package CH38.Domain;

public class MemberDTO extends DTO {
	private String memId;
	private String pwd;
	private int role;	// 0 회원 , 1 사서
	
	
	//Getter and Setter
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
	
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	//디폴트 생성자
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	//모든 인자 받는 생성자
	public MemberDTO(String memId, String pwd) {
		super();
		this.memId = memId;
		this.pwd = pwd;
		this.role = 0;
	}
	
	public MemberDTO(String memId, String pwd, int role) {
		super();
		this.memId = memId;
		this.pwd = pwd;
		this.role = role;
	}

	//toString() 재정의
	@Override
	public String toString() {
		return "MemberDTO [memId=" + memId + ", pwd=" + pwd + ", role=" + role + "]";
	}
}
