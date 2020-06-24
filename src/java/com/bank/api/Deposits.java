
package com.bank.api;

import com.database.bank.RegisterData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aravindh
 */
public class Deposits 
{
    public ArrayList<Deposit>  depositList = new ArrayList<>();
    
    public  ArrayList<Deposit> getDepositList(ResultSet rs) throws SQLException
    {
         
        while( rs.next() )
       {
           Deposit deposit = new Deposit();
           deposit.depositAccountNumber = rs.getString( 1 );
           deposit.customer.customerId = rs.getString( 2 );
           deposit.totalAmount = rs.getLong( 3 );
           deposit.paidAmount = rs.getLong( 4 );
           deposit.intrest = rs.getDouble( 5 );
           deposit.status = rs.getBoolean( 6 );  
           this.depositList.add  ( deposit );             
       }
        return this.depositList;
    }
    public Deposit getDepositWithID(String customer_id)
    {
        Deposit searchAccount=null;
        for(Deposit d : this.depositList)
        {
            if(d.customer.customerId.equalsIgnoreCase(customer_id))
            {
                searchAccount=d ;
            }
        }
        return searchAccount;
    }
    public int getCount() throws SQLException
    {
        int count ;
        
        this.getDepositList( RegisterData.getDeposit()  );
        count = this.depositList.size();
        
        return count;
    }
}
