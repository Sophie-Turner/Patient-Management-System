/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Controller.LoginStrategyController;
import View.Login;
import Model.User;
import Model.InteractWithXML;
/**
 *
 * @author pipin
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //A test of the XML classes
        InteractWithXML testDOM = new InteractWithXML();
        testDOM.interact();
        
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
