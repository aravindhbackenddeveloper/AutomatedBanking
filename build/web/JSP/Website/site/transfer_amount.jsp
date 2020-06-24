<%-- 
    Document   : transfer_amount
    Created on : Jun 14, 2020, 10:41:03 AM
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
        <title>Transfer Amount</title>
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
            String customer_id = (String) request.getParameter("customer_id");

            Account account;
            Customer customer;
            Accounts accounts = new Accounts();
            Customers customers = new Customers();
            Deposits deposits = new Deposits();
            deposits.getDepositList( RegisterData.getDeposit() );
            Deposit deposit = deposits.getDepositWithID ( customer_id );
            

               Deposits dps = new Deposits ();
             dps.getDepositList( RegisterData.getDeposit() );
             Deposit dp = dps.getDepositWithID(customer_id);
              request.setAttribute ("dp",dp );
            accounts.getAccountList(RegisterData.getAccount());
            customers.getCustomerList(RegisterData.getCustomer());

            customer = customers.getCustomerWithID(customer_id);
            account = accounts.getAccountWithID(customer_id);

            request.setAttribute("cust", customer);
            request.setAttribute("acc" ,  account  );
            request.setAttribute("dep", deposit   );

            request.setAttribute("customer_id", customer_id);


        %>

        <div id="page_container">
            <jsp:include page="../modules/site_header.jsp" />
            <div id="body" class="container-fuid">
                <jsp:include page="../modules/site_sidebar.jsp" />
                <article id="content" class="span9">
                    <jsp:include page="../modules/site_message.jsp" />

                    <table class="table .table-condensed">
                        <thead>
                        <h4><b/><b/>Account Summary - ${customer_id}</h4>
                        </thead>
                        <tr>
                            <td><b/>Bank Account Number</td>
                            <td>${acc.accountnumber}</td>
                        </tr>
                        <tr>
                            <td><b/>Balance</td>
                            <td>INR  ${acc.accountBalance}</td>
                        </tr>
                        <c:if test ="${dep != null}">
                        <tr>
                            <td><b/>Deposit Account Number</td>
                            <td>${dep.depositAccountNumber}</td>
                        </tr>
                        <tr>
                            <td><b/>Balance</td>
                            <td>INR  ${dep.paidAmount}</td>
                        </tr>
                    </c:if>
                    </table>

                    <div class="center-holder">

                        <form id="form-withdraw" name="form-withdraw" class="center-box"
                              action="../../../amont_transfer?customer_id=${customer_id}"
                              method="post">
                            <h4><b/>Transfer</h4>
                            <table>
                                <tr>
                                    <td><b/>Transfer Type</td>
                                    <td><select name="transfer_type">
                                            <option value="Account to Account">Account to Account</option>
                                             <c:if test ="${dep != null}">
                                                 <option value="Account to Deposit">Account to Deposit</option>
                                           
                                                  <c:if test="${dep.totalAmount == dep.paidAmount}">
                                                      <option value="Deposit to Account">Deposit to Account</option>
                                                   </c:if>
                                            </c:if>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width: 150px;"><label><b/>Transfer To</label></td>
                                    <td style="width: 250px;"><input id="account_id_to" name="account_id_to" autocomplete="off"
                                                                     type="text" class="input-block-level" required="required"
                                                                     placeholder="Bank Account Number">
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width: 150px;"><label><b/>Amount to Transfer</label></td>
                                    <td style="width: 250px;"><input name="transfer_amount" autocomplete="off"
                                                                     type="text" class="input-block-level" required="required"
                                                                     placeholder="Transfer Amount"></td>
                                </tr>
                                <tr>
                                    <td><label><b/>Security Pin</label></td>
                                    <td><input name="pin" type="text"  autocomplete="off"
                                               required="required" class="input-block-level"
                                               placeholder="Security Pin" /></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input class="btn btn-primary btn-large" type="submit"
                                           value="Transfer" /></td><b/> </td>
                                </tr>
                            </table>



                        </form>
                    </div>
                </article>
            </div>
            <div class="clear"></div>
            <jsp:include page="../modules/admin_footer.jsp" />
        </div>
    </body>
</html>