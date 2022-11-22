package Domain;

public class OwnerDTO implements DTO{
	private int ownerId;
	private String ownername;
	private String ownerphone;
	
	public OwnerDTO() {
		
	}
	
	public OwnerDTO(int ownerId, String ownername, String ownerphone) {
		super();
		this.ownerId = ownerId;
		this.ownername = ownername;
		this.ownerphone = ownerphone;
	}
	
	//Getter and Setter 만들기
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnername() {
		return ownername;
	} 
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getOwnerphone() {
		return ownerphone;
	}
	public void setOwnerphone(String ownerphone) {
		this.ownerphone = ownerphone;
	}
	
	
	//toString() 만들기
	@Override
	public String toString() {
		return "OwnerDTO [ownerId=" + ownerId + ", ownername=" + ownername + ", ownerphone=" + ownerphone + "]";
	}
	
	
}
