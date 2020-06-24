<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="navbar" id="header">
    <div class="navbar-inner">
        <div style="width: auto;" class="container">
            <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar"> <span class="icon-bar"></span>
                <span    class="icon-bar"></span> <span class="icon-bar"></span>
            </a> 
            <a href="http://localhost:8082/AutomatedBanking/" class="brand"><b>CICICI Bank</b></a>
            <div class="nav-collapse">
                <ul class="nav">
                     <li ><a 
                       href="http://localhost:8082/AutomatedBanking/JSP/Website/site/transfer_amount.jsp?customer_id=${customer_id}">
                            <b>Transfer Amount </b><b class="caret"></b></a>
                       </li>
                   
                </ul>
               <ul class="nav pull-right">
                    
                    <li class="divider-vertical"></li>
                     <li><a href="http://localhost:8082/AutomatedBanking/"><b>Logout</b></a></li>
                </ul>
            </div>
            <!-- /.nav-collapse -->
        </div>
    </div>

</header>