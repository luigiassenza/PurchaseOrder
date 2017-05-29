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

<title>Workflow Employees</title>
</head>
<body>
<center>
<div id="container">
		<h3>Modify employee</h3><br>
			
		<!-- Modify existing employee -->
		<table style="width:auto">
			<form action="WorkflowproEmployeeChangeDeleteModify" method="post">
				<tr>
				
					<td>Old Name:</td>
					<td>
						<input type="text" name="oldName" value="${oldName}" class="form-control" size="30" readonly>
					</td>
		  		</tr>
		  		<tr height="10">
		  		</tr>
		  		<tr>
		  			<td>Enter new name:</td>
		  			<td>
						<input type="text" name="newName" class="form-control" size="30" placeholder="Enter new name">
					</td>
		  		</tr>
		  		<tr height="10">
		  		<tr>
		  			<td></td>
		  			<td>
						<button class="btn btn-success" type="submit">Modify name</button> 
				  	</td>
		  		</tr>
		  	</form>
  		</table>
 <font color="red"><i>${messageModify}</i></font>
  
  		<br><br>
  		<form action="WorkflowproEmployeeChangeBack" method="post">
			<button class="btn btn-default" type="submit">BACK</button>
     	</form>
     	
	</div>
</center>
</body>
</html>