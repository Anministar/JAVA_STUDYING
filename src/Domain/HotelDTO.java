package Domain;
public class HotelDTO implements DTO {
	private String hotelId;
	private String hotelName;
	private boolean isReserve;
	private int price;
	
	public HotelDTO() {
		// TODO Auto-generated constructor stub
	}
	public HotelDTO(String hotelId, String hotelName, boolean isReserve, int price) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.isReserve = isReserve;
		this.price = price;
	
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public boolean isReserve() {
		
		return isReserve;
	}
	public void setReserve(boolean isReserve) {
		this.isReserve = isReserve;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "HotelDTO [hotelId=" + hotelId + ", hotelName=" + hotelName + ", isReserve=" + isReserve + ", price="
				+ price + "]";
	}
	
}
