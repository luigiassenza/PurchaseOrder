<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<title>Order Form</title>
</head>
<body>
<center><h1><font color="chocolate">Purchase Order Form</font></h1></center>
<center>
Please fill out the form. For any query or problem please contact <a href="mailto:finance@company.com?Subject=Order%20Form%20Query">finance@adaptavist.com</a>
<br><br>
<form action="SaveOrders" method="post">
	<table class="table table-striped table-nonfluid table-bordered" style="width:auto">
		<tr>
			<td>Your name:</td>
			<td><input style="border:none" type="text" name="your_name" placeholder="Enter your full name" size="35" required></td>
		</tr>
		<tr>
			<td>Your email:</td>
			<td><input style="border:none" type="text" name="your_email" placeholder="Enter your email" size="35" required></td>
		</tr>
		<tr>
			<td>Approver name</td>
			<td><input style="border:none" type="text" name="approver_name" placeholder="Enter your approver's name" size="35" required></td>
		</tr>
		<tr>
			<td>Approver email:</td>
			<td><input style="border:none" type="text" name="approver_email" placeholder="Enter your approver's email" size="35" required></td>
		</tr>
		<tr>
			<td>Supplier name:</td>
			<td><input style="border:none" type="text" name="supplier_name" placeholder="Enter supplier name" size="35" required></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><textarea style="border:none" rows= "5" cols="31" name="description" placeholder="Enter a description of your purchase" required></textarea></td>
		</tr>
		<tr>
			<td>Currency:</td>
			<td>
				<select style="border:none" name="currency" required>
					<option value="GBP">GBP</option>
					<option value="EUR">EUR</option>
					<option value="USD">USD</option>
					<option value="CAD">CAD</option>
					<option value="AUD">AUD</option>
					<option value="CHF">CHF</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Net price:</td>
			<td><input style="border:none" type="text" name="net_price" placeholder="Enter net price (Excluding VAT)" size="35" required></td>
		</tr>
		<tr>
			<td>VAT:</td>
			<td><input style="border:none" type="text" name="vat" placeholder="Enter VAT amount" size="35" required></td>
		</tr>
		<tr>
			<td>Full price:</td>
			<td><input style="border:none" type="text" name="full_price" placeholder="Enter full price (including VAT)" size="35" required></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="SUBMIT" class="btn btn-warning"></td>
		</tr>
	</table>
</form>
</center>
</body>
</html>