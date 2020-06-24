<%@page import="com.bank.api.Accounts"%>
<%@page import="com.bank.api.Customers"%>
<%@page import="com.bank.api.Account"%>
<%@page import="com.bank.api.Customer"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>User Account</title>
        <link rel="shortcut icon" href="JSP/Website/resources/images/molecue.png"
              type="image/x-icon" />
        <link href="JSP/Website/resources/css/jquery-ui-1.10.3.min.css"
              rel="stylesheet" media="screen" />
        <link href="JSP/Website/resources/css/flaty.bootstrap.min.css"
              rel="stylesheet" media="screen" />
        <link href="JSP/Website/resources/css/application_admin.css"
              rel="stylesheet" media="screen" />

        <script src="JSP/Website/resources/js/jquery-1.10.1.js"></script>
        <script src="JSP/Website/resources/js/jquery-ui-1.10.3.js"></script>
        <script src="JSP/Website/resources/js/bootstrap.js"></script>
        <script src="JSP/Website/resources/js/application.js"></script>
    </head>
    <body>
        <%
                       String cst =  request.getParameter("customer_id");
                        request.setAttribute("customer", cst );
                        
              
               
            %>
        <div id="page_container">
            
            <jsp:include page="modules/site_header.jsp" />
            <div id="body" class="container-fuid">
                <jsp:include page="modules/site_sidebar.jsp" />
                <article id="content" class="span9">
                    <jsp:include page="modules/site_message.jsp" />
                   <h2> ${customer_id} </h2>
                   
                    <jsp:include page="site/dashboard.jsp" />
                </article>
            </div>
            <div class="clear"></div>
            <jsp:include page="modules/site_footer.jsp" />
        </div>
    </body>
</html>