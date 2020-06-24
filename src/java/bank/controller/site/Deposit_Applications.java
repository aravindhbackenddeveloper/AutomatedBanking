/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.controller.site;

import com.bank.api.Account;
import com.bank.api.Accounts;
import com.bank.api.Customer;
import com.bank.api.Customers;
import com.bank.api.Deposit;
import com.bank.api.Deposits;
import com.database.bank.RegisterData;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aravindh
 */
public class Deposit_Applications extends HttpServlet {
 
    String accountBranch;
    long depositAmount;
    double interest;
    
   Deposit deposit = new Deposit();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");  
    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        try 
        {
            processRequest(request, response);
            
            String customer_id = (String) request.getParameter("customer_id");
            accountBranch = request.getParameter("branchlist");
            interest = Double.parseDouble ( request.getParameter("Interest") ) ;
            depositAmount = Long.parseLong( request.getParameter("depositamount") ) ;
            Deposits deposits = new Deposits();
            deposit.generateDepositAccountNumber( deposits.getCount() ) ;
            deposit.customer.customerId = customer_id;  
            deposit.intrest =  interest;
            deposit.totalAmount = depositAmount;
            Account account ;  Customer  customer;
              Accounts accounts =  new Accounts(); Customers customers = new Customers();
              
              accounts.getAccountList( RegisterData.getAccount() ); 
              customers.getCustomerList( RegisterData.getCustomer() );
              
              customer = customers.getCustomerWithID(customer_id);
              account = accounts.getAccount(customer_id);
              
             request.setAttribute ("cust",customer    );  
             request.setAttribute ("acc",account        );
             request.setAttribute ("idd",customer_id);
              request.setAttribute ("customer_id",customer_id);
           if ( RegisterData.requestDepositApplication (deposit, customer) > 0 )
           {
               request.setAttribute("Message","New Account  Requested");
               request.getRequestDispatcher("JSP/Website/site_template.jsp?customer_id=${customer_id}").forward(request, response);
            }
        }
        
        catch(Exception e )
        {
             request.setAttribute("Message","New Account and User Not  Requested ---  An error Occured,Try Again");
             request.getRequestDispatcher("JSP/Website/site_template.jsp?customer_id=${customer_id}").forward(request, response);
             e.printStackTrace();
        }
    }
}
