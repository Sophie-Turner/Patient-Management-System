
package Controller;
import Model.Administrator;
import View.AdminHome;
/**
 * 
 * @author pipin
 * <p>
  * Controller is between the model and the view
  * and interacts with them by setting the relevant model and view.  
 */
public class AdminController {
    private AdminHome homeView = null;
    private Administrator model = null;
    
    /**
     *
     * @param homeView
     */
    public void setHomeView(AdminHome homeView){
        
        this.homeView = homeView;
    }

    /**
     *
     * @param model
     */
    public void setModel(Administrator model){

        this.model = model;
    }
}
