package com.bank.api;

import com.database.bank.RegisterData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aravindh
 */
public class Accounts 
{
    public ArrayList<Account> accountList = new ArrayList<>();
   
    
    public void addaccount(Account account)
    {
        this.accountList.add(account);
    }
    public Account getAccount(String accountNumber)
    {
        Account searchAccount=null;
        for(Account a : this.accountList)
        {
            if(a.accountnumber.equalsIgnoreCase(accountNumber))
            {
                searchAccount=a;
            }
        }
        return searchAccount;
    }
    public Account getAccountWithID(String customer_id)
    {
        Account searchAccount=null;
        for(Account a : this.accountList)
        {
            if(a.customer.customerId.equalsIgnoreCase(customer_id))
            {
                searchAccount=a;
            }
        }
        return searchAccount;
    }
     public  ArrayList<Account> getAccountList(ResultSet rs) throws SQLException
    {
         if ( rs!=null )
         {
              while( rs.next() )
       {
              Account account =new Account();
              account.setAccountBalance( rs.getDouble(7));
              account.branchDetails.ifsc_code = rs.getString(1);
              account.pin = rs.getString(2);
              account. customer.name= rs.getString(3);
              
              account.customer.customerId=rs.getString(4);
              System.out.print(account. customer.name+account.customer.customerId);
              account.accountnumber=rs.getString(5);
              account.doj=rs.getDate(6);
              this.accountList.add(account);             
       }
         }
         
       
        return this.accountList;
    }
      public  ArrayList<Account> getAccountApplication(ResultSet rs) throws SQLException
    {
         if ( rs!=null )
         {
              while( rs.next() )
       {
              Account account =new Account();
             
              account.branchDetails.ifsc_code = rs.getString(1);
              account.pin = rs.getString(2);
              account. customer.name= rs.getString(3);
              account.accountnumber = rs.getString(7);
              account.customer.customerId=rs.getString(4);
             
              account.status=rs.getBoolean(6);
              account.doj=rs.getDate(5);
              this.accountList.add(account);             
       }
         }
         
       
        return this.accountList;
    }
    public int getCount() throws SQLException
    {
        int count = 0;
        if ( RegisterData.getAccount()!=null )
        {
         this.getAccountList( RegisterData.getAccount() );
        count = this.accountList.size();
        }
        
       
        
        return count;
    }
}
