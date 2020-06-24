package bank.controller.site;

import com.bank.api.Account;
import com.bank.api.Accounts;
import com.bank.api.Customer;
import com.bank.api.Customers;
import com.bank.api.Deposit;
import com.bank.api.Deposits;
import com.bank.api.Transaction;
import com.bank.api.Transactions;
import com.database.bank.RegisterData;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
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
public class amont_transfer extends HttpServlet
{

    String toAccount;
    double amount;
    String pin;

    Account accountFrom;
    Customer customerFrom;
    Account accountTo;
    Customer customerTo;
    Deposit deposit;
    Accounts accounts = new Accounts();
    Customers customers = new Customers();
    Deposits deposits = new Deposits();
    String customer_id;
    String transfer_type;
    Transaction t = new Transaction();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        customer_id = (String) request.getParameter("customer_id");

        toAccount = request.getParameter("account_id_to");
        amount = Long.parseLong(request.getParameter("transfer_amount"));
        pin = request.getParameter("pin");
        transfer_type = request.getParameter("transfer_type");

        deposits.getDepositList(RegisterData.getDeposit());
        accounts.getAccountList(RegisterData.getAccount());
        customers.getCustomerList(RegisterData.getCustomer());

        customerFrom = customers.getCustomerWithID(customer_id);
        accountFrom = accounts.getAccountWithID(customer_id);
        deposit = deposits.getDepositWithID(customer_id);

        request.setAttribute("cust", customerFrom);
        request.setAttribute("acc", accountFrom);
        request.setAttribute("customer_id", customer_id);
        request.setAttribute("dep", deposit);

        accountTo = accounts.getAccount(toAccount);
        Transactions ts = new Transactions();

        t.generateTransactionID(ts.getCount());
        t.setTransactionDate((Calendar.getInstance().getTime()));

        switch (transfer_type) {
            case "Account to Account":
                t.setFromAcc(accountFrom.accountnumber);
                t.setToAcc(accountTo.accountnumber);
                if (accountTo != null && accountFrom.pin.equalsIgnoreCase(pin) && accountFrom.accountBalance > amount
                        && !accountTo.customer.customerId.equalsIgnoreCase(accountFrom.customer.customerId)) {
                    accountFrom.accountBalance -= amount;
                    accountTo.accountBalance += amount;
                    t.setAmount  ( (long) amount );
                    RegisterData.transferToAccount(accountFrom, accountTo);
                    request.setAttribute("Message", "Transfer Done Successfully");
                    request.getRequestDispatcher("JSP/Website/site_template.jsp?customer_id=${customer_id}").forward(request, response);
                } else {
                    request.setAttribute("Message", "InSufficient Amount or Wrong Credentials");
                    request.getRequestDispatcher("JSP/Website/site_template.jsp?customer_id=${customer_id}").forward(request, response);
                }
                break;
            case "Account to Deposit":
                t.setAmount(( (long)amount ));
                if (deposit != null && accountFrom.pin.equalsIgnoreCase(pin) && accountFrom.accountBalance > amount) {
                    t.setFromAcc(accountFrom.accountnumber);
                    t.setToAcc(deposit.depositAccountNumber);

                    if (deposit.paidAmount + amount < deposit.totalAmount) {
                        accountFrom.accountBalance -= (long)amount;
                        t.setAmount(( (long)amount ));
                        deposit.customerId = customer_id;
                        deposit.paidAmount = (long) (deposit.paidAmount +amount + (amount * (deposit.intrest) /100));
                    }
                    
                    RegisterData.transferToDeposit(accountFrom, deposit);
                    
                    request.setAttribute("Message", "Transfer Done Successfully");
                    request.getRequestDispatcher("JSP/Website/site_template.jsp?customer_id=${customer_id}").forward(request, response);
                } else {
                    request.setAttribute("Message", "InSufficient Amount or Wrong Credentials");
                    request.getRequestDispatcher("JSP/Website/site_template.jsp?customer_id=${customer_id}").forward(request, response);
                }
                break;
            case "Deposit to Account":
                t.setFromAcc(deposit.depositAccountNumber);
                t.setToAcc(accountFrom.accountnumber);
                t.setAmount(((long)amount));
                if (accountTo != null && accountFrom.pin.equalsIgnoreCase(pin) && deposit.paidAmount >= amount) {
                    deposit.paidAmount -= amount;
                    t.setAmount( ( (long)amount ));
                    accountTo.accountBalance += amount;
                    RegisterData.transferToDeposit(accountFrom, deposit);
                    request.setAttribute("Message", "Transfer Done Successfully");
                    request.getRequestDispatcher("JSP/Website/site_template.jsp?customer_id=${customer_id}").forward(request, response);
                } else {
                    request.setAttribute("Message", "InSufficient Amount or Wrong Credentials");
                    request.getRequestDispatcher("JSP/Website/site_template.jsp?customer_id=${customer_id}").forward(request, response);
                }
                break;
            default:
                request.setAttribute("Message", "InSufficient Amount or Wrong Credentials");
                request.getRequestDispatcher("JSP/Website/site_template.jsp?customer_id=${customer_id}").forward(request, response);
                break;
        }
        RegisterData.addTransaction(t);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(amont_transfer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(amont_transfer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}