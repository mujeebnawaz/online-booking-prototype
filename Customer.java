/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author st8511x
 */
public class Customer extends User{
  
  
    private void sendRecommendations(){
    }
    private void makeDeals(){
    }
    public void makeEnquiry(String Enquiry){
        userdb.addEnquiry(Enquiry, id);
    }
    public void makeBooking(){
        Iterator cartI = userCart.itemsInCart.iterator();
        while(cartI.hasNext()){
            userdb.addBooking(id, Integer.parseInt(cartI.next().toString()));
        }
    }
    public ResultSet getBooking(){
        return userdb.getBooking(id);
    }
    public void generateTicket(){
    
    }
    
    @Override 
    protected boolean registerUser(ArrayList userDetails){
        return userdb.insertUser(userDetails, 0);
    }
}
