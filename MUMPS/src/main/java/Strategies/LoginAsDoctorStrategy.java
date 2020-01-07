/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategies;
import View.DoctorHome;
import Model.Doctor;
import Controller.DoctorController;
/**
 *
 * @author pipin
 */
public class LoginAsDoctorStrategy implements ILoginStrategy {

    /**
     *
     */
    @Override
    public void completeLogin(){
        System.out.println("CompleteLogin method in LoginAsDoctorStrategy was called.");
        DoctorHome view = new DoctorHome();
        Doctor model = new Doctor("","","","");
        DoctorController controller = new DoctorController();
        controller.setHomeView(view);
        controller.setModel(model);
        view.setVisible(true);
    }
}
