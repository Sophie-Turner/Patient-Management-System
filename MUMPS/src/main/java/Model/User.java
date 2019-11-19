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
public abstract class User {
 
    protected String forename;
    protected String surname;
    protected String address;
    protected String userId;   

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getUserId() {
        return userId;
    }
    
    public void logIn(String userId){
       switch (userId.charAt(0)){
           case 'P':
               
               break;
           case 'A':
               
               break;
           case 'D':
               
               break;
           case 'S':
               
               break;
       }
    }

 
    
}
