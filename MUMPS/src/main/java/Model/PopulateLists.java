/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.InteractWithXML;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author pipin
 */
public class PopulateLists {
    //Use interface or design pattern for this later.
    
    //Receive the box and set model
    public void PopulatePatientsLists(javax.swing.JComboBox drp){
        //Parameter for which box we need to populate.
        String[] allPatients = new String[]{};
        allPatients = InteractWithXML.getAllPatientNames();
        //Put the patients' names into the array.
        DefaultComboBoxModel drpPatientsItems = new DefaultComboBoxModel(allPatients);
        //Put the array into the box.
        drp.setModel(drpPatientsItems);
        //Apply it.
    }
    
    //Return model
    public DefaultComboBoxModel PopulatePatientsList(){
        //Parameter for which box we need to populate.
        String[] allPatients = new String[]{};
        allPatients = InteractWithXML.getAllPatientNames();
        //Put the patients' names into the array.
        DefaultComboBoxModel drpPatientsItems = new DefaultComboBoxModel(allPatients);
        //Put the array into the box.
        return drpPatientsItems;
    }
}
