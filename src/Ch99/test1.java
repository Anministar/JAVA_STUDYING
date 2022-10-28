package Ch99;


import java.util.ArrayList;

class Cal {
   //멤버변수(arr[] -> ArrayList로 변경!, idx는 삭제)
	int arr[] = new int[10];
   ArrayList<Integer> list = new ArrayList<>();
   
   
   
   //싱글톤 패턴 코드 삽입!
   private static Cal instance = null;
   
   public static Cal getinstance() {
      if(instance == null) {
         instance = new Cal();
      }
         return instance;
      }
   
   public int InsertVal(int tmp) {
      try {
         list.add(tmp);
         
      } catch (Exception e) {
         return -1;
      }
      return 0;
   }
   
   // 저장된 값 확인(ArrayList 에 맞게 변경하기)
   public void ShowVal() {
       System.out.println("-----------조회-----------");
       for (int i = 0; i < list.size(); i++) {
         System.out.println(list.get(i));
      }
   }
   
   
}
public class test1 {

   public static void main(String[] args) {
      
      Cal cal = Cal.getinstance();
      
      for (int i = 1; i <= 100; i++) {
         cal.InsertVal(i);
      }
      cal.ShowVal();

      
      
   }

}