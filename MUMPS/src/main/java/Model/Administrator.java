/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
   
   public void createOtherUser(String userType){
    switch (userType){
        case "Administrator":
            
            break;
        case "Doctor":
            
            break;
        case "Secretary":
            
            break;
    }    
   }
   
   public void removeOtherUser(String userId){}
   

   //Administrator testAdmin = new Administrator("Angus", "Bovey", "12 Castle Drive, Ebrington", "A001");
}
