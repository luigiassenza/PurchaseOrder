<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>Asset Update</title>
</head>
<body>
<div id="container">
	</div>
		<h3>Enter the details below</h3>
	<div>
		<form action="AssetUpdateSave" method="get">
			<table class="table table-striped table-nonfluid table-bordered" style="width:auto">
			<c:forEach items="${asset}" var="item">
				<tr>
					<td></td>
					<td><input type="hidden" name="id" value="${item.id}"></td>
				</tr>
				<tr>
					<td>Device:</td>
					<td><input type="text" name="device" class="form-control" style="border:none" value="${item.device}"></td>
				</tr>
				<tr>
					<td>Type:</td>
					<td><input type="text" name="type" class="form-control" style="border:none" value="${item.type}"></td>
				</tr>
				<tr>
					<td>Memory:</td>
					<td><input type="text" name="memory" class="form-control" style="border:none" value="${item.memory}"></td>
				</tr>
				<tr>
					<td>Hard Disk:</td>
					<td><input type="text" name="hd" class="form-control" style="border:none" value="${item.hd}"></td>
				</tr>
				<tr>
					<td>Purchase Date:</td>
					<td><input type="date" name="purchaseDate" class="form-control" style="border:none" value="${item.purchaseDate}"></td>
				</tr>
				<tr>
					<td>Currency:</td>
					<td>
						<select name="currency" class="form-control" style="border:none">
							<option value="${item.currency}">${item.currency}</option>
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
					<td>Purchase Price:</td>
					<td><input type="text" name="purchasePrice" class="form-control" style="border:none" value="${item.purchasePrice}"></td>
				</tr>
				<tr>
					<td>Depreciation:</td>
					<td><input type="text" name="depreciation" class="form-control" style="border:none" value="${item.depreciation}"></td>
				</tr>
				<tr>
					<td>Employee:</td>
					<td><input type="text" name="employee" class="form-control" style="border:none" value="${item.employee}"></td>
				</tr>
				<tr>
					<td>Employee email:</td>
					<td><input type="text" name="email" class="form-control" style="border:none" value="${item.email}"></td>
				</tr>
				<tr>
					<td>Department:</td>
					<td>
						<select name="department"class="form-control" style="border:none" >
							<option value="${item.department}">${item.department}</option>
							<option value="engineering">Consulting</option>
							<option value="finance">Engineering</option>
							<option value="sales">Finance</option>
							<option value="consulting">Sales</option>
							<option value="training">Support</option>
							<option value="support">Training</option>
						</select>
					</td>
				</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td><input type="submit" value="UPDATE" class="btn btn-primary"></td>
				</tr>
			</table>
		</form>
	</div>
</center>
</body>
</html>