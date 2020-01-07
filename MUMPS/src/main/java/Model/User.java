/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Strategies.ILoginStrategy;
import javax.swing.JOptionPane;
/**
 *
 * @author pipin
 */
public class User {
 
    /**
     *
     */
    protected String forename;

    /**
     *
     */
    protected String surname;

    /**
     *
     */
    protected String address;

    /**
     *
     */
    protected String userId;   

    /**
     *
     */
    protected ILoginStrategy loginStrategy;

    /**
     *
     * @return
     */
    public String getForename() {
        return forename;
    }

    /**
     *
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @return
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     *
     */
    public User() {
        this.loginStrategy = null;
    }
    
    /**
     *
     * @param loginStrategy
     */
    public void SetStrategy(ILoginStrategy loginStrategy){
        System.out.println("SetStrategy method was called inside User model.");
        this.loginStrategy = loginStrategy;
    }
    
    /**
     *
     * @param userId
     * @param password
     * @return
     */
    public static ILoginStrategy SelectStrategy(String userId, String password){
        ILoginStrategy loginStrategy;
        loginStrategy = null;
        boolean isValidUser = false;
        isValidUser = validateCredentials(userId, password);
        if(isValidUser == true){
            switch (userId.charAt(0)) {
                case 'P':
                    System.out.println("SelectStrategy method in user model recognises username."); //Testing
                   loginStrategy = new Strategies.LoginAsPatientStrategy();
                   break;
                case 'A':
                    System.out.println("SelectStrategy method in user model recognises username."); //Testing
                   loginStrategy = new Strategies.LoginAsAdminStrategy();
                   break;
                case 'D':
                    System.out.println("SelectStrategy method in user model recognises username."); //Testing
                   loginStrategy = new Strategies.LoginAsDoctorStrategy();
                   break;
                case 'S': //Lowercase too?
                   System.out.println("SelectStrategy method in user model recognises username."); //Testing
                   loginStrategy = new Strategies.LoginAsSecretaryStrategy();
                     
                 //Message box or something for if they input an invalid username
                }        
        }else{
            JOptionPane.showMessageDialog(null, "Incorrect credentials. Please try again, or create a new account."); 
            loginStrategy = null;
        }
        return loginStrategy;
    }
   
    /**
     *
     * @param userId
     * @param password
     * @return
     */
    public static boolean validateCredentials(String userId, String password){
        boolean isValidUser = true;
        //check username and password here
        return isValidUser;
    }
   
    /**
     *
     * @param userId
     * @param password
     */
    public void completeLogin(String userId, String password) {
         System.out.println("CompleteLogin method was called inside User model. Next should be SelectStrategy.");
         this.SetStrategy(SelectStrategy(userId, password));
         this.loginStrategy.completeLogin();
    }
    
}
