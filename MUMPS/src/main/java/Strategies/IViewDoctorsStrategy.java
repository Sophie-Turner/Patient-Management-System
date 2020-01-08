/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategies;

/**
 * Interface for the different users (patients and admins) viewing doctors because they may have different permissions to view things.
 * <p>This can be removed later if it turns out that it's not required.</p>
 * @author pipin
 */
public interface IViewDoctorsStrategy {


    public void ViewDoctors(); //pass in user type?
}
