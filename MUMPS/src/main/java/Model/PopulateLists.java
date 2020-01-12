
package Model;
import Model.InteractWithXML;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
/**
 *
 * @author pipin
 * Retrieves info from interactWithXML class and puts it into required formats.
 * <p>
 * Use interface or proper design pattern for this later.
 * Could use factory pattern.
 *</p>
 */
public class PopulateLists {
    //Use interface or design pattern for this later. See diagrams/ideas in my blue soft252 note book.  
    //Return model

    /**
     * Make a combobox model to put the names of patients into a combobox on the JFrame.
     * @return the array of names.
     */
    public static DefaultComboBoxModel PopulatePatientsList(){
        String[] allPatients;
        allPatients = InteractWithXML.getAllPatientNames();
        //Put the patients' names into the array.
        DefaultComboBoxModel drpPatientsItems = new DefaultComboBoxModel(allPatients);
        //Put the array into the box.
        return drpPatientsItems;
    }
    
    /**
     * Make a combobox model to put the names of doctors into a combobox on the JFrame.
     * @return the array of names.
     */
    public static DefaultComboBoxModel PopulateDoctorsList(){
        String[] allDoctors;
        allDoctors = InteractWithXML.getAllDoctorNames();
        DefaultComboBoxModel drpDoctorsItems = new DefaultComboBoxModel(allDoctors);
        //Put the array into the box.
        return drpDoctorsItems;
    }
    
    /**
     * Make a combobox model to put the names of medicines into a combobox on the JFrame.
     * @return the array of names as a combo box model.
     */
    public static DefaultComboBoxModel PopulateMedicinesList(){
        String[] allMeds;
        allMeds = InteractWithXML.getAllMedicineNames();
        DefaultComboBoxModel drpMedsItems = new DefaultComboBoxModel(allMeds);
        //Put the array into the box.
        return drpMedsItems;
    }
    
    /**
     * Make a list model to show doctors their own feedback.
     */    
        public DefaultListModel PopulateFeedbackList(){
        //String whichDoctor = Doctor.getUserId(); 
        //Test it with this doctor.
        String whichDoctor = "D0001";
        
        String[] oneDocFeedback;
        oneDocFeedback = InteractWithXML.getOneDoctorComments(whichDoctor);
        DefaultListModel lstDoctorFeedback = new DefaultListModel();
        for(int i =0; i<oneDocFeedback.length;i++){
            lstDoctorFeedback.addElement(oneDocFeedback[i]);
        }        
        return lstDoctorFeedback;
    }

        public static DefaultTableModel PopulateFeedbackTable(){        
        String[] headers = new String[]{"Doctor's name", "Average rating", "Comments"};
        String[][] data = InteractWithXML.getDoctorFeedbackObject();
        DefaultTableModel feedbackTable = new DefaultTableModel(data, headers);
        return feedbackTable;
    }
}
