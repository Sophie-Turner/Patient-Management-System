/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategies;
import View.PatientHome;
import Model.Patient;
import Controller.PatientController;
/**
 *Now we know that the user is a patient.
     * <p>Set the relevant model and view.</p>
 * @author pipin
 */
public class LoginAsPatientStrategy implements ILoginStrategy {

    /**
     *
     */
    @Override
    public void completeLogin(){
        System.out.println("CompleteLogin method in LoginAsPatientStrategy was called.");
        PatientHome view = new PatientHome();
        Patient model = new Patient("","","","",0,"");
        PatientController controller = new PatientController();
        controller.setHomeView(view);
        controller.setModel(model);
        view.setVisible(true);
    } 
}
