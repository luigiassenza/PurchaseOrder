<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
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

<center>
<title>Asset Register</title>
</head>
<body>
	<div id="container">
	</div>
		<h3>Enter the details below</h3>
	<div>
		<form action="AssetSave" method="post">
			<table class="table table-striped table-nonfluid table-bordered" style="width:auto">
				<tr>
					<td>Device*:</td>
					<td><input type="text" name="device" class="form-control" style="border:none" placeholder="e.g. Laptop" required></td>
				</tr>
				<tr>
					<td>Type*:</td>
					<td><input type="text" name="type" class="form-control" style="border:none" placeholder="e.g. Macbook Pro 13" required></td>
				</tr>
				<tr>
					<td>Memory*:</td>
					<td><input type="text" name="memory" class="form-control" style="border:none" placeholder="e.g. 8GB" required></td>
				</tr>
				<tr>
					<td>Hard Disk*:</td>
					<td><input type="text" name="hd"class="form-control" style="border:none"  placeholder="e.g. 128GB" required></td>
				</tr>
				<tr>
					<td>Purchase Date*:</td>
					<td><input type="date" name="purchaseDate" class="form-control" style="border:none" required></td>
				</tr>
				<tr>
					<td>Currency*:</td>
					<td>
						<select name="currency" class="form-control" style="border:none"  required>
							<option disabled selected hidden value="">Select Currency</option>
							<option value="GBP">GBP</option>
							<option value="EUR">EUR</option>
							<option value="USD">USD</option>
							<option value="CAD">CAD</option>
							<option value="AUD">AUD</option>
							<option value="CHG">CHF</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Purchase Price*:</td>
					<td><input type="text" name="purchasePrice" class="form-control" style="border:none" placeholder="Purchase price" required></td>
				</tr>
				<tr>
					<td>Depreciation*:</td>
					<td><input type="text" name="depreciation" class="form-control" style="border:none" placeholder="Number of years: e.g. 3" required></td>
				</tr>
				<tr>
					<td>Employee:</td>
					<td><input type="text" name="employee" class="form-control" style="border:none" placeholder="Employee full name"></td>
				</tr>
				<tr>
					<td>Employee email:</td>
					<td><input type="text" name="email" class="form-control" style="border:none" placeholder="Employee's email"></td>
				</tr>
				<tr>
					<td>Department:</td>
					<td>
						<select name="department" class="form-control" style="border:none">
							<option disabled selected hidden>Select Department</option>
							<option value="Consulting">Consulting</option>
							<option value="Engineering">Engineering</option>
							<option value="Finance">Finance</option>
							<option value="Sales">Sales</option>
							<option value="Support">Support</option>
							<option value="Training">Training</option>
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="REGISTER" class="btn btn-primary"></td>
				</tr>
			</table>
		</form>
	</div>
</center>
</body>
</html>