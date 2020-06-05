package com.database.bank;

/**
 *
 * @author Aravindh
 */
public interface Provider 
{
        String DRIVER="org.apache.derby.jdbc.ClientDriver";  
        String CONNECTION_URL="jdbc:derby://localhost:1527/contact;create=true";  
        String USERNAME="nbuser";  
        String PASSWORD="nbuser";  
    
}
