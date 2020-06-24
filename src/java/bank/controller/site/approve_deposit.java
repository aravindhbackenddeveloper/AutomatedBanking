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
public class approve_deposit extends HttpServlet 
{

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
    {
        response.setContentType("text/html;charset=UTF-8");
        String customer_id = (String) request.getParameter("id");
        
    Account account;
    
    Deposit deposit;
    Customer customer;
    Deposits deposits = new Deposits();
    Customers customers = new Customers();

    customers.getCustomerList(RegisterData.getCustomer());
    customer = customers.getCustomerWithID(customer_id);
    deposits.getDepositList( RegisterData.getDepositApplication() );
   deposit= deposits.getDepositWithID ( customer_id );
    
   

    request.setAttribute("cust", customer);
    request.setAttribute("idd", customer_id);
    request.setAttribute("id", customer_id);
    request.setAttribute("customer_id", customer_id);
    RegisterData.approveDepositRequest(deposit,customer, customer_id);
    request.getRequestDispatcher("JSP/Website/admin_template.jsp").forward(request, response); 
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(approve_account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(approve_account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

}
