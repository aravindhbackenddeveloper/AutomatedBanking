<%-- 
    Document   : deposit_list
    Created on : Jun 17, 2020, 11:53:44 PM
    Author     : Aravindh
--%>

<%@page import="com.bank.api.Deposits"%>
<%@page import="com.bank.api.Accounts"%>
<%@page import="com.bank.api.Account"%>
<%@page import="com.database.bank.RegisterData"%>
<%@page import="com.bank.api.Customers"%>
<%@page import="com.bank.api.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Account List</title>
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
            ArrayList<Account> accountList = new ArrayList<>();
            Accounts accounts = new Accounts();
            accountList = accounts.getAccountList( RegisterData.getAccount() );
            request.setAttribute("accountlist", accountList);
              Deposits dps = new Deposits ();
             dps.getDepositList( RegisterData.getDeposit() );
           request.setAttribute("dpslist",dps.depositList);
           
        %>
        <div id="page_container">
            <jsp:include page="../modules/admin_header.jsp" />
            <div id="body" class="container-fuid">
                <jsp:include page="../modules/admin_sidebar.jsp" />
                <article id="content" class="span9">
                    <jsp:include page="../modules/admin_message.jsp" />
                    <table class="table table-hover">
                        <thead>
                        
                        <th>Deposit Account </th>
                       
                        <th>Customer ID</th>
                        
                    
                        <th></th>
                        </thead>
                        <tbody>
                            
                            <c:forEach items="${dpslist}" var="dp">
                                <tr>
                                    
                                    <td>${dp.depositAccountNumber}</td>
                                    <td>${dp.customer.customerId}</td>
                                   
                                  
                                    <td>
                                        <a class="btn btn-small" style="width: 50px;"
                                           href="deposit_account.jsp?customer_id=${dp.customer.customerId}">Details</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </article>
            </div>
            <div class="clear"></div>
            <jsp:include page="../modules/admin_footer.jsp" />
        </div>
    </body>
</html>
