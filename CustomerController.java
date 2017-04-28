/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Toothless
 */
public class CustomerController {
         Customer newCustomer = new Customer();
         MainTrip trips = new MainTrip();
    public void getLogin(String username, String password){
        newCustomer.loginUser(username, password);
    }
    public static CustomerController controllerInstance(){
        CustomerController instance = null;
        if(instance == null){
            instance = new CustomerController();
        }
        return instance;
    }
    public ResultSet getBrowse(){
       return trips.browseTrips();
    }
    public int getRows(ResultSet r){
        int i = 0;
             try {
                 while(r.next()){
                     i++;
                 }    } catch (SQLException ex) {
                 Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
             }
             return i;
    }
    public ResultSet getBrowse(String keyword){
        return trips.browseTrips(keyword);
    }
}
