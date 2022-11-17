package Domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class HotelDAO {

	String id = "root";
	String pwd = "1234";
	String url = "jdbc:mysql://localhost:3306/hotelreservation";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private static HotelDAO instance;

	public static HotelDAO getInstance() {
		if (instance == null)
			instance = new HotelDAO();
		return instance;

	}

	public int UpdateHotel(HotelDTO dto) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement("update hotel set hotelname = ?,isreserve = ? where hotelname = ?");

			pstmt.setString(1, dto.getHotelName());
			if (dto.isReserve())
				pstmt.setInt(2, 1);
			else
				pstmt.setInt(2, 0);
			pstmt.setString(3, dto.getHotelId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	public ArrayList<HotelDTO> SelectHotel() {
		ArrayList<HotelDTO> list = new ArrayList<HotelDTO>();
		HotelDTO dto;

		try {
			pstmt = conn.prepareStatement("select * from hotel");
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					dto = new HotelDTO();
					dto.setHotelId(rs.getString("HotelId"));
					dto.setHotelName(rs.getString("HotelName"));
					if (rs.getInt("isReserve") == 1)
						dto.setReserve(true);
					else
						dto.setReserve(false);
					list.add(dto);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;

	}
}
