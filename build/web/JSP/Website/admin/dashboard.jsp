<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="dashboard">
    <h3>${Message}</h3>
	<div class="row">
		<a  class="span4"href="JSP/Website/admin/create_account.jsp"> <img class="img-circle"
			src="JSP/Website/resources/images/user_add.png" style="width: 120px;" />
			<br />
		<h5>New Customer Account</h5>
		</a> <a class="span4" href="JSP/Website/admin/account_search.jsp"> <img class="img-circle"
			src="JSP/Website/resources/images/user_search.png" style="width: 120px;" />
			<br />
                        <h5 >Search Customer Account</h5>
		</a>
	</div>
	<div class="row">
		<a  class="span4"href="JSP/Website/admin/account_edit.jsp"> <img src="JSP/Website/resources/images/new_file.png"
			style="width: 80px;" /> <br />
		<h5>New Bank Account</h5>
		</a> <a class="span4" href="JSP/Website/admin/customer_search.jsp"> <img src="JSP/Website/resources/images/search.png"
			style="width: 80px;" /> <br />
		<h5>Search Bank Account</h5>
		</a>

	</div>
</div>