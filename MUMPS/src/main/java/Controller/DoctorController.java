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
 */
public class DoctorController {
    private DoctorHome homeView = null;
    private DoctorFeedback feedbackView = null;
    private DoctorPatients patientsView = null;
    private Doctor model = null;
    
    public void setHomeView(DoctorHome homeView){
        System.out.println("setHomeView method in DoctorController was called.");
        this.homeView = homeView;
    }
    public void setFeedbackView(DoctorFeedback feedbackView){
        this.feedbackView = feedbackView;
    }
    public void setPatientsView(DoctorPatients patientsView){
        this.patientsView=patientsView;
    }
    public void setModel(Doctor model){
        System.out.println("setModel method in DoctorController was called.");
        this.model=model;
    }
    
}
