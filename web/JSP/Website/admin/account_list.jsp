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
           
           
        %>
        <div id="page_container">
            <jsp:include page="../modules/admin_header.jsp" />
            <div id="body" class="container-fuid">
                <jsp:include page="../modules/admin_sidebar.jsp" />
                <article id="content" class="span9">
                    <jsp:include page="../modules/admin_message.jsp" />
                    <table class="table table-hover">
                        <thead>
                        
                        <th>Account Number</th>
                        <th>IFSC CODE </th>
                        <th>Customer ID</th>
                        <th>Name</th>
                        <th>Balance</th>
                        <th></th>
                        </thead>
                        <tbody>
                            
                            <c:forEach items="${accountlist}" var="account">
                                <tr>
                                    
                                    <td>${account.accountnumber}</td>
                                    <td>${account.branchDetails.ifsc_code}</td>
                                    <td>${account.customer.customerId}</td>
                                    <td>
                                        <span class="list-username">${account.customer.name}</span>
                                    </td>
                                    <td>${account.accountBalance}</td>
                                    <td><a class="btn btn-small"
                                           style="width: 50px; margin-bottom: 5px;"
                                           href="account_edit.jsp?id=${account.customer.customerId}">Edit</a><br />
                                        <a class="btn btn-small" style="width: 50px;"
                                           href="customer_details.jsp?id=${account.customer.customerId}">Details</a>
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
