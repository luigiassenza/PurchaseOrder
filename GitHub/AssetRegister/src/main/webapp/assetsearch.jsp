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


<title>Asset Search</title>
</head>
<body>

<div id="container">
	<div id="analysis" class="table-responsive">
		<center><h1>Asset Register</h1></center>
		<center>
		<table class="table table-striped table-nonfluid table-bordered" style="width:auto">
			<tr>
				<td>
					<form action="AssetNewRegister" method="post">
						<button type="submit" value="REGISTER NEW ASSET" class="btn btn-primary">REGISTER NEW ASSET</button>
					</form>
				</td>
				<td>
					---------------------------------------
				</td>
				<td>
					<form action="AssetSearch" method="get">
							<input type="text" name="searchName" placeholders="search"><br>
							<input type="radio" name="searchBy" value="device" checked="checked">Device<br>
							<input type="radio" name="searchBy" value="type">Type<br>
							<input type="radio" name="searchBy" value="employee">Employee<br>
							<button type="submit" value="SEARCH" class="btn btn-primary">SEARCH</button>							
					</form>
				</td>
			</tr>
		</table>
		</center>	
	</div>
	
	<div id="header">
	</div>
	
	<div id="main" class="table-responsive">
		<table class="table table-striped table-nonfluid table-bordered" style="width:auto">
		<tr>
				<th>ID</th>
				<th>Device</th>
				<th>Type</th>
				<th>Memory</th>
				<th>HD</th>
				<th>Purchase Date</th>
				<th>Currency</th>
				<th>Purchase Price</th>
				<th>Depreciation</th>
				<th>Employee</th>
				<th>Email</th>
				<th>Department</th>
				<th>Residual Amount</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${assetssearch}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.device}</td>
					<td>${item.type}</td>
					<td>${item.memory}</td>
					<td>${item.hd}</td>
					<td>${item.purchaseDate}</td>
					<td>${item.currency}</td>
					<td>${item.purchasePrice}</td>
					<td>${item.depreciation}</td>
					<td>${item.employee}</td>
					<td>${item.email}</td>
					<td>${item.department}</td>
					<td>${item.residualAmount}</td>
					<td>
						<form action ="AssetUpdate" method="get">
							<button type="submit" value="Update" class="btn btn-default"><span class="glyphicon glyphicon-file"></span>Update</button>
							<input type="hidden" name="id" value="${item.id}">
						</form>
						<form action="AssetDelete" method="get">
							<button type="submit" value="Delete" class="btn btn-default"><span class="glyphicon glyphicon-trash" ></span>Delete</button>
							<input type="hidden" name="id" value="${item.id}">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<h1>${message}</h1>
	</div>
</div>
</body>
</html>