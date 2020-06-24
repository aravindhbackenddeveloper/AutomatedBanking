package bank.controller.site;
import com.bank.api.Account;
import com.bank.api.Accounts;
import com.bank.api.Customer;
import com.bank.api.Customers;
import com.database.bank.RegisterData;
import java.io.IOException;
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

public class Account_Applications extends HttpServlet 
{
    String name;
    String address;
    Date doj;
    Date dob;
    String gender;
    
    String pin;
    String nationality;
    String email;
    
    long phoneNumber;
    String accountType;
    String accountBranch;
    
    Customers customers = new Customers();
    Accounts accounts = new Accounts();
    Customer customer = new Customer();
    Account account = new Account();
    
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
            
            String cus_id = (String) request.getParameter("customer_id");
            
            name = request.getParameter("name");
            address = request.getParameter("address");
            Date date=new SimpleDateFormat("yyyy-mm-dd") .parse( request.getParameter("birthday") );
            dob = date;
            Date date1=new SimpleDateFormat("yyyy-mm-dd") .parse( request.getParameter("doj") );
            doj = date1;
            pin = request.getParameter("pin");
            nationality = request.getParameter("nationality");
            email = request.getParameter("email");
            gender = request.getParameter("gender_type");
            
            
            phoneNumber = Long.parseLong ( request.getParameter("phone") );
            accountType = request.getParameter("account_type");
            accountBranch = request.getParameter("branchlist");
            
            customer.setName(name);                customer.setAddress(address);     
            customer.setEmail(email); 
            customer.setCustomerId(cus_id);     customer.setPassword(pin);
            customer.setAddress(address);        customer.nationality = nationality; 
            customer.gender= (gender);              customer.dob = dob;
            customer.phoneNumber = phoneNumber; customer.gender = gender; account.customer.gender = gender ;
            
            account.pin = pin;   account.doj = doj;   account.accountType = accountType;
            account.branchDetails.setIfsc_code( accountBranch); account.generateAccountNumber(accounts.getCount());
            request.setAttribute("customer_id", cus_id);
           if ( RegisterData.requestAccountApplication (account, customer) > 0   && RegisterData.updateCustomer(customer) > 0 )
           {
               request.setAttribute("Message","New Account  Requested");
               request.getRequestDispatcher("JSP/Website/site_template.jsp?customer_id=${customer_id}").forward(request, response);
            }
        }
        catch ( ParseException | SQLException ex )
        {
             Logger.getLogger(Create_Account.class.getName()).log(Level.SEVERE, null, ex);
             request.setAttribute("Message","New Account  not Requested");
             request.getRequestDispatcher("JSP/Website/site_template.jsp?customer_id=${customer_id}").forward(request, response);
             ex.printStackTrace();
        }
        catch(Exception e )
        {
             request.setAttribute("Message","New Account and User Not  Requested ---  An error Occured,Try Again");
             request.getRequestDispatcher("JSP/Website/site_template.jsp?customer_id=${customer_id}").forward(request, response);
             e.printStackTrace();
        }
    }
}
