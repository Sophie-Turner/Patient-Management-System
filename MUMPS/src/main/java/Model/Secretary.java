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
public class Secretary extends User{
    
    public Secretary(String forename, String surname, String address, String userId){
    this.forename = forename;
    this.surname = surname;
    this.address = address;
    this.userId = userId;
   } 
    
   public void approveAccount(){}
   
   public void removePatient(){}
   
   public void approveAppointment(){}
    
}
