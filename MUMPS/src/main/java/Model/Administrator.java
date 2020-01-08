
package Model;
/**
 *
 * @author pipin
 */
public class Administrator extends User {
    
    public Administrator(String forename, String surname, String address, String userId){
    this.forename = forename;
    this.surname = surname;
    this.address = address;
    this.userId = userId;
   } 
    
   /**
    * Admins can create and remove accounts for all user types apart from patients.
    * @param userType is needed to decide what model should be used to create the new user. 
    */
   public void createOtherUser(String userType){
    switch (userType){
        case "Administrator":
            //Finish later
            break;
        case "Doctor":
            
            break;
        case "Secretary":
            
            break;
    }    
   }
   

    public void removeOtherUser(String userId){}
   

   //Administrator testAdmin = new Administrator("Angus", "Bovine", "12 Cattle Drive, Moofield", "A001");
}
