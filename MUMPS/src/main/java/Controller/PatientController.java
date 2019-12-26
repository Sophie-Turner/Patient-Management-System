/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Patient;
import View.PatientHome;
import View.PatientAppointments;
import View.FeedbackDoctors;
import View.PatientHistory;
import View.PatientPrescriptions;
/**
 *
 * @author pipin
 */
public class PatientController {
    private PatientHome homeView = null;
    private PatientAppointments apptView = null;
    private FeedbackDoctors feedbackView = null;
    private PatientHistory historyView = null;
    private PatientPrescriptions prescriptionView = null;
    private Patient model = null;
    
    public void setHomeView(PatientHome homeView){
        System.out.println("setHomeView method in PatientController was called.");
        this.homeView = homeView;
    }
    public void setApptView(PatientAppointments apptView){
        this.apptView = apptView;
    }
    public void setFeedbackView(FeedbackDoctors feedbackView){
        this.feedbackView = feedbackView;
    }
    public void setHistorytView(PatientHistory historyView){
        this.historyView = historyView;
    }
    public void setPrescriptionView(PatientPrescriptions prescriptionView){
        this.prescriptionView = prescriptionView;
    }
    public void setModel(Patient model){
        System.out.println("setModel method in PatientController was called.");
        this.model = model;
    }
}
