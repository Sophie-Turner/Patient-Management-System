
package Model;
/**
 *
 * @author pipin
 */
public class Patient extends User {
    
    private int age;
    private String gender;


    public Patient(String forename, String surname, String address, String userId, int age, String gender){
    this.forename = forename;
    this.surname = surname;
    this.address = address;
    this.userId = userId;
    this.age = age;
    this.gender = gender;
   } 
    

    public int getAge() {
        return age;
    }


    public String getGender() {
        return gender;
    }


    public void createAccount(){}
    

    public void rateDoctor(){}
    

    public void viewPrescriptions(){}
    

    public void closeAccount(){}
    
    //Patient testPatient = new Patient("Guss", "Gass", "27 Sproutmeal Road, Fumeford", "P001", 30, "Male");
}
