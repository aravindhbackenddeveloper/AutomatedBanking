
package bank.controller.site;

import com.bank.api.Customers;
import com.database.bank.RegisterData;
import java.io.IOException;
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
public class SearchCustomer extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
           try {
          
            String customer="";
            request.setAttribute("Message", "Customer Found");
            String cust_id = request.getParameter("customer_id");
            Customers customers = new Customers();
              customers.getCustomerList( RegisterData.getCustomer() );
            if( customers.getCustomerWithID( cust_id ) != null  )
            {
              customer = customers.getCustomerWithID( cust_id ).customerId;
          
            response.sendRedirect("http://localhost:8082/AutomatedBanking/JSP/Website/admin/customer_details.jsp?id="+customer);
            }
            else
            {
                request.setAttribute("Message", "Customer Not Found or Enter details correct");
              
           response.sendRedirect("http://localhost:8082/AutomatedBanking/JSP/Website/admin/customer_search.jsp?id=0");
            }
            
            
           
        } catch (Exception ex) {
            Logger.getLogger(SearchCustomer.class.getName()).log(Level.SEVERE, null, ex);
             request.setAttribute("Message", "Customer Not Found");
           response.sendRedirect("http://localhost:8082/AutomatedBanking/JSP/Website/admin/customer_search.jsp");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
}
