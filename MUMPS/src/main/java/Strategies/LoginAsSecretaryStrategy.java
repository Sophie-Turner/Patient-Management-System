
package Strategies;
import View.SecretaryHome;
import Model.Secretary;
import Controller.SecretaryController;
/**
 *
 * @author pipin
 */
public class LoginAsSecretaryStrategy implements ILoginStrategy {
    
    @Override
    public void Login(){
    //Should I create an instance of a secretary here? Yes.
    //This method should send the user to the secretary home.
    SecretaryHome view = new SecretaryHome();
    Secretary model = new Secretary("","","","");
    SecretaryController controller = new SecretaryController();
    controller.setHomeView(view);
    controller.setModel(model);
    view.setVisible(true);
        System.out.println("The secretary Login strategy worked.");
    }
}
