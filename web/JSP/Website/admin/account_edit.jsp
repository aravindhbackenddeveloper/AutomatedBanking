<%@page import="com.database.bank.RegisterData"%>
<%@page import="com.bank.api.Customers"%>
<%@page import="com.bank.api.Accounts"%>
<%@page import="com.bank.api.Account"%>
<%@page import="com.bank.api.Account"%>
<%@page import="com.bank.api.Customer"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Details</title>
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
               request.setAttribute ("customer_id",customer_id );
        %>
        <div id="page_container">
            <jsp:include page="../modules/admin_header.jsp" />
            <div id="body" class="container-fuid">
                <jsp:include page="../modules/admin_sidebar.jsp" />
                <article id="content" class="span9">
                    <jsp:include page="../modules/admin_message.jsp" />
                       
                           
                   
                    <form name="form-customer" id="form-customer"
                          action="../../../edit_account"
                          method="post">
                        <h3>Edit Details </h3>
                        <table class="table">
                            <tr>
                                    <td><b/>Customer ID </td>
                                    <td name="id">${cust.customerId}</td>
                            </tr>
                                <tr>
                                    <td><b/>Account Number</td>
                                    <td name="acc">${acc.accountnumber}</td>
                            </tr>
                                <tr>
                                    <td><b/>Account Holder Name</td>
                                    <td><input
                                        value="${cust.name}" name="name" autocomplete="off"
                                            type="text" /></td>
                            </tr>
                            <tr>
                                <td><b/>Security PIN</td>
                                <td><input
                                        value="${acc.pin}" name="pin" autocomplete="off"
                                            type="text" placeholder="Security Pin" /></td>
                                </tr>
                                <tr>
                                    <td><b/>Gender</td>
                                    <td><select name="gender_type">
                                           
                                            <option value="Male">Male</option>
                                            <option value="Female">Female</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b/>Date Of Birth</td>
                                    <td><input type="date" id="birthday" name="birthday" value="${cust.dob}"></td>
                                </tr>
                                 
                                <tr>
                                    <td><b/>Address</td>
                                    <td><input
                                            value="${cust.address}"
                                            name="address" type="text"  autocomplete="off" /></td>
                                </tr>
                                 <tr>
                                    <td><b/>Nationality</td>
                                    <td><input
                                            value="${cust.nationality}"
                                            name="nationality" type="text"  autocomplete="off" /></td>
                                </tr>
                                <tr>
                                    <td><b/>E-Mail</td>
                                    <td><input
                                            value="${cust.email}"
                                            name="email" type="text"  autocomplete="off" /></td>
                                </tr>
                                 <tr>
                                    <td><b/>Phone Number</td>
                                    <td><input
                                            value="${cust.phoneNumber}"
                                            name="phone" type="text"  autocomplete="off" /></td>
                                </tr>
                                <tr>
                                <td><input class="btn btn-primary btn-large" type="submit"
                                           value="Edit Account" /></td>
                            </tr>
                        </table>
                    </form>

                </article>
            </div>
            <div class="clear"></div>
            <jsp:include page="../modules/admin_footer.jsp" />
        </div>
    </body>
</html>


