/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Strategies.ILoginStrategy;
/**
 *
 * @author pipin
 */
public class User {
 
    protected String forename;
    protected String surname;
    protected String address;
    protected String userId;   
    protected ILoginStrategy loginStrategy;

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
    
    public User() {
        this.loginStrategy = null;
    }
    
    public void setStrategy(ILoginStrategy loginStrategy){
        System.out.println("setStrategy method was called inside User model.");
        this.loginStrategy = loginStrategy;
    }
    
   public static ILoginStrategy selectStrategy(String userId, String password){
        ILoginStrategy loginStrategy;
        loginStrategy = null;
        switch (userId.charAt(0)) {
            case 'P':
               loginStrategy = new Strategies.LoginAsPatientStrategy();
               break;
            case 'A':
               loginStrategy = new Strategies.LoginAsAdminStrategy();
               break;
            case 'D':
               loginStrategy = new Strategies.LoginAsDoctorStrategy();
               break;
            case 'S': //Lowercase too!
                System.out.println("SelectStrategy method in user model recognises username."); //Testing
               loginStrategy = new Strategies.LoginAsSecretaryStrategy();
               break;    
            default: //Message box or something for if they input an invalid username
            //Remember they need to give a password too!
        }        
        return loginStrategy;
    }
     public void completeLogin(String userId, String password) {
         System.out.println("CompleteLogin method was called inside User model. Next should be SelectStrategy.");
         this.setStrategy(selectStrategy(userId, password));
         this.loginStrategy.completeLogin();
    }
    
}
