<%@page import="com.database.bank.RegisterData"%>
<%@page import="com.bank.api.Customers"%>
<%@page import="com.bank.api.Accounts"%>
<%@page import="com.bank.api.Customer"%>
<%@page import="com.bank.api.Account"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Account Details</title>
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
              account = accounts.getAccount(customer_id);
              
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
                        Details of Customer ${cust.customerId}
                        <a href="customer_edit.jsp?id= ${cust.customerId}"
                           style="margin-top: 15px;" class="pull-right btn btn-small btn-info">Edit
                            Account</a>
                        
                    </h3>

                    <table class="table">
                          <tr>
                                    <td>Customer ID</td>
                                    <td><input
                                        value="<c:if test="${data.pin != 0}">${data.pin}</c:if>" name="customer_ID" autocomplete="off"
                                            type="text" /></td>
                            </tr>
                        <tr>
                            <td>Account ID</td>
                            <td>${data.account_id}</td>
                        </tr>
                        <tr>
                            <td>Balance</td>
                            <td><fmt:formatNumber value="${data.amount}" type="currency"/></td>
                        </tr>
                        <tr>
                            <td>Account Type</td>
                            <td> Saving Account</td>
                        </tr>
                    </table>

                    <h3>Customers own to this Account</h3>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <td>Customer ID</td>
                                <td>Name</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${data.customers}" var="_customer">
                                <tr>
                                    <td>${_customer.customer_id}</td>
                                    <td><b style="font-size: 15px;">${_customer.givenname}</b><br />${_customer.username}
                                    </td>
                                    <td><a
                                            href="${page.url_host}${page.url_apppath}admin/customer/details/${_customer.customer_id}"
                                            class="btn btn-small">View Details</a></td>
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

