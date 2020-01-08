
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
    

    public void setHomeView(PatientHome homeView){
        System.out.println("setHomeView method in PatientController was called.");
        this.homeView = homeView;
    }

    /**
     *
     * @param apptView The JFrame where patients can book appointments.
     */
    public void setApptView(PatientAppointments apptView){
        this.apptView = apptView;
    }

    /**
     *
     * @param feedbackView The JFrame where patients can give feedback to doctors and view their ratings.
     */
    public void setFeedbackView(FeedbackDoctors feedbackView){
        this.feedbackView = feedbackView;
    }

    /**
     *
     * @param historyView The JFrame where patients can view their history.
     */
    public void setHistorytView(PatientHistory historyView){
        this.historyView = historyView;
    }

    /**
     *
     * @param prescriptionView The Jframe where patients can view their prescription.
     */
    public void setPrescriptionView(PatientPrescriptions prescriptionView){
        this.prescriptionView = prescriptionView;
    }

    public void setModel(Patient model){
        System.out.println("setModel method in PatientController was called.");
        this.model = model;
    }
}
