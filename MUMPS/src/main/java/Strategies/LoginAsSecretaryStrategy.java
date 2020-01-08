
package Strategies;
import View.SecretaryHome;
import Model.Secretary;
import Controller.SecretaryController;
/**
 *Now we know that the user is a secretary.
     * <p>Set the relevant model and view.</p>
 * @author pipin
 */
public class LoginAsSecretaryStrategy implements ILoginStrategy {
    
    /**
     *
     */
    @Override
    public void completeLogin(){
    //Should I create an instance of a secretary here? Yes.
    //This method should send the user to the secretary home.
      System.out.println("CompleteLogin method in LoginAsSecretaryStrategy was called.");
      SecretaryHome view = new SecretaryHome();
      Secretary model = new Secretary("","","","");
      SecretaryController controller = new SecretaryController();
      controller.setHomeView(view);
      controller.setModel(model);
      view.setVisible(true);     
    }
}
