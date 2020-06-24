
package com.database.bank;

import com.bank.api.Account;
import com.bank.api.BankBranch;
import com.bank.api.Customer;
import com.bank.api.Deposit;
import com.bank.api.Transaction;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aravindh
 */
public  class RegisterData
{
    private static ResultSet rs=null;

    private static int addDepositt(Deposit deposit, String customer_id) 
    {
      int status;    
      try
      {  
    	  
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement("insert into depositaccount values(?,?,?,?,?,?)");  
        ps.setString(1,deposit.depositAccountNumber);
        ps.setString(2, deposit.customer.customerId);
        ps.setLong(3, deposit.totalAmount);
        ps.setLong(4, deposit.paidAmount);
        ps.setDouble(5,  deposit.intrest);
        ps.setBoolean(6,true);
       
       ps.executeUpdate();
       
       con.commit();
      
       status=1;
      }
      catch( SQLException e)
      {
          status=0;
          e.printStackTrace();
      }
      
      return status;
    }
   Connection con;
   public static int approveAccountRequest(  Account account,Customer customer ,String customer_id )   throws SQLException
   {
        int status;    
      try
      {  
    	  
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement("delete from accountapplication where customer_id = ? " );  
        ps.setString(1, customer_id);
          RegisterData.updateCustomer(customer); RegisterData.addAccount(account, customer.name ,customer_id);
       ps.executeUpdate();
       
        status = 1;
        con.commit();
      }
      catch( SQLException e)
      {
          status=0;
          e.printStackTrace();
      }
      
      return status;
   }
   public static int approveDepositRequest(  Deposit deposit,Customer customer ,String customer_id )   throws SQLException
   {
        int status;    
      try
      {  
    	  
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement("delete from depositapplication where customer_id = ? " );  
        ps.setString(1, customer_id);
          RegisterData.updateCustomer(customer); RegisterData.addDepositt(deposit, customer_id);
       ps.executeUpdate();
       
        status = 1;
        con.commit();
      }
      catch( SQLException e)
      {
          status=0;
          e.printStackTrace();
      }
      
      return status;
   }
    public static int denyDeposittRequest(  Customer customer )   throws SQLException
   {
       int status;    
      try
      {  
    	  
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement("delete from depositapplication where customer_id = ? " );  
        ps.setString(1, customer.customerId);
          
       ps.executeUpdate();
       
        status = 1;
        con.commit();
      }
      catch( SQLException e)
      {
          status=0;
          e.printStackTrace();
      }
      
      return status;
   }
    
