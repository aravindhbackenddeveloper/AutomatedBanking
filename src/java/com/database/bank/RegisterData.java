
package com.database.bank;

import com.bank.api.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aravindh
 */
public class RegisterData
{
    private static ResultSet rs=null;
    private static Connection con;
   
    public static  void deleteEntrys() throws SQLException
    {
        con=DatabaseConnection.getCon();
        PreparedStatement p=con.prepareStatement("delete from ssntable");
        p.executeUpdate();	  
    }
    public static int addCustomer(Customer customer) throws SQLException
   {  
      int status;  
       
      try
      {  
    	  
        con=DatabaseConnection.getCon();
        con.setAutoCommit(false);
        
        PreparedStatement ps=con.prepareStatement("insert into ssntable values(?,?,?)");  
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
   

    
}
