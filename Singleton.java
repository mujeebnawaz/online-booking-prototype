/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw;

/**
 *
 * @author mn3458z
 */
public class Singleton {
    
    private Singleton(){
        //Private constructor so singleton class cannot be re-instantiated 
    }
    public static DatabaseMain databaseInstance(){
        DatabaseMain instance = null; //Sets the instance to null
        if(instance == null){ //checks if the instance is null 
            instance = new DatabaseMain(); //instantiates the database class if instance is null
        } 
        return instance; // returns the instance
    }
}
