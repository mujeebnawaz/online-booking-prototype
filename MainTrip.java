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
public class MainTrip {
    protected int tripId;
    protected ArrayList allTrips;
    protected TripDB tripdb = new TripDB();
   
    public ResultSet browseTrips(){
        return tripdb.getTrips();
    }
    public ResultSet browseTrips(String locationName){
        return tripdb.getTrips(locationName);
    }
    public ResultSet getTripById(int id){
        return tripdb.getTrip(id);
    }
}
