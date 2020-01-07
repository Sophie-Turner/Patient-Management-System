/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Administrator;
import View.AdminHome;
/**
 *
 * @author pipin
 */
public class AdminController {
    private AdminHome homeView = null;
    private Administrator model = null;
    
    public void setHomeView(AdminHome homeView){
        
        this.homeView = homeView;
    }
    public void setModel(Administrator model){

        this.model = model;
    }
}
