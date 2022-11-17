package Service;

import java.util.ArrayList;

import Domain.HotelDAO;
import Domain.HotelDTO;

public class HotelService {
      private HotelDAO dao = HotelDAO.getInstance();
      
      private HotelService instance;
      public HotelService getInstance() {
         if(instance ==null)
            instance =new HotelService();
         return instance;
         
      }
   public HotelService() {}   
      
      public boolean RegisterHotel(HotelDTO dto, int perm) {
         boolean isRerve = true;  //2
         
         if(perm>=2) {
            int result =dao.UpdateHotel(dto);
            if(result>0) {
               return true;
            }
         }
         return false;
         
      }
      
      
      public ArrayList<HotelDTO> ShowAllHotel(){
         return dao.SelectHotel();
      }
      
      
      
}