     public static int denyAccountRequest(  Account account , Customer customer )   throws SQLException
   {
       int status;    
      try
      {  
    	  
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement("delete from accountapplication where customer_id = ? " );  
        ps.setString(1, customer.customerId);
          
       ps.executeUpdate();
       
        status = 1;
        con.commit();
      }
      catch( SQLException e)
      {
          status=0;
          e.printStackTrace();
      }
      
      return status;
   }
   public static int requestAccountApplication(  Account account , Customer customer )   throws SQLException
   {
        int status;    
      try
      {  
    	  
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement(" insert into accountapplication values(?,?,?,?,?,?,?)" );  
        ps.setString(1, account.branchDetails.getIfsc_code());
        ps.setString(2, account.pin);
        ps.setString(3, customer.name);
        ps.setString(4, customer.getCustomerId());
        ps.setDate(5, new java.sql.Date(account.doj.getTime()));

        ps.setBoolean( 6, false);
        ps.setString(7, account.accountnumber);
       ps.executeUpdate();
       
        status = 1;
        con.commit();
      }
      catch( SQLException e)
      {
          status=0;
          e.printStackTrace();
      }
      
      return status;
   }
    public static int requestDepositApplication(  Deposit deposit , Customer customer )   throws SQLException
   {
        int status;    
      try
      {  
    	  
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement("insert into depositapplication values(?,?,?,?,?,?)");  
        ps.setString(1,deposit.depositAccountNumber);
        ps.setString(2, deposit.customer.customerId);
        ps.setLong(3, deposit.totalAmount);
        ps.setLong(4, deposit.paidAmount);
        ps.setDouble(5,  deposit.intrest);
        ps.setBoolean(6,true);
       
       ps.executeUpdate();
       
       con.commit();
      
       status=1;
      }
      catch( SQLException e)
      {
          status=0;
          e.printStackTrace();
      }
      
      return status;
   }
    public static int addBranch( BankBranch  branch ) throws SQLException
   {  
      int status;    
      try
      {  
    	  
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement("insert into branchlist values(?,?,?)");  
        ps.setString(1,branch.getBranch_Name());
        ps.setString(2, branch.getIfsc_code());
        ps.setString(3, branch.getLocation());
       ps.executeUpdate();
       con.commit();
       status=1;
      }
      catch( SQLException e)
      {
          status=0;
      }
      
      return status;
   }
     public static int addAccount(Account account,String name ,String customerid) throws SQLException
      {  
      int status;    
      try
      {  
    	  
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement("insert into account values(?,?,?,?,?,?,?)");  
        ps.setString(1, account.branchDetails.getIfsc_code());
        ps.setString(2, account.pin);
        ps.setString(3, name);
        ps.setString(4, customerid);
        ps.setDate(6, new java.sql.Date(account.doj.getTime()));
        ps.setString(5, account.accountnumber);
        ps.setDouble(7, account.getAccountBalance());
       ps.executeUpdate();
       
              con.commit();
      
       status=1;
      }
      catch( SQLException e)
      {
          status=0;
          e.printStackTrace();
      }
      
      return status;
   }
      public static int addTransaction  (Transaction t) throws SQLException
      {  
      int status;    
      try
      {  
    	  
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement("insert into transactiondata values(?,?,?,?,?,?)");  
        ps.setString(1, t.getFromAcc());
        ps.setString(2, t.getToAcc());
        ps.setLong(3, t.getAmount());
        ps.setDate (4, new java.sql.Date (t.getTransactionDate().getTime() ));
        ps.setBoolean( 5 , t.isStatus());
        ps.setString( 6, t.getId() );
        
        ps.executeUpdate();
       
              con.commit();
      
       status=1;
      }
      catch( SQLException e)
      {
          status=0;
          e.printStackTrace();
      }
      
      return status;
   }
     public static int addAccount(Account account,Customer customer) throws SQLException
      {  
      int status;    
      try
      {  
    	  
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement("insert into account values(?,?,?,?,?,?,?)");  
        ps.setString(1, account.branchDetails.getIfsc_code());
        ps.setString(2, account.pin);
        ps.setString(3, customer.name);
        ps.setString(4, customer.getCustomerId());
        ps.setDate(6, new java.sql.Date(account.doj.getTime()));
        ps.setString(5, account.accountnumber);
        ps.setDouble(7, account.getAccountBalance());
       ps.executeUpdate();
       
       PreparedStatement ps1=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?)");  
        ps1.setString(1, customer.name);
        ps1.setString(2, customer.email);
        ps1.setString(3, customer.password);
        ps1.setString(4, customer.customerId);
        ps1.setLong(5, customer.phoneNumber);
        ps1.setString(6, customer.address);
        ps1.setString(7, customer.nationality);
         
        ps1.setString(8,customer.gender);
        ps1.setDate(9, new java.sql.Date(customer.dob.getTime()));
        ps1.executeUpdate();
       con.commit();
      
       status=1;
      }
      catch( SQLException e)
      {
          status=0;
          e.printStackTrace();
      }
      
