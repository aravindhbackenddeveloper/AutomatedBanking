<%-- 
    Document   : deposit_account
    Created on : Jun 15, 2020, 7:20:59 PM
    Author     : Aravindh
--%>

<%@page import="com.bank.api.Deposit"%>
<%@page import="com.bank.api.Deposits"%>
<%@page import="com.database.bank.RegisterData"%>
<%@page import="com.bank.api.Customers"%>
<%@page import="com.bank.api.Accounts"%>
<%@page import="com.bank.api.Customer"%>
<%@page import="com.bank.api.Account"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Deposit Account</title>
        <link rel="shortcut icon" href="../resources/images/molecue.png"
              type="image/x-icon" />
        <link href="../resources/css/jquery-ui-1.10.3.min.css"
              rel="stylesheet" media="screen" />
        <link href="../resources/css/flaty.bootstrap.min.css"
              rel="stylesheet" media="screen" />
        <link href="../resources/css/application_admin.css"
              rel="stylesheet" media="screen" />

        <script src="../resources/js/jquery-1.10.1.js"></script>
        <script src="../resources/js/jquery-ui-1.10.3.js"></script>
        <script src="../resources/js/bootstrap.js"></script>
        <script src="../resources/js/application.js"></script>
    </head>
    <body>
         <%
              String customer_id =  (String) request.getParameter("customer_id");
            
              
              Account account ;  Customer  customer;
              Accounts accounts =  new Accounts(); Customers customers = new Customers();
              
              accounts.getAccountList( RegisterData.getAccount() ); 
              customers.getCustomerList( RegisterData.getCustomer() );
              
              customer = customers.getCustomerWithID(customer_id);
              account = accounts.getAccountWithID(customer_id);
              
               Deposits dps = new Deposits ();
             dps.getDepositList( RegisterData.getDeposit() );
             Deposit dp = dps.getDepositWithID(customer_id);
              request.setAttribute ("dp",dp );
             request.setAttribute ("cust",customer    );  
             request.setAttribute ("acc",account        );
            request.setAttribute ("idd",customer_id );
             request.setAttribute ("id",customer_id );
              request.setAttribute ("customer_id",customer_id );
             
             
             
        %>
        <div id="page_container">
            <jsp:include page="../modules/site_header.jsp" />
            <div id="body" class="container-fuid">
                <jsp:include page="../modules/site_sidebar.jsp" />
                <article id="content" class="span9">
                    <jsp:include page="../modules/site_message.jsp" />

                    <h3>
                        Deposit Account Information of ${cust.customerId} 
                        
                             <a href="deposit_transaction.jsp?id=${cust.customerId}"
                            style="margin-top: 15px;" class="pull-right btn btn-small btn-info">View Transactions</a>
                           <br/>
                    </h3>

                    <table class="table">
                        
                        <tr>
                            <td><b/>Deposit Account Number</td>
                            <td>${dp.depositAccountNumber}</td>
                        </tr>
                        <tr>
                            <td><b/>Total Amount</td>
                            <td>INR  ${dp.totalAmount}</td>
                        </tr>
                        <tr>
                            <td><b/>Paid Amount</td>
                            <td>INR  ${dp.paidAmount}</td>
                        </tr>
                        <tr>
                            <td><b/>Interest</td>
                            <td>INR  ${dp.intrest}</td>
                        </tr>
                        <tr>
                            <td><b/>Name</td>
                            <td>${cust.name}</td>
                        </tr>
                        <tr>
                            <td><b/>E-mail</td>
                            <td>${cust.email}</td>
                        </tr>
                        <tr>
                            <td><b/>Address</td>
                            <td>${cust.address}</td>
                        </tr>
                        <tr>
                            <td><b/>Gender</td>
                            <td>${cust.gender}</td>
                        </tr>
                        <tr>
                            <td><b/>Nationality</td>
                            <td>${cust.nationality}</td>
                        </tr>
                        <tr>
                            <td><b/>Date of Joining</td>
                            <td>
                                ${acc.doj}
                            </td>
                        </tr>
                        <tr>
                            <td><b/>Date of Birth</td>
                            <td>${cust.dob}</td>
                        </tr>
                    </table>
                  

                </article>
            </div>
            <div class="clear"></div>
            <jsp:include page="../modules/admin_footer.jsp" />
        </div>
    </body>
</html>