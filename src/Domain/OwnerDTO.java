package Domain;

public class OwnerDTO {
	private int ownerId;
	private int hotelId;
	private String hotelname;
	private Boolean isReserve;
	
	
	
	public OwnerDTO(int ownerId, int hotelId, String hotelname, Boolean isReserve) {
		super();
		this.ownerId = ownerId;
		this.hotelId = hotelId;
		this.hotelname = hotelname;
		this.isReserve = isReserve;
	}
	//Getter and Setter 만들기
	
	
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public Boolean getIsReserve() {
		return isReserve;
	}
	public void setIsReserve(Boolean isReserve) {
		this.isReserve = isReserve;
	}
	
	
	//toString() 만들기
	@Override
	public String toString() {
		return "OwnerDTO [ownerId=" + ownerId + ", hotelId=" + hotelId + ", hotelname=" + hotelname + ", isReserve="
				+ isReserve + "]";
	}
	
	
	
}
