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
 * @author Toothless
 */
public class Cart {
    ArrayList itemsInCart = new ArrayList(); //Contains all existing items in the cart
    public int addToCart(int tripId){ //public method, adds item in the cart and return the updated value
        itemsInCart.add(tripId+1); //adds trip id to the cart array
        return itemsInCart.size(); //returns the size of the arraylist in integer
    }
    public int deleteItem(int tripId){ //method for deleting the item
        Iterator cartItemsIterator = itemsInCart.iterator(); //Iterator for the user cart
        while(cartItemsIterator.hasNext()){ //loops for each element of the cart
            if(Integer.parseInt(cartItemsIterator.next().toString()) == tripId){ //checks if any element has corresponding trip id
                itemsInCart.remove(this); //removes the element 
            }
        }
        return itemsInCart.size(); //returns the updated size
    }
    public ArrayList showCartItems(){ //returns the cart items
        Iterator cartItemsIterator = itemsInCart.iterator(); 
        ArrayList<ResultSet> results = new ArrayList(); 
        MainTrip trips = new MainTrip();
        while(cartItemsIterator.hasNext()){
            results.add(trips.getTripById(Integer.parseInt(cartItemsIterator.next().toString()))); //gets the results from the database via MainTrip
        }
        return results;
    }
}
