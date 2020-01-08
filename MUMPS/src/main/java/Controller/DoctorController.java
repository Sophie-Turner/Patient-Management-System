
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
     * sets view as the main Jframe for doctors to see.
     * @param homeView the view which shows the main JFrame for doctors. 
     */
    public void setHomeView(DoctorHome homeView){
        System.out.println("setHomeView method in DoctorController was called.");
        this.homeView = homeView;
    }

    /**
     *  
     * @param feedbackView this is the JFrame where doctors can look at their own feedback.
     */
    public void setFeedbackView(DoctorFeedback feedbackView){
        this.feedbackView = feedbackView;
    }

    /**
     *
     * @param patientsView The JFrame where doctors can look at patients' information.
     */
    public void setPatientsView(DoctorPatients patientsView){
        this.patientsView=patientsView;
    }


    public void setModel(Doctor model){
        System.out.println("setModel method in DoctorController was called.");
        this.model=model;
    }
    
}
