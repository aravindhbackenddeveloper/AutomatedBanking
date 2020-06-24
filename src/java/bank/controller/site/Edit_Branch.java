
package bank.controller.site;

import com.bank.api.BankBranch;
import com.bank.api.BankBranches;
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
public class Edit_Branch extends HttpServlet 
{

   BankBranches branches = new BankBranches();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
    {
        response.setContentType("text/html;charset=UTF-8");
        String branchp = request.getParameter("ifsccode");
        branches.branches = branches.getBranchList( RegisterData.getBranch() );
        BankBranch branch =new BankBranch();
        
      
        String location = request.getParameter("location");
        String name = request.getParameter("name");
        
          branch = branches.getBranch( request.getParameter("ifsccode"));
         
        if( RegisterData.updateBranchName(branchp,name, location ) )
        {
            request.setAttribute("Message", "Branch Edited");
            request.getRequestDispatcher("JSP/Website/admin_template.jsp").forward(request,response);
        }
        else
                {
                    request.setAttribute("Message", "Branch Not Edited");
            request.getRequestDispatcher("JSP/Website/admin/bank_branch_edit.jsp").forward(request,response);
                }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       try {
           processRequest(request, response);
       } catch (SQLException ex) {
           Logger.getLogger(Edit_Branch.class.getName()).log(Level.SEVERE, null, ex);
           request.setAttribute("Message", "Branch Not Edited");
            request.getRequestDispatcher("JSP/Website/admin/bank_branch_edit.jsp").forward(request,response);
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       try {
           processRequest(request, response);
       } catch (SQLException ex) {
           Logger.getLogger(Edit_Branch.class.getName()).log(Level.SEVERE, null, ex);
           request.setAttribute("Message", "Branch Not Edited");
            request.getRequestDispatcher("JSP/Website/admin/bank_branch_edit.jsp").forward(request,response);
       }
    }
}
