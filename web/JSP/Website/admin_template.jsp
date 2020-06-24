<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title><c:out value="${page.page_title}" /></title>
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
        <div id="page_container">
            <jsp:include page="modules/admin_header.jsp" />
            <div id="body" class="container-fuid">
                <jsp:include page="modules/admin_sidebar.jsp" />
                <article id="content" class="span9">
                    <jsp:include page="modules/admin_message.jsp" />
                    <jsp:include page="admin/dashboard.jsp" />
                </article>
            </div>
            <div class="clear"></div>
            <jsp:include page="modules/admin_footer.jsp" />
        </div>
    </body>
</html>