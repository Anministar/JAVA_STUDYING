package Ch99;


import java.util.Scanner;

public class test2 {
   
   public static boolean Iscontain(String str, String[] text) {
      if (text[0].contains(str) || text[1].contains(str) || text[2].contains(str)) {
         return true;
      }
      else {
         return false;
      }
      
      
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String[] num = new String[3];
      
      for (int i = 1; i <= num.length ; i++) {
         System.out.println(i + ". 문자열을 입력하세요 : ");
         num[i-1] = sc.nextLine();
      }
      
      System.out.println("찾을 문자열 입력하세요 : ");
      String num4 = sc.nextLine();
      
      System.out.println(num4 + " 포함 여부 : " + Iscontain(num4, num));
      
      
      
   }
   
   

}