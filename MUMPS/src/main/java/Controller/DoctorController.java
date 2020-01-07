/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Doctor;
import Model.InteractWithXML;
import View.DoctorHome;
import View.DoctorFeedback;
import View.DoctorPatients;
/**
 *
 * @author pipin
  * Controller is between the model and the view
  * and interacts with them by setting the relevant model and view.
 */
public class DoctorController {
    private DoctorHome homeView = null;
    private DoctorFeedback feedbackView = null;
    private DoctorPatients patientsView = null;
    private Doctor model = null;
    
    /**
     *
     * @param homeView
     */
    public void setHomeView(DoctorHome homeView){
        System.out.println("setHomeView method in DoctorController was called.");
        this.homeView = homeView;
    }

    /**
     *
     * @param feedbackView
     */
    public void setFeedbackView(DoctorFeedback feedbackView){
        this.feedbackView = feedbackView;
    }

    /**
     *
     * @param patientsView
     */
    public void setPatientsView(DoctorPatients patientsView){
        this.patientsView=patientsView;
    }

    /**
     *
     * @param model
     */
    public void setModel(Doctor model){
        System.out.println("setModel method in DoctorController was called.");
        this.model=model;
    }
    
}
