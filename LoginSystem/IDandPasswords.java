   import java.util.HashMap;
   public class IDandPasswords {

      HashMap<String,String> logininfo = new HashMap<String,String>();
      
            
      IDandPasswords(){
         
       
         logininfo.put("Bro", "Pizza");
         logininfo.put("Bromez", "Pizzuh");
         logininfo.put("Brody", "Password");

      }
        public void addLoginInfo(String userID, String password) {
        logininfo.put(userID, password);
        }
         
      protected HashMap getLoginInfo(){
         
         return logininfo;
      
      }

   }