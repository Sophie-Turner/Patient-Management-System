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

Doctor testDoctor = new Doctor("Bogus", "Crevey", "17 Casandra Street, Fropping", "D001");

}
