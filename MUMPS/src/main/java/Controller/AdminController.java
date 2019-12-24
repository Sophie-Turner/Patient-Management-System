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
        System.out.println("setHomeView method in AdminController was called.");
        this.homeView = homeView;
    }
    public void setModel(Administrator model){
        System.out.println("setModel method in AdminController was called.");
        this.model = model;
    }
}
