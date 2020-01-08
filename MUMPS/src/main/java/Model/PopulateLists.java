
package Model;
import Model.InteractWithXML;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
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
        String[] allPatients = new String[]{};
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
        String[] allDoctors = new String[]{};
        allDoctors = InteractWithXML.getAllDoctorNames();
        DefaultComboBoxModel drpDoctorsItems = new DefaultComboBoxModel(allDoctors);
        //Put the array into the box.
        return drpDoctorsItems;
    }
    
    /**
     * Make a combobox model to put the names of medicines into a combobox on the JFrame.
     * @return the array of names.
     */
    public static DefaultComboBoxModel PopulateMedicinesList(){
        String[] allMeds = new String[]{};
        allMeds = InteractWithXML.getAllMedicineNames();
        DefaultComboBoxModel drpMedsItems = new DefaultComboBoxModel(allMeds);
        //Put the array into the box.
        return drpMedsItems;
    }
    /* Try a table format
    public static DefaultTableModel PopulateDoctorsTable(){
        Object[][] allDoctorInfo = new Object[][]{};
        allDoctorInfo = 
    }
    */
}