      return status;
   }
        public static int addCustomerByAdmin(Customer customer) throws SQLException
      {  
      int status;    
      try
      {  
    	  
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?)");  
        ps.setString(1,customer.getName());
        ps.setString(2, customer.getEmail());
        ps.setString(3, customer.getPassword());
        ps.setString(4, customer.getCustomerId());
       ps.setLong(5,  customer.phoneNumber);
        ps.setString(6, customer.address);
        ps.setString(7, customer.nationality);
        ps.setString(8,customer.gender);
        ps.setDate(9, new java.sql.Date(customer.dob.getTime()));
       ps.executeUpdate();
       
       con.commit();
      
       status=1;
      }
      catch( SQLException e)
      {
          status=0;
          e.printStackTrace();
      }
      
      return status;
   }
    public static int addCustomer (Customer customer) throws SQLException
   {  
      int status;    
      try
      {  
    	  
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?)");  
        ps.setString(1,customer.getName());
        ps.setString(2, customer.getEmail());
        ps.setString(3, customer.getPassword());
        ps.setString(4, customer.getCustomerId());
        ps.setLong(5,  customer.phoneNumber);
        ps.setString(6, customer.address);
        ps.setString(7, customer.nationality);
        ps.setString(8,customer.gender);
        ps.setDate(9, null);
       ps.executeUpdate();
       
       con.commit();
      
       status=1;
      }
      catch( SQLException e)
      {
          status=0;
          e.printStackTrace();
      }
      
      return status;
   }
     public static int updateCustomer(Customer customer) throws SQLException
   {  
      int status;    
      try
      {  
     Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement psCustomer1 = con.prepareStatement("update  customer set name = ? where customer_id = ?"); 
        PreparedStatement psCustomer2 = con.prepareStatement("update  customer set email = ? where customer_id = ?");  
        PreparedStatement psCustomer3 = con.prepareStatement("update  customer set password = ? where customer_id = ?");  
        PreparedStatement psCustomer4 = con.prepareStatement("update  customer set phone = ? where customer_id = ?");  
        
        PreparedStatement psCustomer5 = con.prepareStatement("update  customer set address = ? where customer_id = ?");  
        PreparedStatement psCustomer6 = con.prepareStatement("update  customer set nationality = ? where customer_id = ?");  
        PreparedStatement psCustomer7 = con.prepareStatement("update  customer set dob = ? where customer_id = ?");  
         PreparedStatement psCustomer8 = con.prepareStatement("update  customer set gender = ? where customer_id = ?");  
        psCustomer1.setString(1,customer.name);psCustomer1.setString(2,customer.customerId);
      
        psCustomer2.setString(1, customer.email);psCustomer2.setString(2,customer.customerId);
        psCustomer3.setString(1, customer.password);psCustomer3.setString(2,customer.customerId);
        psCustomer4.setLong(1, customer.phoneNumber);psCustomer4.setString(2,customer.customerId);
        
        psCustomer5.setString(1, customer.address);psCustomer5.setString(2,customer.customerId);
        psCustomer6.setString(1, customer.nationality);psCustomer6.setString(2,customer.customerId);
        psCustomer7.setDate(1, new java.sql.Date(customer.dob.getTime() ) );psCustomer7.setString(2,customer.customerId);
       psCustomer8.setString(1, customer.gender);psCustomer8.setString(2,customer.customerId);
       
        psCustomer1.executeUpdate(); psCustomer2.executeUpdate(); psCustomer3.executeUpdate(); psCustomer4.executeUpdate();
        psCustomer5.executeUpdate(); psCustomer6.executeUpdate(); psCustomer7.executeUpdate();
       psCustomer8.executeUpdate();
       con.commit();
      
       status=1;
      }
      catch( SQLException e)
      {
          status=0;
          e.printStackTrace();
      }
      
      return status;
   }
     
      public static int addLoan(Account account,Customer customer) throws SQLException
      {  
      int status;    
      try
      {  
    	  
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement("insert into account values(?,?,?,?,?,?,?)");  
        ps.setString(1, account.branchDetails.getIfsc_code());
        ps.setString(2, account.pin);
        ps.setString(3, customer.name);
        ps.setString(4, customer.getCustomerId());
        ps.setDate(6, new java.sql.Date(account.doj.getTime()));
        ps.setString(5, account.accountnumber);
        ps.setDouble(7, account.getAccountBalance());
       ps.executeUpdate();
       
       
       con.commit();
      
       status=1;
      }
      catch( SQLException e)
      {
          status=0;
          e.printStackTrace();
      }
             return status;
      }
      
     public static int addAccountWithCustomer(Account account,Customer customer) throws SQLException
      {  
         int status;    
        try
         {  
    	  
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement("insert into account values(?,?,?,?,?,?,?)");  
        ps.setString(1, account.branchDetails.getIfsc_code());
        ps.setString(2, account.pin);
        ps.setString(3, customer.name);
        ps.setString(4, customer.getCustomerId());
        ps.setDate(6, new java.sql.Date(account.doj.getTime()));
        ps.setString(5, account.accountnumber);
        ps.setDouble(7, account.getAccountBalance());
       ps.executeUpdate();
       
       
       con.commit();
      
       status=1;
         }
      catch( SQLException e)
      {
          status=0;
          e.printStackTrace();
      }
      return status;
   }
     public static  ResultSet getLoanList() throws SQLException
     {
          try
       {    
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        PreparedStatement ps=con.prepareStatement("select * from loanaccount");  
        rs =  ps.executeQuery();
        con.commit();
       }
      catch( SQLException e)
      {
          
      }
        
        return rs;
     }
      public static  ResultSet getDeposit() throws SQLException
     {
          try
       {    
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        PreparedStatement ps=con.prepareStatement("select * from depositaccount");  
        rs =  ps.executeQuery();
        con.commit();
       }
      catch( SQLException e)
      {
          
      }
        
        return rs;
     }
    public static ResultSet getEmployee() throws SQLException
    {
        try
       {    
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        PreparedStatement ps=con.prepareStatement("select * from employee");  
        rs =  ps.executeQuery();
        con.commit();
        
       }
      catch( SQLException e)
      {
          
      }
        
        return rs;
    }
    public static ResultSet getCustomer() throws SQLException
    {
        try
       {    
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        PreparedStatement ps=con.prepareStatement("select * from customer");  
        rs =  ps.executeQuery();
        con.commit();
       
       }
      catch( SQLException e)
      {
          e.printStackTrace();
      }
      
        return rs;
    }
    public static ResultSet getAccount() throws SQLException
    {
        try
       {    
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        PreparedStatement ps=con.prepareStatement("select * from account");  
        rs =  ps.executeQuery();
        
        con.commit();
       
       }
      catch( SQLException e)
      {
          e.printStackTrace();
      }
      
        return rs;
    }
     public static ResultSet getAccountApplication() throws SQLException
    {
        try
       {    
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        PreparedStatement ps=con.prepareStatement("select * from accountapplication");  
        rs =  ps.executeQuery();
        
        con.commit();
       
       }
      catch( SQLException e)
      {
          e.printStackTrace();
      }
      
        return rs;
    }
     public static ResultSet getDepositApplication() throws SQLException
    {
        try
       {    
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        PreparedStatement ps=con.prepareStatement("select * from depositapplication");  
        rs =  ps.executeQuery();
        
        con.commit();
       
       }
      catch( SQLException e)
      {
          e.printStackTrace();
      }
      
        return rs;
    }
     public static boolean updateAccountDetails( Customer customer , Account account) throws SQLException
    {
        boolean status = false;
        try
       {    
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement psCustomer1 = con.prepareStatement("update  customer set name = ? where customer_id = ?"); 
        PreparedStatement psCustomer2 = con.prepareStatement("update  customer set email = ? where customer_id = ?");  
        PreparedStatement psCustomer3 = con.prepareStatement("update  customer set password = ? where customer_id = ?");  
        PreparedStatement psCustomer4 = con.prepareStatement("update  customer set phone = ? where customer_id = ?");  
        
        PreparedStatement psCustomer5 = con.prepareStatement("update  customer set address = ? where customer_id = ?");  
        PreparedStatement psCustomer6 = con.prepareStatement("update  customer set nationality = ? where customer_id = ?");  
        PreparedStatement psCustomer7 = con.prepareStatement("update  customer set dob = ? where customer_id = ?");  
        PreparedStatement psCustomer8 = con.prepareStatement("update  customer set gender = ? where customer_id = ?");  
        
        PreparedStatement psAccount1 = con.prepareStatement("update  account set pin = ? where account_no = ?");  
        PreparedStatement psAccount2 = con.prepareStatement("update  account set holdername = ? where account_no = ?");  
        
        psAccount1.setString(1,account.pin); psAccount1.setString(2,account.accountnumber);
        psAccount2.setString(1,customer.name); psAccount2.setString(2,account.accountnumber);
        psAccount1.execute(); psAccount2.execute();
        
        psCustomer1.setString(1,customer.name);psCustomer1.setString(2,customer.customerId);
      
        psCustomer2.setString(1, customer.email);psCustomer2.setString(2,customer.customerId);
        psCustomer3.setString(1, customer.password);psCustomer3.setString(2,customer.customerId);
        psCustomer4.setLong(1, customer.phoneNumber);psCustomer4.setString(2,customer.customerId);
        
        psCustomer5.setString(1, customer.address);psCustomer5.setString(2,customer.customerId);
        psCustomer6.setString(1, customer.nationality);psCustomer6.setString(2,customer.customerId);
        psCustomer7.setDate(1, new java.sql.Date(customer.dob.getTime() ) );psCustomer7.setString(2,customer.customerId);
        psCustomer8.setString(1, customer.gender);psCustomer8.setString(2,customer.customerId);
       
        psCustomer1.executeUpdate(); psCustomer2.executeUpdate(); psCustomer3.executeUpdate(); psCustomer4.executeUpdate();
        psCustomer5.executeUpdate(); psCustomer6.executeUpdate(); psCustomer7.executeUpdate();
        psCustomer8.executeUpdate();
        
        psAccount1.executeUpdate(); psAccount2.executeUpdate();
       status = true;
  
        con.commit();
       
       }
      catch( SQLException e)
      {
          e.printStackTrace();
      }
      return status;
    }
       public static boolean transferToAccount (  Account accountFrom ,Account accountTo) throws SQLException
      {
        boolean status = false;
        try
       {    
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement psCustomer1 = con.prepareStatement("update  account set  balance = ? where account_no = ?"); 
        PreparedStatement psCustomer2 = con.prepareStatement("update  account set  balance = ? where account_no = ?"); 
        
        psCustomer1.setDouble(1, accountFrom.accountBalance ); psCustomer1.setString(2,accountFrom.accountnumber);
        psCustomer2.setDouble(1, accountTo.accountBalance ); psCustomer2.setString(2,accountTo.accountnumber);
       
        if ( psCustomer1.executeUpdate()> 0 &&  psCustomer2.executeUpdate() > 0 )
        {
            status = true;
        }
        con.commit();
       
       }
      catch( SQLException e)
      {
          e.printStackTrace();
      }
      return status;
    }
        public static boolean transferToDeposit  (  Account accountFrom , Deposit accountTo) throws SQLException
      {
        boolean status = false;
        try
       {    
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
         PreparedStatement psCustomer1 = con.prepareStatement("update  account set  balance = ? where customer_id = ?"); 
        PreparedStatement psCustomer2 = con.prepareStatement("update   depositaccount  set  paidamount = ? where customer_id = ?"); 
        
        psCustomer1.setDouble (1, accountFrom.accountBalance ); psCustomer1.setString(2,accountFrom.customer.customerId);
        psCustomer2.setLong(1, accountTo.paidAmount  ); psCustomer2.setString(2,accountTo.customerId);
        psCustomer1.executeUpdate(); psCustomer2.executeUpdate();
        
        status = true;
       
        con.commit();
       }
      catch( SQLException e)
      {
          e.printStackTrace();
      }
      return status;
    }
       
    public static boolean updateBranchName ( String ifsccode , String branchname, String location) throws SQLException
    {
        boolean status = false;
        try
       {    
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        PreparedStatement ps1=con.prepareStatement("update  branchlist set branchname = ? where ifsccode = ?");  
        PreparedStatement ps2=con.prepareStatement("update  branchlist set location = ? where ifsccode = ?");  
        ps1.setString(1, branchname); ps1.setString(2,ifsccode);
        ps2.setString(1, location);        ps2.setString(2,ifsccode);
        if(ps1.executeUpdate() > 0 && ps2.executeUpdate() > 0)
        {
            status = true;
             con.commit();
        }
        con.commit();
       
       }
      catch( SQLException e)
      {
          
      }
      return status;
    }
   public static ResultSet getBranch() throws SQLException
    {
        try
       {    
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        PreparedStatement ps=con.prepareStatement("select * from branchlist");  
        rs =  ps.executeQuery();
        con.commit();
       
       }
      catch( SQLException e)
      {
          
      }
      
        return rs;
    }
   public static ResultSet getTransaction() throws SQLException
    {
        try
       {    
        Connection con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        PreparedStatement ps=con.prepareStatement("select * from transactiondata");  
        rs =  ps.executeQuery();
        con.commit();
       
       }
      catch( SQLException e)
      {
          
      }
      
        return rs;
    }
   
}
