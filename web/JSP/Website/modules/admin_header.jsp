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
                    
                    <li class="dropdown"><a data-toggle="dropdown"
                                            class="dropdown-toggle" href="#"><b>Customer </b><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            
                            <li><a
                                    href="http://localhost:8082/AutomatedBanking/JSP/Website/admin/customer_list.jsp"><b>Customer
                                        List</b></a></li>
                            <li><a
                                    href="${page.url_host}${page.url_apppath}admin/customer/new"><b>Create
                                        New Customer</b></a></li>
                            <li><a
                                    href="http://localhost:8082/AutomatedBanking/JSP/Website/admin/customer_search.jsp"><b>Search
                                        Customer</b></a></li>
                        </ul></li>
                    <li class="dropdown"><a data-toggle="dropdown"
                                            class="dropdown-toggle" href="#"><b>Banking Account</b><b
                                class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a
                                    href="http://localhost:8082/AutomatedBanking/JSP/Website/admin/create_account.jsp"><b>Create
                                        New Account</b></a></li>
                            <li><a
                                    href="http://localhost:8082/AutomatedBanking/JSP/Website/admin/account_search.jsp"><b>Search
                                        Account</b></a></li>
                        </ul></li>
                        
                    <li class="dropdown"><a data-toggle="dropdown"
                                            class="dropdown-toggle" href="#"><b>Bank Branch</b><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            
                            <li><a
                                    href="http://localhost:8082/AutomatedBanking/JSP/Website/admin/add_branch.jsp"><b>Add
                                        New Bank Branch</b></a></li>
                        </ul></li>
                </ul>
                <ul class="nav pull-right">
                    
                    <li class="divider-vertical"></li>
                    <li class="dropdown"><a data-toggle="dropdown"
                                            class="dropdown-toggle" href="#"><b>Administrator </b><b
                                class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li class="divider"></li>
                            <li><a href="http://localhost:8082/AutomatedBanking/"><b>Logout</b></a></li>
                        </ul></li>
                </ul>
            </div>
            <!-- /.nav-collapse -->
        </div>
    </div>

</header>