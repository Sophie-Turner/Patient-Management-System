
package Controller;
import Model.Secretary;
import View.SecretaryHome;
import View.SecretaryPatients;
import View.Login;
/**
 *
 * @author pipin
 * Controller is between the model and the view
  * and interacts with them by setting the relevant model and view.
 */
public class SecretaryController {
    private SecretaryHome homeView = null;
    private SecretaryPatients patientsView = null;
    private Secretary model = null;
    
    /**
     *
     * @param homeView the default view where secretaries can look at requests and approve them.
     */
    public void setHomeView(SecretaryHome homeView){
        System.out.println("setHomeView method in SecretaryController was called.");
        this.homeView = homeView; 
    }
    
    /**
     *
     * @param patientsView the view where secretaries can look at patients but not their private info.
     */
    public void setPatientsView(SecretaryPatients patientsView){
        this.patientsView = patientsView;
    }
    
    /**
     *
     * @param model
     */
    public void setModel(Secretary model){
        System.out.println("setModel method in SecretaryController was called.");
        this.model = model;
    }
}
