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
public class edit_account_site extends HttpServlet {

   String customer_id;
    String accountnumber;
    String name;
    String pin;
    Date dob;
    String address;
    String nationality;
    String email;
    long phoneNumber;
    String gender;

    Customers customers = new Customers();
    Accounts accounts = new Accounts();
    Customer customer = new Customer();
    Account account = new Account();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,  IOException, ParseException, SQLException {
      
        response.setContentType("text/html;charset=UTF-8");
        
       customer_id = request.getParameter("id"); //=>account //=>customer
       accountnumber = request.getParameter("acc"); //=>account
       name = request.getParameter("name"); //=>Customer
       pin = request.getParameter("pin"); // =>account //=>customer
       Date date=new SimpleDateFormat("yyyy-MM-dd") .parse( request.getParameter("birthday") );
       dob = date; //=> customer
       address = request.getParameter("address"); //=>customer
       nationality = request.getParameter("nationality"); //=>customer
       email = request.getParameter("email"); //=>customer
       phoneNumber = Long.parseLong( request.getParameter("phone") ); //=>customer
       gender = request.getParameter("gender_type");
       account.customer.dob = dob; customer.name = name; customer.setCustomerId(customer_id);
       customer.customerId = customer_id;
       customer.dob = dob; account.accountnumber = accountnumber; account.pin = pin;
       customer.password = pin; customer.nationality = nationality; customer.email = email;
       customer.address = address; customer.phoneNumber = phoneNumber;
       customer.gender=gender;
         request.setAttribute ("customer_id",customer_id );
       if ( RegisterData.updateAccountDetails( customer,account ) )
       {
            request.setAttribute("Message","Account Edited");
             request.getRequestDispatcher("JSP/Website/site_template.jsp").forward(request, response);
       }
       else
       {
           request.setAttribute("Message","Account Not Edited");
             request.getRequestDispatcher("JSP/Website/site_template.jsp").forward(request, response);
       }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(edit_account.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("Message","Account Not Edited ");
            ex.printStackTrace();
             request.getRequestDispatcher("JSP/Website/site_template.jsp").forward(request, response);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex ) {
            Logger.getLogger(edit_account.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("Message","Account Not Edited");
             request.getRequestDispatcher("JSP/Website/admin_template.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(edit_account.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("Message","Account Not Edited");
             request.getRequestDispatcher("JSP/Website/admin_template.jsp").forward(request, response);
        }
    }

   }

