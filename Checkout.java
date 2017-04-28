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
public class Checkout extends Cart{
   public double getTotal(ArrayList x){
          int p = 0;
          double total = 0;
          while(p < x.size()){    
            ResultSet o = (ResultSet) x.get(p);
            
            try{
               while(o.next()){
                   total = total + o.getInt("adultprice");  
                }
            }
                catch(Exception e){}
                p++;
            }
          return total;
   }
   
}
