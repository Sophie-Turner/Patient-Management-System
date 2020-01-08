
package Controller;
import Model.Administrator;
import View.AdminHome;
/**
 * 
 * @author pipin
 * <p>
  * Controller is between the model and the view
  * and interacts with them by setting the relevant model and view.  
 *</p>
 */
public class AdminController {
    private AdminHome homeView = null;
    private Administrator model = null;
    
    /**
     * This method sets the view to the JFrame where users can log in.
     * @param homeView The log in view.
     */
    public void setHomeView(AdminHome homeView){
        
        this.homeView = homeView;
    }

    /**
     * Sets the model to the user model from which other user type models inherit.
     * @param model the user model.
     */
    public void setModel(Administrator model){

        this.model = model;
    }
}
