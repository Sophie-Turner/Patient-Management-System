
package Model;
/**
 *
 * @author pipin
 * 
 */
public class Doctor extends User {

    public Doctor(String forename, String surname, String address, String userId){
    this.forename = forename;
    this.surname = surname;
    this.address = address;
    this.userId = userId;
   }     
    
    public void makeNotes(){

}


    public void createMedicine(){}

//Doctor testDoctor = new Doctor("Bogus", "Makeshift", "17 Cowboy Street, Quackington", "D001");

}
