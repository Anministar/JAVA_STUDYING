package Ch99;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class test3 {

   public static void main(String[] args) {
      //연결관련 정보
      String driver = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://localhost:3306/tempdb"; 
      String user = "root"; 
      String pwd = "1234"; 
      
      //연결객체 참조변수
      String sql;						//sql 임시저장
      Connection conn = null;           //DB 연결용
      PreparedStatement pstmt = null;   //sql문 명령 전달용
      ResultSet rs = null;            	//sql 결과문 저장용
      
      
      
      try {
    	  //드라이브 적재
         Class.forName(driver); 
         System.out.println("Driver Loading Success!!");
         
         //Connection 객체 생성 conn에 연결
         conn = DriverManager.getConnection(url, user, pwd); 
         System.out.println("DB Connected...");
         
         
//         //pstmt에 적절한 객체연결
         sql = "SELECT * from `tempdb`.`student_tbl`";
         pstmt = conn.prepareStatement(sql);
         
         pstmt.executeQuery();
         
         //rs에 적절한 객체연결
         rs = pstmt.executeQuery(); 
         
         if(rs != null) {
            while(rs.next()) { 
               System.out.print(rs.getString("id") + " ");
               System.out.print(rs.getString("name") + " ");
               System.out.print(rs.getInt("age") + " ");
               System.out.print(rs.getString("addr") + " ");
               System.out.println();
               
            }
         }
         
         
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
          try {rs.close();}catch(Exception e) {e.printStackTrace();}
          try {pstmt.close();}catch(Exception e) {e.printStackTrace();}
          try {conn.close();}catch(Exception e) {e.printStackTrace();} 
       }
      
      
      
   }

}