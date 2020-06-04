package com.bank.api;

import java.util.ArrayList;

/**
 *
 * @author Aravindh
 */
public class Customers 
{
    ArrayList<Customer>    customerList=new ArrayList<>();
    Accounts accounts=new Accounts();
    public void addCustomer(Customer customer)
    {
       this.customerList.add(customer);
    }
    public Customer getCustomer(String accountNumber)
    {
        Customer searchCustomer=null;
        for(Customer c: this.customerList)
        {
            if( accounts.getAccount(accountNumber)!=null  )
            {
                searchCustomer=c;
            }
        }
        return searchCustomer;
    }
}
