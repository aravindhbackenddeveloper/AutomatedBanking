package bank.controller.site;

import com.bank.api.Customer;
import com.bank.api.Customers;
import com.database.bank.RegisterData;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aravindh
 */
public class Signup extends HttpServlet {

    Customer customer;
    String name;
    String password;
    String repassword;
    String email;

    Customers customers = new Customers();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            customer = new Customer();
            name = (String) request.getParameter("name");
            password = (String) request.getParameter("pass");
            repassword = (String) request.getParameter("re_pass");
            email = (String) request.getParameter("email");

            customer.setName(name);
            customer.setEmail(email);
            customer.setPassword(password);
            customer.generateCustomerID(customers.getCount());

            if ( RegisterData.addCustomer (customer) > 0 ) {
                request.setAttribute("Message", name);
                request.setAttribute("customer_id", customer.customerId);
                request.getRequestDispatcher("JSP/Website/site_template.jsp?customer_id=${customer_id}").forward(request, response);
            } else {
                request.setAttribute("Message", "Try Again");
                request.getRequestDispatcher("JSP/Login_SignUp/Signup.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("htttp://localhost:8082/AutomatedBanking/JSP/Login_SignUp/Signup.jsp");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
