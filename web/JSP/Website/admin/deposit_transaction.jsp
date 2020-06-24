<%-- 
    Document   : deposit_transaction
    Created on : Jun 17, 2020, 9:50:52 PM
    Author     : Aravindh
--%>
<%@page import="com.bank.api.Deposit"%>
<%@page import="com.bank.api.Deposits"%>
<%@page import="com.bank.api.Transaction"%>
<%@page import="com.bank.api.Transactions"%>
<%@page import="com.database.bank.RegisterData"%>
<%@page import="com.bank.api.BankBranches"%>
<%@page import="com.bank.api.BankBranches"%>
<%@page import="com.bank.api.BankBranch"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <title> Transaction Of Account </title>
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
              
             Transactions trs = new Transactions();
             Deposits dps = new Deposits ();
             dps.getDepositList( RegisterData.getDeposit() );
             Deposit dp = dps.getDepositWithID(customer_id);
             
             trs.getTransaction( RegisterData.getTransaction() );
             ArrayList<Transaction> trsList = trs.getCustomerTransaction( dp.depositAccountNumber );
             request.setAttribute ("cust",customer    );  
             request.setAttribute ("acc",account        );
             request.setAttribute ("idd",customer_id );
              request.setAttribute ("customer_id",customer_id );
              request.setAttribute ( "trsList" ,trsList );
              
        %>
        <div id="page_container">
            <jsp:include page="../modules/admin_header.jsp" />
            <div id="body" class="container-fuid">
                <jsp:include page="../modules/admin_sidebar.jsp" />
                <article id="content" class="span9">
                   
                   <h3>Transaction List</h3>
                    <table class="table">
                        <thead>
                        <th>From Account</th>
                        <th>To Account</th>
                        <th>Date</th>
                        <th>Amount</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${trsList}" var="trs">
                                <tr>
                                    <td>${trs.getFromAcc()}</td>
                                    <td>${trs.getToAcc()}</td>
                                    <td>${trs.getTransactionDate()}</td>
                                    <td>${trs.getAmount()}</td>
                                    
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
