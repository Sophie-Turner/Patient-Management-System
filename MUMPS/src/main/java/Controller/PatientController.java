
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
 * Controller is between the model and the view
  * and interacts with them by setting the relevant model and view.
 */
public class PatientController {
    private PatientHome homeView = null;
    private PatientAppointments apptView = null;
    private FeedbackDoctors feedbackView = null;
    private PatientHistory historyView = null;
    private PatientPrescriptions prescriptionView = null;
    private Patient model = null;
    
    /**
     *
     * @param homeView
     */
    public void setHomeView(PatientHome homeView){
        System.out.println("setHomeView method in PatientController was called.");
        this.homeView = homeView;
    }

    /**
     *
     * @param apptView
     */
    public void setApptView(PatientAppointments apptView){
        this.apptView = apptView;
    }

    /**
     *
     * @param feedbackView
     */
    public void setFeedbackView(FeedbackDoctors feedbackView){
        this.feedbackView = feedbackView;
    }

    /**
     *
     * @param historyView
     */
    public void setHistorytView(PatientHistory historyView){
        this.historyView = historyView;
    }

    /**
     *
     * @param prescriptionView
     */
    public void setPrescriptionView(PatientPrescriptions prescriptionView){
        this.prescriptionView = prescriptionView;
    }

    /**
     *
     * @param model
     */
    public void setModel(Patient model){
        System.out.println("setModel method in PatientController was called.");
        this.model = model;
    }
}
