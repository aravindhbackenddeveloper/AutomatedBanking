
package bank.controller.site;

import com.bank.api.BankBranch;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.api.BankBranches;
import com.database.bank.RegisterData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Aravindh
 */
public class addbranch extends HttpServlet {

    String location;
    String ifsccode;
    String branchName;
    
    BankBranches branches =  new BankBranches();
    
    
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
    {
        response.setContentType("text/html;charset=UTF-8");
        
        location = request.getParameter("location");
        branchName = request.getParameter("name");
        
        BankBranch branch = new BankBranch();
        branch.setBranch_Name(branchName);
        branch.setLocation(location);
        branch.generateIfscCode( branches.getCount() );
        request.setAttribute("status", "attempted");
        if( RegisterData.addBranch(branch) !=0 )
        {
             request.setAttribute("Message", "New Branch Added");
             
            request.getRequestDispatcher("JSP/Website/admin_template.jsp").forward(request,response);
        }
        else
        {
            request.setAttribute("Message", "New Branch Not Added");
            request.getRequestDispatcher("JSP/Website/admin/add_branch.jsp").forward(request,response);
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
             request.setAttribute("Message", "New Branch Not Added -Error Try again");
            request.getRequestDispatcher("JSP/Website/admin/add_branch.jsp").forward(request,response);
            Logger.getLogger(addbranch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
               request.setAttribute("Message", "New Branch Not Added -Error Try again");
            request.getRequestDispatcher("JSP/Website/admin/add_branch.jsp").forward(request,response);
            Logger.getLogger(addbranch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
