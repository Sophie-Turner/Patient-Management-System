/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
     *
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
