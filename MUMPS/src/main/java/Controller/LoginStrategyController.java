/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.Login;
import Model.User;
/**
 *
 * @author pipin
 */
public class LoginStrategyController implements ActionListener{
    private Login view = null;
    private User model = null;
    
    public void setView(Login view){
        this.view = view;
    }
    public void setModel(User model){
        this.model = model;
    }
    
    @Override //when the user clicks the login button.
    public void actionPerformed(ActionEvent clickLogin){
        
        String userId = view.getUsername();
        String password = view.getPassword();
        model.selectStrategy(userId, password);
        model.completeLogin();
        System.out.println("Login strategy controller worked.");
    }
}
