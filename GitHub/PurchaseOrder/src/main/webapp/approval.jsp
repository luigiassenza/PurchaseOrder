<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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

<title>Approval</title>
</head>
<body>

	<%
		if(session.getAttribute("securityKey")==null)
		{
			response.sendRedirect("index.jsp");
		}
	%>

<center>
<h3><font color="chocolate">Summary of the purchase</font></h3>
<table class="table table-striped table-nonfluid table-bordered" style="width:auto" >
	<c:forEach items="${approvalOrder}" var="item">
		<tr>
			<td>ID:</td><td>${item.id}</td>
		</tr>
		<tr>
			<td>Requested by:</td><td> ${item.yourName}</td>
		</tr>
		<tr>
			<td>Supplier name:</td><td>${item.supplierName}</td>
		</tr>
		<tr>
			<td>Description:</td><td> ${item.description}</td>
		</tr>
		<tr>
			<td>Currency:</td><td>${fn:toUpperCase(item.currency)}</td>
		</tr>
		<tr>
			<td>Net price:</td><td>${item.netPrice}</td>
		</tr>
		<tr>
			<td>VAT:</td><td>${item.vat}</td>
		</tr>
		<tr>
			<td>Full price:</td><td>${item.fullPrice}</td>
		</tr>
	</c:forEach>
</table>

<br><br>

<h3><font color="chocolate">Approve or reject the purchase</font></h3>

<form action="GetApproval" method="post">
	<table class='table table-borderless table-condensed' style="width:auto">
		<tr>
			<td rowspan="2" style="vertical-align:middle">Approve or reject</td>
			<td><input type="radio" name="approval" value="approved">Approved
		</tr>
		<tr>
				<td><input type="radio" name="approval" value="rejected">Rejected</td>
		</tr>
		<tr>
			<td>Comments:</td><td><textarea rows="5" cols="35" name="comments" placeholder="Enter any comment you would like to add"></textarea></td>
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