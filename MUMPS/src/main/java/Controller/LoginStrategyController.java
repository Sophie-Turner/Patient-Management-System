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
        System.out.println("Click registered in the login strategy controller.");
        String userId = view.getUsername();
        String password = view.getPassword();
        view.clearAll();
        model.completeLogin(userId, password);
       
    }
}
