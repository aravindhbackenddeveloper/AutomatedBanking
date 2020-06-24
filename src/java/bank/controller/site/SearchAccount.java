
package bank.controller.site;

import com.bank.api.Account;
import com.bank.api.Accounts;
import com.bank.api.Customers;
import com.database.bank.RegisterData;
import java.io.IOException;
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
public class SearchAccount extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      try {
          
            String customer="";
          
            String acc_id = request.getParameter("account_id");
           Accounts accounts = new Accounts(); 
           accounts.getAccountList( RegisterData.getAccount());
           Account acc = accounts.getAccount( acc_id );
            if( accounts.getAccountWithID( acc.customer.customerId ) != null  )
            {
              customer =  accounts.getAccountWithID( acc.customer.customerId ).customer.customerId;
          
            response.sendRedirect("http://localhost:8082/AutomatedBanking/JSP/Website/admin/customer_details.jsp?id="+customer);
            }
            else
            {
                request.setAttribute("Message", "Customer Not Found or Enter details correct");
              
           response.sendRedirect("http://localhost:8082/AutomatedBanking/JSP/Website/admin/account_search.jsp?id=0");
            }
            
            
           
        } catch (Exception ex) {
            Logger.getLogger(SearchCustomer.class.getName()).log(Level.SEVERE, null, ex);
             request.setAttribute("Message", "Customer Not Found");
           response.sendRedirect("http://localhost:8082/AutomatedBanking/JSP/Website/admin/account_search.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


}
