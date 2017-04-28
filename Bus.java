/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw;

/**
 *
 * @author Toothless
 */
public class Bus {
    private int busId;
    private int busCapacity;
    private TripDB tripDatabase = new TripDB();
    
    
    
    public void setBusId(int busI){
        busId = busI;
    }
    public void setBusCapacity(int busC){
        busCapacity = busC;
    }
}
