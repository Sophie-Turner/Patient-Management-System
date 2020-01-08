
package Strategies;
import View.AdminHome;
import Model.Administrator;
import Controller.AdminController;
/**
 *
 * @author pipin
 */
public class LoginAsAdminStrategy implements ILoginStrategy {

    /**
     * Now we know that the user is an admin.
     * <p>Set the relevant model and view.</p>
     */
    @Override
    public void completeLogin(){
        System.out.println("CompleteLogin method in LoginAsAdminStrategy was called.");
        AdminHome view = new AdminHome();
        Administrator model = new Administrator("","","","");
        AdminController controller = new AdminController();
        controller.setHomeView(view);
        controller.setModel(model);
        view.setVisible(true);
    }
}
