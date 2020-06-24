/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.api;

import com.database.bank.RegisterData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aravindh
 */
public class Transactions 
{
   public ArrayList<Transaction> transactionList =  new ArrayList<>();
   public ArrayList<Transaction> currentList = new ArrayList<>();
   
   public ArrayList<Transaction> getTransaction( ResultSet rs ) throws SQLException 
   {
       while ( rs.next() )
       {
           Transaction t = new Transaction();
           t.fromAcc = rs.getString(1 );
           t.toAcc = rs.getString( 2 );
           t.amount = rs.getLong( 3);
           t.transactionDate = rs.getDate( 4 );
           t.status = rs.getBoolean(5 );
           t.id = rs.getString(6);
           this.transactionList.add (t);
       }
       return this.transactionList;
   }
   public ArrayList<Transaction> getCustomerTransaction (String accountNUumber) throws SQLException
   {
      
       for ( Transaction t : this. transactionList )
       {
           if ( t.fromAcc.equals( accountNUumber ) || t.toAcc.equals( accountNUumber ) )
           {
               this.currentList.add ( t );
           }
       }
       return this.currentList;
   }
    public int getCount() throws SQLException
    {
        int count ;
        
        this.getTransaction(RegisterData.getTransaction());
        count = this.transactionList.size();
        
        return count;
    }
}
