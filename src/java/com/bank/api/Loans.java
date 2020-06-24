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
public class Loans 
{
    public ArrayList<Loan> loanList = new ArrayList<>();
    
    
     public  ArrayList<Loan> getLoanList(ResultSet rs) throws SQLException
    {
         
        while( rs.next() )
       {
             Loan loan = new Loan();
             loan.loanAccountNumber = rs.getString (1);
             loan.customer.customerId = rs.getString( 2 );
             loan.totalAmount =  rs.getLong( 3 );
             loan.paidAmount = rs.getLong( 4 );
             loan.intrest = rs.getDouble( 5 );
             loan.status = rs.getBoolean( 6 );
              
              this.loanList.add ( loan );             
       }
        return this.loanList;
    }
    public int getCount() throws SQLException
    {
        int count ;
        
        this.getLoanList( RegisterData.getLoanList()  );
        count = this.loanList.size();
        
        return count;
    }
}
