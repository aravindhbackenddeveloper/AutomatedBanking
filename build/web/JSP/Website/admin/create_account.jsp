<%@page import="com.bank.api.BankBranch"%>
<%@page import="com.bank.api.Bank"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bank.api.BankBranches"%>
<%@page import="com.database.bank.RegisterData"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Account</title>
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
            <jsp:include page="../modules/admin_header.jsp" />
            <div id="body" class="container-fuid">
                <jsp:include page="../modules/admin_sidebar.jsp" />
                <article id="content" class="span9">
                    <jsp:include page="../modules/admin_message.jsp" />
                    <h3>New Account</h3>

                    <form name="form-customer" id="form-customer"
                          action="../../../Create_Account"
                          method="post">
                        <table class="table">
                            
                                <tr>
                                    <td>Account Holder Name</td>
                                    <td><input
                                        value="<c:if test="${data.pin != 0}">${data.pin}</c:if>" name="name" autocomplete="off"
                                            type="text" /></td>
                            </tr>
                            <tr>
                                <td>Security PIN</td>
                                <td><input
                                        value="<c:if test="${data.pin != 0}">${data.pin}</c:if>" name="pin" autocomplete="off"
                                            type="text" placeholder="Security Pin" /></td>
                                </tr>
                                <tr>
                                    <td>Date Of Birth</td>
                                    <td><input type="date" id="birthday" name="birthday"></td>
                                </tr>
                                 <tr>
                                    <td>Date Of Join</td>
                                    <td><input type="date" id="doj" name="doj"></td>
                                </tr>
                                  <tr>
                                    <td>Gender</td>
                                    <td><select name="gender_type">
                                            <option value="">- Select One -</option>
                                            <option value="Male">Male</option>
                                            <option value="Female">Female</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Address</td>
                                    <td><input
                                            value="<c:if test="${data.amount != ''}">${data.amount}</c:if>"
                                            name="address" type="text"  autocomplete="off" /></td>
                                </tr>
                                 <tr>
                                    <td>Nationality</td>
                                    <td><input
                                            value="<c:if test="${data.amount != ''}">${data.amount}</c:if>"
                                            name="nationality" type="text"  autocomplete="off" /></td>
                                </tr>
                                <tr>
                                    <td>E-Mail</td>
                                    <td><input
                                            value="<c:if test="${data.amount != ''}">${data.amount}</c:if>"
                                            name="email" type="text"  autocomplete="off" /></td>
                                </tr>
                                 <tr>
                                    <td>Phone Number</td>
                                    <td><input
                                            value="<c:if test="${data.amount != ''}">${data.amount}</c:if>"
                                            name="phone" type="text"  autocomplete="off" /></td>
                                </tr>
                                <tr>
                                    <td>Account Type</td>
                                    <td><select name="account_type" placeholder="Account Type">
                                            <option value="">- Select One -</option>
                                            <option
                                            <c:if test="${data.account_type == 1}">selected="selected"</c:if>
                                                value="Salary Account">Salary Account</option>
                                            <option
                                            <c:if test="${data.account_type == 2}">selected="selected"</c:if>
                                                value="Saving Account">Saving Account</option>
                                        </select></td>
                                </tr>
                                <%
                                    BankBranches branches = new BankBranches();
                                    branches.getBranchList( RegisterData.getBranch() );
                                    ArrayList<BankBranch> branchList = branches.branches;
                                    request.setAttribute("branchlist", branchList);
                                    

                                %>
                                <tr>
                                    <td>Account Branch</td>
                                    <td><select name="branchlist" placeholder="Account Type">
                                            <option value="">- Select One -</option>
                                            <c:forEach items="${branchlist}" var="branch">
                                                <option  selected="selected" value="${branch.ifsc_code}">${branch.ifsc_code}</option>     
                                            </c:forEach>
                                            
                                        </select></td>
                                </tr>
                                 <tr>
                                    
                                <td><input class="btn btn-primary btn-large" type="submit"
                                           value="Create Account" /></td>
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


