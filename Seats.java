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
public class Seats {
    private int totalNumberOfSeats;
    private int totalWindowSeats;
    private int totalAisleSeats;
    
    public String getSeatNumber(int busId){
        String seatNumber;
        String seatType = null;
        seatNumber = (totalWindowSeats+totalAisleSeats)+seatType;       
        return seatNumber;
    }
} 
