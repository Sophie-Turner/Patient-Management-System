
package Model;
/**
 *
 * @author pipin
 */
public class Secretary extends User {
    

    public Secretary(String forename, String surname, String address, String userId){
    this.forename = forename;
    this.surname = surname;
    this.address = address;
    this.userId = userId;
   } 
    

    public void approveAccount(){}
   

    public void removePatient(){}

    public void approveAppointment(){}
    
   //Secretary testSecretary = new Secretary("Gupinda", "Guppy", "20 Chandra Place, Kirbyton", "S001");
}
