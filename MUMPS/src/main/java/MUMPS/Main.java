
package MUMPS;
import Controller.LoginStrategyController;
import View.Login;
import Model.User;

import javax.swing.DefaultComboBoxModel;
import Model.PopulateLists;
/**
 *
 * @author pipin
 */
public class Main {
    
/**
 * The main method creates the initial model, view and controller 
 *  in preparation for the user to input their login credentials.
 */
    public static void main(String[] args) {
             
        //Instantiate the model
        User user = new User();
        //Instantiate the view
        Login view = new Login();
        //Instantiate the controller
        LoginStrategyController controller = new LoginStrategyController();
        //set controller attributes
        controller.setView(view);
        controller.setModel(user);
        //add listener to the button and start listening
        view.addButtonHandlerStrategy(controller);
        view.setVisible(true);
        
    }
    
}
