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
public class Admin extends User{
    private int level;

    private void sendRecommendations(){
    }
    private void makeDeals(){
    }
    protected boolean registerUser(ArrayList userDetails, int userLevel){
        return userdb.insertUser(userDetails, userLevel);
    }
    protected ResultSet listCustomers(){
        return userdb.getAllUser();
    }
    protected boolean editCustomerDetails(ArrayList userDetails,int userId){
        return userdb.editUser(userDetails, userId);
    }
}
