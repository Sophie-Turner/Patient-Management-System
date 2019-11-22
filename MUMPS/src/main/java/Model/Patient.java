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
public class Patient extends User implements IDoctorViewer {
    
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
    
    Patient testPatient = new Patient("Guss", "Creasy", "27 Poldra Road, Freminton", "P001", 30, "Male");
}
