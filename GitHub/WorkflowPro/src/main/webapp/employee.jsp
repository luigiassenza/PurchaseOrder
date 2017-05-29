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
		<h3>Enter or delete employees</h3><br>
		
	<h4>Register a new employee</h4>	
		<!-- Register a new employee -->
		<table style="width:auto">
			<tr>
				<form action="WorkflowproEmployeeRegister" method="post">
					<td>
						<input type="text" name="name" class="form-control" size="30" placeholder="Enter new employee's name">
					</td>
					<td width="10">
					<td>
						<button class="btn btn-success" type="submit">Enter</button> 
				  	</td>
			  	</form>
		  	</tr>
  		</table>
<font color="red"><i>${message}</i></font>
<br><br>

		<h4>Modify or delete an existing employee</h4>
		<!-- Change and Delete -->
		<table  style="width:auto">
				<form action="WorkflowproEmployeeChangeDelete" method="post">
					<tr>
						<td style="vertical-align:middle">Name:</td>
						<td width="10">
						<td>				
      								<select name="oldName" class="form-control">
      									<option disabled selected hidden>Employee Name</option>
										<c:forEach items="${employees}" var="item">
											<option value="${item.name}">${item.name}</option>
										</c:forEach>
									</select>		
      					</td>
      					<td width="10">
      					<td>			
	        				<button name="action" value="change" class="btn btn-warning" type="submit">Change</button>		
      					</td>
      					<td width="10">
      					<td>		
	        				<button name="action" value="delete" class="btn btn-danger" type="submit">Delete</button>
						</td>
					</tr>
				</form>
		</table>
<font color="red"><i>${messageDelete}</i></font>
<br><br>
		<form action="WorkflowproUpdateBack" method="post">
			<button class="btn btn-default" type="submit">BACK</button>
     	</form>
	
	</div>
</center>
</body>
</html>