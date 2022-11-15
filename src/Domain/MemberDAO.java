package Domain;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.cj.protocol.Resultset;

public class MemberDAO {
	String id = "root";
	String pwd = "1234";
	String url = "jdbc:mysql://localhost:3306/tbl_mem";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	Resultset rs = null;
	
	//싱글 톤 패턴
	private static MemberDAO instance;
	
	private static MemberDAO geinstance() {
		if(instance == null) {
			MemberDAO instance = new MemberDAO();
			return instance;
		}
		return instance;
	}
	
	
}
