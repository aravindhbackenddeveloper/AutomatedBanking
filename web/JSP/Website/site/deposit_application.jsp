<%-- 
    Document   : deposit_application
    Created on : Jun 14, 2020, 1:14:59 PM
    Author     : Aravindh
--%>



<%@page import="com.bank.api.Deposit"%>
<%@page import="com.bank.api.Deposits"%>
<%@page import="com.bank.api.Accounts"%>
<%@page import="com.bank.api.Customers"%>
<%@page import="com.bank.api.Customers"%>
<%@page import="com.bank.api.Account"%>
<%@page import="com.bank.api.Customer"%>
<%@page import="com.bank.api.BankBranch"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.database.bank.RegisterData"%>
<%@page import="com.database.bank.RegisterData"%>
<%@page import="com.bank.api.BankBranches"%>
<%@page import="com.bank.api.BankBranches"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>User Account</title>
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
        <div id="page_container">
               <%
                        
             String customer_id = (String)  request.getParameter("customer_id");
              
              Account account ;  Customer  customer;
              Accounts accounts =  new Accounts(); Customers customers = new Customers();
              
              accounts.getAccountList( RegisterData.getAccount() ); 
              customers.getCustomerList( RegisterData.getCustomer() );
              
              customer = customers.getCustomerWithID(customer_id);
              account = accounts.getAccountWithID(customer_id);
              
             request.setAttribute ("cust",customer    );  
             request.setAttribute ("acc",account        );
           
               Deposits dps = new Deposits ();
             dps.getDepositList( RegisterData.getDeposit() );
             Deposit dp = dps.getDepositWithID(customer_id);
              request.setAttribute ("dp",dp );
              request.setAttribute ("customer_id",customer_id );
              BankBranches branches = new BankBranches();
                                    branches.getBranchList( RegisterData.getBranch() );
                                    ArrayList<BankBranch> branchList = branches.branches;
                                    request.setAttribute("branchlist", branchList);
            
            %>
            <jsp:include page="../modules/site_header.jsp" />
            <div id="body" class="container-fuid">
                <jsp:include page="../modules/site_sidebar.jsp" />
                <article id="content" class="span9">
                    <jsp:include page="../modules/site_message.jsp" />
              
                
                
                   <h3>Request Deposit Account </h3>

                    <form name="form-customer" id="form-customer"
                          action="../../../Deposit_Applications?customer_id=${customer_id}"
                          method="post">
                        <table class="table">
                            
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
                                    <td><b/>Deposit Amount</td>
                                    <td><select name="depositamount" >
                                            <option value="">- Select One -</option>
                                            <option value="200000">200000</option>
                                            <option value="100000">500000</option>
                                        </select></td>
                                </tr>
                               <tr>
                                    <td><b/>Interest Percentage</td>
                                    <td><select name="Interest" >
                                            <option value="">- Select One -</option>
                                            <option value="9">9</option>
                                            <option value="10">10</option>
                                        </select></td>
                                </tr>
                                <tr>
                                    <td><b/>Branch</td>
                                    <td><select name="branchlist" placeholder="Account Type">
                                            <option value="">- Select One -</option>
                                            <c:forEach items="${branchlist}" var="branch">
                                                <option  selected="selected" value="${branch.ifsc_code}">${branch.ifsc_code}</option>     
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                 <tr>
                                <c:if test = "${dp.depositAccountNumber == null}">
                                
                                <td><input class="btn btn-primary btn-large" type="submit"
                                           value="Request Deposit" /></td>
                            
                                </c:if>
                             
                             </tr>
                        </table>
                    </form>
                </article>
            </div>
            <div class="clear"></div>
            <jsp:include page="../modules/site_footer.jsp" />
        </div>
    </body>
</html>
