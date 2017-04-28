/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author st8511x
 */
public class User {
    protected int id; //User id attribute, type integer
    protected long phone; //User phone attribute of type long
    protected String firstname, lastname, username, password, email, dateofbirth, address; //User attributes of type String
    protected UserDB userdb = new UserDB(); //instantiates UserDB class for a persistent connection to the database via DatabaseMain
    
    Cart userCart = new Cart();
    
    protected boolean is_logged = false; // boolean variable to verify if user is logged in, limited access to child classes
    protected boolean is_admin = false;  // boolean variable to verify if user is admin, limited access to child classes
    protected boolean is_manager = false;// boolean variable to verify if user is manager, limited access to child classes
    protected boolean is_customer = false;// boolean variable to verify if user is customer, limited access to child classes
            
    protected void userInnit(int userId){
        ResultSet userInfo = userdb.getUserInfo(userId); //fetches the ResultSet from Database via UserDB class
        try{
            if(userInfo.next()){ //moves the ResultSet pointer to the first Row of the Result Set
                //fetches and stores all the User attributes from the database and stores it in the class variables
                id = userId;
                phone = Long.parseLong(userInfo.getString(9)); 
                username = userInfo.getString(4);
                firstname =  userInfo.getString(2);
                lastname = userInfo.getString(3);
                email = userInfo.getString(6);
                dateofbirth = userInfo.getString(7);
                address = userInfo.getString(8);
                if(userInfo.getInt(10) == 1){ //checks if user level is 1
                    is_admin = true; //turns the is_admin flag true 
                }
                else if(userInfo.getInt(10) == 2){ //checks if user level is 2 
                    is_manager = true; //turns the is_manager flag true
                }
            }
        }
        catch(Exception e){
           e.printStackTrace(); //Prints the exception details
        }
    }
    protected boolean loginUser(String username, String password){
        if(userdb.getUser(0, username, password) != -1){
            is_logged = true;
            userInnit(userdb.getUser(0, username, password));
        }
        return is_logged;
    }
    protected boolean editCustomerDetails(ArrayList userDetails){
        return userdb.editUser(userDetails, id);
    }
    protected boolean registerUser(ArrayList userDetails){
        return false;
    }
    public void addEnquiry(String Enquiry){
    if(is_logged){
        userdb.addEnquiry(Enquiry, id);
    }
    }
    public void makeBooking(int trip){
        userdb.addBooking(trip, id);
    }
    public void addReview(int tripId, String Review){
        userdb.writeReview(Review, tripId, id);
    }
    protected void viewCusomterHistory(){
        
    }
}
