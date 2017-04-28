/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw;
import java.sql.*;
/**
 *
 * @author mn3458z
 */
public class DatabaseMain {
    Connection  connectionObject = null; //openconnection() sets a reference in this variable
    //Uses "ucanaccess" library to establish the connection
    private void openConnection(){ //opens connection to the database using jdbc 
        String databasePath = "jdbc:ucanaccess:///Users/Toothless/Desktop/m/sdp_dy.mdb"; //path to database
        try { //try catch block for catching exceptions thrown by driver
            
            connectionObject = DriverManager.getConnection(databasePath); //establishes the connection to the database
        } catch (Exception e) {
            e.printStackTrace(); //prints the StackTrace
	}
    }
    private void closeConnection(){ // method for closing the connection
        try{ // try catch block for handling the exceptions thrown by database driver
            if(connectionObject != null){
                 connectionObject.close(); //closes the connection 
            }
        }
        catch(Exception e){
            e.printStackTrace(); //prints the stack trace
        }
    }
    public ResultSet executeSelect(String query){
        ResultSet resultSet = null;
        try{
            openConnection(); 
            if(connectionObject != null){
                Statement statement = connectionObject.createStatement();
                resultSet = statement.executeQuery(query);
            }
            closeConnection();
        }
        catch (Exception e){
            e.printStackTrace(System.out);
        }
        return resultSet;
    }
    public boolean executeUpdate(String query){
        boolean resultSet = true;
        try{
            openConnection(); 
            if(connectionObject != null){
                Statement statement = connectionObject.createStatement();
                resultSet = statement.execute(query);
            }
            closeConnection();
        }
        catch (Exception e){
            e.printStackTrace(System.out);
        }
        return !resultSet;
    }
}
