
package Model;
import Strategies.ILoginStrategy;
import javax.swing.JOptionPane;
/**
 *
 * @author pipin
 * The different user types inherit from this model because they share fields.
 * <p>This class might need to be separated out in keeping with single responsibility principle.</p>
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
    
    /**
     *
     * @param loginStrategy is the interface for the login strategy.
     * 
     */
    public void SetStrategy(ILoginStrategy loginStrategy){
        System.out.println("SetStrategy method was called inside User model.");
        this.loginStrategy = loginStrategy;
    }
    
    /**
     * Decides what the user type is based on their username.
     * <p>Remember to include password and error/exception handling.
     * Need a message box or something for if they input an invalid username or pwd.</p>
     * 
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
     * Check their login credentials to make sure they match to a registered user.
     * <p>Put in XML? Do we need to encrypt password? Probably.</p>
     * @return true or false - whether they are a valid user.
     */
    public static boolean validateCredentials(String userId, String password){
        boolean isValidUser = true;
        //check username and password here
        return isValidUser;
    }
   
    /**
     *
     * Completes the login checks and sends them to the strategy where they will be sent to the correct JFrame.
     */
    public void completeLogin(String userId, String password) {
         System.out.println("CompleteLogin method was called inside User model. Next should be SelectStrategy.");
         this.SetStrategy(SelectStrategy(userId, password));
         this.loginStrategy.completeLogin();
    }
    
}
