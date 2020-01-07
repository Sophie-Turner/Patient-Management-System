
package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.Login;
import Model.User;
/**
 *
 * @author pipin
 */
public class LoginStrategyController implements ActionListener{
    private Login view = null;
    private User model = null;
    
    /**
     *
     * @param view
     */
    public void setView(Login view){
        this.view = view;
    }

    /**
     *
     * @param model
     */
    public void setModel(User model){
        this.model = model;
    }
    
    /**
     * Override the actionPerformed method which is when the user clicks a button in the view.Takes the user's input from the form and sends it to the completeLogin method in the model.
     *
     * @param clickLogin 
     */
    @Override //when the user clicks the login button.
    public void actionPerformed(ActionEvent clickLogin){
        System.out.println("Click registered in the login strategy controller.");
        String userId = view.getUsername();
        String password = view.getPassword();
        view.clearAll();
        model.completeLogin(userId, password);
       
    }
}
