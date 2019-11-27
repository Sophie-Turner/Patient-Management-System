/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Secretary;
import View.SecretaryHome;
import View.SecretaryPatients;
import View.Login;
/**
 *
 * @author pipin
 */
public class SecretaryController {
    private SecretaryHome homeView = null;
    private SecretaryPatients patientsView = null;
    private Secretary model = null;
    private Login loginView = null;
    
    public void setHomeView(SecretaryHome homeView){
        this.homeView = homeView;
        this.loginView.dispose();
    }
    
    public void setPatientsView(SecretaryPatients patientsView){
        this.patientsView = patientsView;
    }
    
    public void setModel(Secretary model){
        this.model = model;
    }
}
