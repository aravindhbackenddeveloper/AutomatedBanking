package com.database.bank;

import static com.database.bank.Provider.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aravindh
 */
public class DatabaseConnection 
{
    private static Connection con=null;  
    public static Connection getCon() throws SQLException 
     {  		  
	
        try 
        {
            Class.forName(DRIVER);
            con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD); 
        } 
        catch (ClassNotFoundException e) 
        {
            
        }  		    
        return con;  
     }  
    
}
