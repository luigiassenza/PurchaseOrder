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

<script src="js/javascript.js"></script>

<title>Asset Register</title>
</head>
<body>

<div id="container">
	<div id="analysis">
		<center><h1>Asset Register</h1></center>
		<center>
		<table class="table table-striped table-nonfluid table-bordered" style="width:auto">
			<tr>
				<td style="vertical-align:middle">
					<form action="AssetNewRegister" method="post">
						<button type="submit" value="REGISTER NEW ASSET" class="btn btn-primary">REGISTER NEW ASSET</button>
					</form>
				</td>
				<td style="vertical-align:middle">
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
				<th style="vertical-align:middle">ID</th>
				<th style="vertical-align:middle">Device</th>
				<th style="vertical-align:middle">Type</th>
				<th style="vertical-align:middle">Memory</th>
				<th style="vertical-align:middle">HD</th>
				<th style="vertical-align:middle">Purchase Date</th>
				<th style="vertical-align:middle">Currency</th>
				<th style="vertical-align:middle">Purchase Price</th>
				<th style="vertical-align:middle">Depreciation</th>
				<th style="vertical-align:middle">Employee</th>
				<th style="vertical-align:middle">Email</th>
				<th style="vertical-align:middle">Department</th>
				<th style="vertical-align:middle">Residual Amount</th>
				<th style="vertical-align:middle">Action</th>
			</tr>
			<c:forEach items="${allassets}" var="item">
				<tr>
					<td style="vertical-align:middle">${item.id}</td>
					<td style="vertical-align:middle">${item.device}</td>
					<td style="vertical-align:middle">${item.type}</td>
					<td style="vertical-align:middle">${item.memory}</td>
					<td style="vertical-align:middle">${item.hd}</td>
					<td style="vertical-align:middle">${item.purchaseDate}</td>
					<td style="vertical-align:middle" align="center">${item.currency}</td>
					<td style="vertical-align:middle" align="right">${item.purchasePrice}</td>
					<td style="vertical-align:middle" align="center">${item.depreciation}</td>
					<td style="vertical-align:middle">${item.employee}</td>
					<td style="vertical-align:middle">${item.email}</td>
					<td style="vertical-align:middle">${item.department}</td>
					<td style="vertical-align:middle" align="right">${item.residualAmount}</td>
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
	</div>
</div>
${assetssearch}
<script>
	var num = document.getElementById("pp").innerHTML;
	document.getElementById("pp").innerHTML = numberFormat(num);
</script>
</body>
</html>