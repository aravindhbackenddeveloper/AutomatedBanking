<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<aside id="side_bar" class="span5">
    <ul id="admin_menu">
      
        <li>
            <a class="btn btn-primary btn-large" 
               href="http://localhost:8082/AutomatedBanking/JSP/Website/site/bank_account_list.jsp?customer_id=${customer_id}">
                <b>Account Details</b></a>
             </li>
       
        <li>
            
            <a class="btn btn-primary btn-large" 
               href="http://localhost:8082/AutomatedBanking/JSP/Website/site/deposit_account.jsp?customer_id=${customer_id}">
                <b>Deposit Account</b></a>
        </li>
       
        <li>
            <a class="btn btn-primary btn-large"  
               href="http://localhost:8082/AutomatedBanking/JSP/Website/site/create_account.jsp?customer_id=${customer_id}">
                <b>Account Applications</b></a>
        </li>
        <li>
            <a class="btn btn-primary btn-large" 
               href="http://localhost:8082/AutomatedBanking/JSP/Website/site/deposit_application.jsp?customer_id=${customer_id}">
                <b>Deposit Applications</b></a>
        </li>
    </ul>
</aside>    