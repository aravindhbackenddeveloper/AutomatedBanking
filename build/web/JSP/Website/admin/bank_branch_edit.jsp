<%@page import="com.bank.api.BankBranch"%>
<%@page import="com.bank.api.BankBranches"%>
<%@page import="com.bank.api.Bank"%>
<%@page import="com.database.bank.RegisterData"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
              String ifsccode=request.getParameter("ifsccode");
              BankBranches  branches = new BankBranches();
              branches.getBranchList(RegisterData.getBranch());
             BankBranch branch =  branches.getBranch(ifsccode);
             request.setAttribute("branch", branch);
             request.setAttribute("ifsccode", ifsccode);
         %>
        <div id="page_container">
            <jsp:include page="../modules/admin_header.jsp" />
            <div id="body" class="container-fuid">
                <jsp:include page="../modules/admin_sidebar.jsp" />
                <article id="content" class="span9">
                    <jsp:include page="../modules/admin_message.jsp" />
                    <h3>Bank Branch List</h3>


                    <form name="form-customer" id="form-customer"
                          action="../../../Edit_Branch?ifsccode=${ifsccode}"
                          method="post">
                        <table class="table">
                            <tr>
                                <td><b/>IFSC Code</td>
                                <td>${branch.ifsc_code}
                                    </td>
                                </tr>
                                <tr>
                                    <td><b/>Branch Name</td>
                                    <td><input value="${branch.branch_Name}" name="name" type="text" autocomplete="off"
                                           required="required" placeholder="Branch Name" /></td>
                            </tr>
                            <tr>
                                <td><b/>Branch Location</td>
                                <td><textarea name="location" type="textarea" autocomplete="off"
                                              required="required" placeholder="Description">${branch.location}</textarea></td>
                            </tr>
                            <tr>
                                <td><input class="btn btn-primary btn-large" type="submit"
                                           value="EDIT" /></td>
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


