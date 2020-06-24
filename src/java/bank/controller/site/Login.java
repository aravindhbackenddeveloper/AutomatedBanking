package bank.controller.site;

import com.bank.api.Customer;
import com.bank.api.Customers;
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
public class Login extends HttpServlet
{
    Customers customers=new Customers();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
            String name=(String) request.getParameter("your_name");
            String password=(String)request.getParameter("your_pass");
            
            
           if( customers.isEmployee(name, password))
           {
               request.getRequestDispatcher("JSP/Website/admin_template.jsp").forward(request,response);
               
           }
           else if(customers.isCustomer(name, password))
           {
               request.setAttribute("customer_id", name );
                request.getRequestDispatcher("JSP/Website/site_template.jsp?customer_id=${customer_id}").forward(request,response);
           }
           else
           {
               request.setAttribute("Message","Enter Correct Credentials");
              // request.getRequestDispatcher("JSP/Login_SignUp/Login.jsp").forward(request,response);
              response.sendRedirect("JSP/Login_SignUp/Login.jsp");
           }
            
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            response.sendRedirect("JSP/error_404.jsp");
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
          
            response.sendRedirect("JSP/error_404.jsp");
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
