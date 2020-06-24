<%@page import="com.database.bank.RegisterData"%>
<%@page import="com.bank.api.BankBranches"%>
<%@page import="com.bank.api.BankBranches"%>
<%@page import="com.bank.api.BankBranch"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
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
            ArrayList<BankBranch> list = new ArrayList<>();
            BankBranches branches = new BankBranches();
            list  =  branches.getBranchList(RegisterData.getBranch());
            request.setAttribute("branchList", list);
            %>
        <div id="page_container">
            <jsp:include page="../modules/admin_header.jsp" />
            <div id="body" class="container-fuid">
                <jsp:include page="../modules/admin_sidebar.jsp" />
                <article id="content" class="span9">
                    <jsp:include page="../modules/admin_message.jsp" />
                    <h3>Bank Branch List</h3>

                    <table class="table">
                        <thead>
                        <th>IFSC CODE</th>
                        <th>Name</th>
                        <th>Location</th>
                        <th></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${branchList}" var="bank_branch">
                                <tr>
                                    <td>${bank_branch.getIfsc_code()}</td>
                                    <td>${bank_branch.getBranch_Name()}</td>
                                    <td>${bank_branch.getLocation()}</td>
                                    <td><a class="btn btn-small" style="width: 50px;"
                                           href="bank_branch_edit.jsp?ifsccode=${bank_branch.getIfsc_code()}">Edit</a>
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

