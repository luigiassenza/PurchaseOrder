<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Xero Callback</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load('current', {'packages':['corechart','bar','table']});
	google.charts.setOnLoadCallback(drawChartRev);
	google.charts.setOnLoadCallback(drawTableRev);
	//google.load("visualization", "1", {"callback" : drawChart});
	google.charts.setOnLoadCallback(drawChartExp);
	google.charts.setOnLoadCallback(drawTableExp);
	google.charts.setOnLoadCallback(drawTableMinMax);

	function drawChartRev() {
		
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Concact Name');
		data.addColumn('number', 'Amount Received');
		
			<c:forEach items="${revenueToDispaly}" var="item">
				data.addRow(['${item.contactName}', ${item.amountPaid}]);
			</c:forEach>
		
		var options = {
				title:'Amount Received',
				width:400,
				height:300,
				legend:{position:'none'},
				vAxis: { 
					maxValue:${maxValueChart},
					minValue:0
				}
		};
		
		var chart = new google.visualization.ColumnChart(document.getElementById('chart_rev'));
		chart.draw(data, options);
	}
	
	function drawTableRev() {
		
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Concact Name');
		data.addColumn('number', 'Amount Received');
		
			<c:forEach items="${revenueToDispaly}" var="item">
				data.addRow(['${item.contactName}', ${item.amountPaid}]);
			</c:forEach>
		
		var options = {
				title:'Amount Received',
				legend:{position:'none'}
		};
		
		var table = new google.visualization.Table(document.getElementById('table_rev'));
		table.draw(data, options);
	}
	
	function drawChartExp() {
		
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Concact Name');
		data.addColumn('number', 'Amount Paid');
		
			<c:forEach items="${expenseToDispaly}" var="item">
				data.addRow(['${item.contactName}', ${item.amountPaid}]);
			</c:forEach>
		
		var options = {
				title:'Amount Paid',
				width:400,
				height:300,
				legend:{position:'none'},
				vAxis: { 
					maxValue:${maxValueChart},
					minValue:0
				}
		};
		
		var chart = new google.visualization.ColumnChart(document.getElementById('chart_exp'));
		chart.draw(data, options);
	}
	
	function drawTableExp() {
		
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Concact Name');
		data.addColumn('number', 'Amount Paid');
		
			<c:forEach items="${expenseToDispaly}" var="item">
				data.addRow(['${item.contactName}', ${item.amountPaid}]);
			</c:forEach>
		
		var options = {
				title:'Amount Paid',
				
				legend:{position:'none'}
		};
		
		var table = new google.visualization.Table(document.getElementById('table_exp'));
		table.draw(data, options);
	}
	
	function drawTableMinMax() {
		
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Currency');
		data.addColumn('date', 'Starting Date');
		data.addColumn('date', 'Ending Date');
		data.addColumn('number', 'Amount >=');
		data.addColumn('number', 'Max Revenue');
		data.addColumn('number', 'Min Revenue');
		data.addColumn('number', 'Max Expense');
		data.addColumn('number', 'Min Expense');
		data.addColumn('number', 'Sum Revenue');
		data.addColumn('number', 'Sum Expense');
		data.addColumn('number', 'Net Result');
		data.addRow(['${currency}', new Date('${startingDateDisplay}'), new Date('${endingDateDisplay}'), ${amountGreater}, ${maxValueRev}, ${minValueRev}, ${maxValueExp}, ${minValueExp}, ${sumRev}, ${sumExp}, ${netResult}]);
		
		var options = {
				title:'Max and Min Amounts Received and Paid',
				legend:{position:'none'}
		};
		
		var table = new google.visualization.Table(document.getElementById('table_min_max'));
		table.draw(data, options);
	}
</script>

</head>


<body>

<div class="container"><h1>Xero API - Java</h1> 
	<div class="form-group">
		<a href="index.jsp" class="btn btn-default" type="button">Start</a>
	</div>
	<form action="./RequestResourceServlet" method="post">
		<div class="form-group"> 
	  		<label for="object">Account*</label>
	  			<select name="object" class="form-control" id="object" required>
	  				<option value="Accounts" selected>Accounts</option>
					<option value="Attachments">Attachments</option>
	  				<option value="BankTransactions">BankTransactions</option>
	  				<option value="BankTransfers">BankTransfers</option>
	  				<option value="BrandingThemes">BrandingThemes</option>
	  				<option value="Contacts">Contacts</option>
	  				<option value="ContactGroups">ContactGroups</option>
	  				<option value="ContactGroupContacts">ContactGroups Contacts</option>
	  				<option value="CreditNotes">CreditNotes</option>
	  				<option value="Currencies">Currencies</option>
	  				<option value="Employees">Employees</option>
	  				<option value="ExpenseClaims">ExpenseClaims</option>
	  				<option value="Invoices">Invoices</option>
	  				<option value="InvoiceReminders">InvoiceReminders</option>
	  				<option value="Items">Items</option>
	  				<option value="Journals">Journals</option>
	  				<option value="LinkedTransactions">LinkedTransactions</option>
	  				<option value="ManualJournals">ManualJournals</option>
	  				<option value="Organisations">Organisations</option>
	  				<option value="Overpayments">Overpayments</option>
	  				<option value="Payments">Payments</option>
	  				<option value="Prepayments">Prepayments</option>
	  				<option value="PurchaseOrders">PurchaseOrders</option>
	  				<option value="Receipts">Receipts</option>
	  				<option value="RepeatingInvoices">RepeatingInvoices</option>
	  				<option value="Reports">Reports</option>
	  				<option value="TaxRates">TaxRates</option>
	  				<option value="TrackingCategories">TrackingCategories</option>
	  				<option value="Users">Users</option>
	  				<option value="Errors">Errors</option>
	  			</select>
		</div>
		<div class="form-group">
			<label for="object">Starting date*</label>
			<input class="form-control" type="date" name="startingDate" required>
		</div>
		<div class="form-group">
			<label for="object">Ending date*</label>
			<input class="form-control" type="date" name="endingDate" required>
		</div>
		<div class="form-group">
			<label for="object">Amount greater than*</label>
			<input class="form-control" type="text" name="amountGreater" required>
		</div>
		<div class="form-group">
			<label for="object">Currency*</label>
			<select class="form-control" type="text" name="currency" required>
				<option value="GBP">GBP</option>
				<option value="EUR">EUR</option>
				<option value="USD">USD</option>
				<option value="CAD">CAD</option>
			</select>
		</div>
		<div class="form-group">
			<input class="btn btn-default" type="submit" value="Submit">
		</div>
	</form>
</div>
<center>
	<div id="table_min_max" style="border: 1px solid #ccc"></div>
<table>
	<tr>
		<th>REVENUES</th>
		<th>EXPENSES</th>
	</tr>
	<tr>
		<td>
			<div id="chart_rev" style="border: 1px solid #ccc"></div>
		</td>
		<td>
			<div id="chart_exp" style="border: 1px solid #ccc"></div>
		</td>
	</tr>
	<tr>
		<td style="vertical-align:top">
			<div id="table_rev" style="border: 1px solid #ccc"></div>		
		</td>
		<td style="vertical-align:top">
			<div id="table_exp" style="border: 1px solid #ccc"></div>		
		</td>
	</tr>
</table>
</center>
</body>
</html>