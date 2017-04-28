/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author mn3458z
 */
public class UserDB {
    private String table = null;
    private String column = null;
    private String values = null;
    private String query = null;
    private String sql;
    DatabaseMain database = Singleton.databaseInstance();
    public ResultSet getAllUser(){
        sql = "SELECT * FROM [user]";
        return database.executeSelect(sql); //executes the select statement
    }
    public ResultSet getUserInfo(int id){
        sql = "SELECT * FROM [user] WHERE id = "+id;
        return database.executeSelect(sql); //executes the select statement
    }
    public boolean insertUser(ArrayList userDetails,int level){ 
        boolean insert = false; //Execution result flag
        if(userDetails.size() == 8){ // Checks if the given array has all the required values
        sql = "INSERT INTO [user] (firstname,lastname,username,password,email,dateofbirth,address,phone,userlevel) VALUES ("
                +"'"+userDetails.get(0)+"',"  //First Name, String
                +"'"+userDetails.get(1)+"',"  //Last Name, String
                +"'"+userDetails.get(2)+"',"  //Username, String
                +"'"+userDetails.get(3)+"',"  //Password, String
                +"'"+userDetails.get(4)+"',"  //Email, String
                +"'"+userDetails.get(5)+"',"  //Date OF Birth, String
                +"'"+userDetails.get(6)+"',"  //Address, String
                +"'"+userDetails.get(7)+"',"  //Phone, String
                +level+")";//Level, Integer
        insert = database.executeUpdate(sql); // Executes the query, and stores the status flag on insert
        }
        return insert;             
    }
    public int getUser(int type,String username, String password){ //Returns either Id of user or Level of user using given set of username and password
        //type 1 refers to user level, type 0 refers to user id
        if(type == 1){  //if given type is 1, requests for user level
            sql = "SELECT user.level FROM [user] WHERE username = '"+username+"' AND password = '"+password+"'";
        }
        else { //else request user Id
            sql = "SELECT user.id FROM [user] WHERE username = '"+username+"' AND password = '"+password+"'";
        }
        int authenticated = -1; //authentication flag, -1 by default
        ResultSet user = database.executeSelect(sql); //Executes request
        try{ //try catch block for reading the response from database
            if(user.next()){  // checks and moves the response pointer to first row of Result Set
                authenticated = user.getInt(1); // changes the authenticated flag to id or level depending on the request
            }
        }
        catch(Exception e){
            e.printStackTrace(); // prints exception trace
        }
        return authenticated; //returns the authentication flag, -1 shows an error with the query.
    }
    public boolean editUser(ArrayList userDetails,int id){
        if(userDetails.size() == 9){
                sql = "UPDATE [user] SET "
                + "firstname = '"+ userDetails.get(0) +"',"  //First Name, String
                + "lastname = '" + userDetails.get(1) +"',"  //Last Name, String
                + "username = '" + userDetails.get(2) +"',"  //Username, String
                + "password = '" + userDetails.get(3) +"',"  //Password, String
                + "email = '" + userDetails.get(4) +"',"     //Email, String
                + "dateofbirth = '" + userDetails.get(5) +"'," //Date OF Birth, String
                + "address = '" + userDetails.get(6) +"',"   //Address, String
                + "phone = '" + userDetails.get(7) +"',"     //Phone, String
                + "userlevel = '" + userDetails.get(8) +"'" //Level, Integer
                + " WHERE ID = "+id;
        }
        return database.executeUpdate(sql);
    }
    public boolean addEnquiry(String enquiry, int userId){
        sql = "INSERT INTO [enquiry] (Enquiry, userId) Values ('"+enquiry+"',"+userId+")";
        return database.executeUpdate(sql);
    }
    public boolean writeReview(String review, int tripId, int userId){
        sql = "INSERT INTO [review] (review, userId, tripId) Values ('"+review+"',"+tripId+","+userId+")";
        return database.executeUpdate(sql);
    }
    public boolean addBooking(int tripid, int userid){
        sql = "INSERT INTO [booking] (tripid, userid, adulttickets) VALUES("+tripid+","+userid+",1)";
        return database.executeUpdate(sql);
    }
    public ResultSet getBooking(int userid){
        sql = "SELECT t.tripid, t.departure, t.duration, t.description,t.adultprice FROM trip t, booking b WHERE t.tripid = b.tripid AND b.userid ="+userid;
        return database.executeSelect(sql);
    }
    
}
