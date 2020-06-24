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
        <title><c:out value="${page.page_title}" /></title>
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
              String customer_id = (String)  request.getParameter("id");
              
              Account account ;  Customer  customer;
              Accounts accounts =  new Accounts(); Customers customers = new Customers();
              
              accounts.getAccountList( RegisterData.getAccount() ); 
              customers.getCustomerList( RegisterData.getCustomer() );
              
              customer = customers.getCustomerWithID(customer_id);
              account = accounts.getAccountWithID(customer_id);
              
             request.setAttribute ("cust",customer    );  
             request.setAttribute ("acc",account        );
             request.setAttribute ("idd",customer_id);
        %>
        <div id="page_container">
            <jsp:include page="../modules/admin_header.jsp" />
            <div id="body" class="container-fuid">
                <jsp:include page="../modules/admin_sidebar.jsp" />
                <article id="content" class="span9">
                    <jsp:include page="../modules/admin_message.jsp" />

                    <h3>
                        Detail Information of ${cust.customerId} &nbsp;&nbsp;&nbsp;<a
                            href="account_edit.jsp?id=${cust.customerId}"
                            style="margin-top: 15px;" class="pull-right btn btn-small btn-info">Edit
                            Details</a>
                            <a href="account_transaction.jsp?id=${cust.customerId}"
                            style="margin-top: 15px;" class="pull-right btn btn-small btn-info">View Transactions</a>
                           <br/>
                    </h3>

                    <table class="table">
                        
                        <tr>
                            <td>Account Number</td>
                            <td>${acc.accountnumber}</td>
                        </tr>
                        <tr>
                            <td>Name</td>
                            <td>${cust.name}</td>
                        </tr>
                        <tr>
                            <td>E-mail</td>
                            <td>${cust.email}</td>
                        </tr>
                        <tr>
                            <td>Address</td>
                            <td>${cust.address}</td>
                        </tr>
                        <tr>
                            <td>Gender</td>
                            <td>${cust.gender}</td>
                        </tr>
                        <tr>
                            <td>Nationality</td>
                            <td>${cust.nationality}</td>
                        </tr>
                        <tr>
                            <td>Date of Joining</td>
                            <td>
                                ${acc.doj}
                            </td>
                        </tr>
                        <tr>
                            <td>Date of Birth</td>
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


