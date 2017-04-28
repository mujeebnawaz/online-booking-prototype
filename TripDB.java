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
 * @author Toothless
 */
public class TripDB {
    private String sql; //common query variable
    DatabaseMain database = Singleton.databaseInstance(); //gets the instance of database
    
    public boolean addTrip(ArrayList tripDetails){
        boolean insert = false; //Execution result flag
        if(tripDetails.size() == 8){ // Checks if the given array has all the required values
        sql = "INSERT INTO [trip] (busid,locationid,departure,duration,adultprice,childprice,description,reviews) VALUES ("
                +"'"+tripDetails.get(0)+"',"  //
                +"'"+tripDetails.get(1)+"',"  
                +"'"+tripDetails.get(2)+"',"  
                +"'"+tripDetails.get(3)+"',"  
                +"'"+tripDetails.get(4)+"',"  
                +"'"+tripDetails.get(5)+"',"  
                +"'"+tripDetails.get(6)+"',"  
                +"'"+tripDetails.get(7)+"')";  
        insert = database.executeUpdate(sql); // Executes the query, and stores the status flag on insert
        }
        return insert; 
    }
    /* Geters and setters for the database operations */
    public ResultSet getTrip(int tripId){
        sql = "SELECT t.tripid, t.departure, t.duration, t.description,t.adultprice,l.locationname FROM trip t, location l, reviews r WHERE t.locationid = l.locationid AND t.tripid = r.tripId AND t.tripid = "+tripId;
        return database.executeSelect(sql);
    }
    public ResultSet getTrips(String keyword){
        sql = "SELECT r.review, t.tripid, t.departure, t.description,t.adultprice,l.locationname FROM trip t, location l, reviews r WHERE t.locationid = l.locationid AND t.tripid = r.tripId AND locationname LIKE '%"+keyword+"%'";
        return database.executeSelect(sql);
    }
    public ResultSet getTrips(){
        sql = "SELECT r.review, t.tripid, t.departure, t.description,t.adultprice,l.locationname FROM trip t, location l, reviews r WHERE t.locationid = l.locationid AND t.tripid = r.tripId";
        return database.executeSelect(sql);
        
    }
    public ResultSet getLocation(int id){
        sql = "SELECT Country/City FROM [location] WHERE locationid = "+id;
        return database.executeSelect(sql);
    }
    public void getBusMeta(){
        sql = "SELECT * FROM Bus ";
    }
}
