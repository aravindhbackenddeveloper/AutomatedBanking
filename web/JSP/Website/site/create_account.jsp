

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
         <%
                        
             String customer_id = (String)  request.getParameter("customer_id");
              
              Account account ;  Customer  customer;
              Accounts accounts =  new Accounts(); Customers customers = new Customers();
              
              accounts.getAccountList( RegisterData.getAccount() ); 
              customers.getCustomerList( RegisterData.getCustomer() );
              
               Deposits dps = new Deposits ();
             dps.getDepositList( RegisterData.getDeposit() );
             Deposit dp = dps.getDepositWithID(customer_id);
              request.setAttribute ("dp",dp );
              customer = customers.getCustomerWithID(customer_id);
              account = accounts.getAccountWithID(customer_id);
              
             request.setAttribute ("cust",customer    );  
             request.setAttribute ("acc",account        );
           
              request.setAttribute ("customer_id",customer_id );
              BankBranches branches = new BankBranches();
                                    branches.getBranchList( RegisterData.getBranch() );
                                    ArrayList<BankBranch> branchList = branches.branches;
                                    request.setAttribute("branchlist", branchList);
            
            %>
        <div id="page_container">
              
            <jsp:include page="../modules/site_header.jsp" />
            <div id="body" class="container-fuid">
                <jsp:include page="../modules/site_sidebar.jsp" />
                <article id="content" class="span9">
                    <jsp:include page="../modules/site_message.jsp" />
              
                
                
                   <h3>Bank Account  </h3>

                    <form name="form-customer" id="form-customer"
                          action="../../../Account_Applications?customer_id=${customer_id}"
                          method="post">
                        <table class="table">
                            
                                <tr>
                                    <td><b/>Account Holder Name  </td>
                                    <td><input
                                        value="<c:if test="${data.pin != 0}">${data.pin}</c:if>" name="name" autocomplete="off"
                                            type="text" /></td>
                            </tr>
                            <tr>
                                <td><b/>Security PIN</td>
                                <td><input
                                        value="<c:if test="${data.pin != 0}">${data.pin}</c:if>" name="pin" autocomplete="off"
                                            type="text" placeholder="Security Pin" /></td>
                                </tr>
                                <tr>
                                    <td><b/>Date Of Birth</td>
                                    <td><input type="date" id="birthday" name="birthday"></td>
                                </tr>
                                 <tr>
                                    <td><b/>Date Of Join</td>
                                    <td><input type="date" id="doj" name="doj"></td>
                                </tr>
                                  <tr>
                                    <td><b/>Gender</td>
                                    <td><select name="gender_type">
                                            <option value="">- Select One -</option>
                                            <option value="Male">Male</option>
                                            <option value="Female">Female</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b/>Address</td>
                                    <td><input
                                            value="<c:if test="${data.amount != ''}">${data.amount}</c:if>"
                                            name="address" type="text"  autocomplete="off" /></td>
                                </tr>
                                 <tr>
                                    <td><b/>Nationality</td>
                                    <td><input
                                            value="<c:if test="${data.amount != ''}">${data.amount}</c:if>"
                                            name="nationality" type="text"  autocomplete="off" /></td>
                                </tr>
                                <tr>
                                    <td><b/>E-Mail</td>
                                    <td><input
                                            value="<c:if test="${data.amount != ''}">${data.amount}</c:if>"
                                            name="email" type="text"  autocomplete="off" /></td>
                                </tr>
                                 <tr>
                                    <td><b/>Phone Number</td>
                                    <td><input
                                            value="<c:if test="${data.amount != ''}">${data.amount}</c:if>"
                                            name="phone" type="text"  autocomplete="off" /></td>
                                </tr>
                                <tr>
                                    <td><b/>Account Type</td>
                                    <td><select name="account_type" placeholder="Account Type">
                                          
                                            <option
                                            <c:if test="${data.account_type == 1}">selected="selected"</c:if>
                                                value="Salary Account">Salary Account</option>
                                            <option
                                            <c:if test="${data.account_type == 2}">selected="selected"</c:if>
                                                value="Saving Account">Saving Account</option>
                                        </select></td>
                                </tr>
                              
                                <tr>
                                    <td><b/>Account Branch</td>
                                    <td><select name="branchlist" placeholder="Account Type">
                                            <option value="">- Select One -</option>
                                            <c:forEach items="${branchlist}" var="branch">
                                                <option  selected="selected" value="${branch.ifsc_code}">${branch.ifsc_code}</option>     
                                            </c:forEach>
                                            
                                        </select></td>
                                </tr>
                                 <tr>
                                    <c:if test= "${acc.accountnumber}">
                                <td><input class="btn btn-primary btn-large" type="submit"
                                           value="Create Account" /></td>
                                    </c:if>
                                <c:otherwise><b/>You have account Already</c:otherwise>
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
