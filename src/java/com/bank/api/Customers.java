package com.bank.api;

import com.database.bank.RegisterData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aravindh
 */
public class Customers 
{
    public ArrayList<Customer>    customerList=new ArrayList<>();
    public  ArrayList<Customer>    employeeList=new ArrayList<>();
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
    public Customer getCustomerWithID(String customer_id)
    {
        Customer searchCustomer=null;
        for(Customer c: this.customerList)
        {
            if( c.customerId.equalsIgnoreCase(customer_id)  )
            {
                searchCustomer=c;
            }
        }
        return searchCustomer;
    }
   public  ArrayList<Customer> getEmployeeList(ResultSet rs) throws SQLException
    {
       
        while( rs.next() )
       {
              Customer customer =new Customer();
              customer.name=(rs.getString("username"));
              customer.password=rs.getString("password");
              customer.email=rs.getString("email");
              
              this.employeeList.add(customer);
       }
       
        return this.employeeList;
    }
   public  ArrayList<Customer> getCustomerList(ResultSet rs) throws SQLException
    {
        while( rs.next() )
       {
              Customer customer =new Customer();
              customer.name=(rs.getString(1));
              customer.password=rs.getString(3);
             customer.address = rs.getString(6);
             customer.phoneNumber = rs.getLong(5);
             customer.nationality = rs.getString(7);
              customer.email=rs.getString(2);
                customer.customerId=rs.getString(4);
                customer.gender=rs.getString(8);
                customer.dob=rs.getDate(9);
              this.customerList.add(customer);
       }
        return this.customerList;
    }
    public boolean isEmployee(String name,String password) throws SQLException
    {
        boolean isEmp=false;
        this.employeeList=getEmployeeList(RegisterData.getEmployee());
        for(Customer cust:  this.employeeList)
        {
           if(cust.name.equals(name) && cust.password.equals(password))
           {
               isEmp = true;
           }
        }
        return isEmp;
    }
    public boolean isCustomer(String name,String password) throws SQLException
    {
        boolean isCust=false;
        for(Customer cust: getCustomerList( RegisterData.getCustomer()))
        {
           if(cust.customerId.equalsIgnoreCase(name) && cust.password.equals(password))
           {
               isCust = true;
           }
        }
        return isCust;
    }
    public int getCount() throws SQLException
    {
        int count = 0;
        
        this.getCustomerList(RegisterData.getCustomer());
        count = this.customerList.size();
        
        return count;
    }
    
     public Customer getUniqueCustomer( String customer_id) throws SQLException
    {
        Customer customer = new Customer();
        this.getCustomerList(RegisterData.getCustomer());
        for ( Customer c : this.customerList)
        {
            if ( customer_id.equalsIgnoreCase(c.customerId) )
            {
                customer = c ;
            }
        }
        return customer;
    }
}
