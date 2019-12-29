/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.InteractWithXML;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author pipin
 */
public class PopulateLists {
    //Use interface or design pattern for this later.
    
    //Return model
    public static DefaultComboBoxModel PopulatePatientsList(){
        String[] allPatients = new String[]{};
        allPatients = InteractWithXML.getAllPatientNames();
        //Put the patients' names into the array.
        DefaultComboBoxModel drpPatientsItems = new DefaultComboBoxModel(allPatients);
        //Put the array into the box.
        return drpPatientsItems;
    }
    
    public static DefaultComboBoxModel PopulateDoctorsList(){
        String[] allDoctors = new String[]{};
        allDoctors = InteractWithXML.getAllDoctorNames();
        DefaultComboBoxModel drpDoctorsItems = new DefaultComboBoxModel(allDoctors);
        //Put the array into the box.
        return drpDoctorsItems;
    }
    
    public static DefaultComboBoxModel PopulateMedicinesList(){
        String[] allMeds = new String[]{};
        allMeds = InteractWithXML.getAllMedicineNames();
        DefaultComboBoxModel drpMedsItems = new DefaultComboBoxModel(allMeds);
        //Put the array into the box.
        return drpMedsItems;
    }
    /*
    public static DefaultTableModel PopulateDoctorsTable(){
        Object[][] allDoctorInfo = new Object[][]{};
        allDoctorInfo = 
    }
    */
}
