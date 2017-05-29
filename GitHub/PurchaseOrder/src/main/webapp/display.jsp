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

<title>Orders List</title>
</head>
<body>
<center>

<h1><font color="chocolate">Order List</font></h1>

<table class="table table-striped table-nonfluid table-bordered" style="width:auto">
	<tr>
		<th>ID</th>
		<th>Date</th>
		<th>Sender Name</th>
		<th>Sender Email</th>
		<th>Approver Name</th>
		<th>Approver Email</th>
		<th>Supplier Name</th>
		<th>Description</th>
		<th>Currency</th>
		<th>Net Price</th>
		<th>VAT</th>
		<th>Full Price</th>
		<th>Approval</th>
		<th>Comments</th>
			<c:forEach items="${allorders}" var="item">
			<tr>
				<td style="vertical-align:middle">${item.id}</td>
				<td style="vertical-align:middle">${item.date}</td>
				<td style="vertical-align:middle">${item.yourName}</td>
				<td style="vertical-align:middle">${item.yourEmail}</td>
				<td style="vertical-align:middle">${item.approverName}</td>
				<td style="vertical-align:middle">${item.approverEmail}</td>
				<td style="vertical-align:middle">${item.supplierName}</td>
				<td style="vertical-align:middle">${item.description}</td>
				<td style="vertical-align:middle">${item.currency}</td>
				<td style="vertical-align:middle">${item.netPrice}</td>
				<td style="vertical-align:middle">${item.vat}</td>
				<td style="vertical-align:middle">${item.fullPrice}</td>
				<td style="vertical-align:middle">${item.approval}</td>
				<td style="vertical-align:middle">${item.comments}</td>
			</tr>
			</c:forEach>
</table>
</center>
</body>
</html>