package CH38.Domain;

public class MemberDTO extends DTO {
	private String memId;
	private String pwd;
	
	
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
	
	
	//디폴트 생성자
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	//모든 인자 받는 생성자
	public MemberDTO(String memId, String pwd) {
		super();
		this.memId = memId;
		this.pwd = pwd;
	}
	
	
	//toString() 재정의
	@Override
	public String toString() {
		return "MemberDTO [memId=" + memId + ", pwd=" + pwd + "]";
	}
	
}
