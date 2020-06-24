<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <div id="page_container">
            <jsp:include page="../modules/admin_header.jsp" />
            <div id="body" class="container-fuid">
                <jsp:include page="../modules/admin_sidebar.jsp" />
                <article id="content" class="span9">
                    <jsp:include page="../modules/admin_message.jsp" />
                    <h2>Add New Branch </h2>
                    <form name="form-customer" id="form-customer"
                          action="../../../addbranch"
                          method="post">
                        <table class="table">
                            
                                <tr>
                                    <td>Branch Name</td>
                                    <td><input  name="name" type="text" autocomplete="off"
                                           required="required" placeholder="Branch Name" /></td>
                            </tr>
                            <tr>
                                <td>Branch Location</td>
                                <td><textarea name="location" type="textarea" autocomplete="off"
                                              required="required" placeholder="Description"></textarea></td>
                            </tr>
                           
                            <tr>
                                <td><input class="btn btn-primary btn-large" type="submit"
                                           value="ADD" /></td>
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


