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
<title>Workflow Update</title>
</head>
<body>
<div id="container">
	</div>
		<h3>Enter the details below</h3>
	<div>
		<form action="WorkflowproUpdateRegister" method="post">
			<table class="table table-striped table-nonfluid table-bordered" style="width:auto">
			<c:forEach items="${details}" var="item">
				
				<tr>
					<td style="vertical-align:middle">Name:</td>
					<td><select name="name" class="form-control">
							<option value="${item.name}">${item.name}</option>
							<c:forEach items="${employees}" var="item2">
								<option value="${item2.name}">${item2.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td style="vertical-align:middle" >Task:</td>
					<td><input type="text" name="task" class="form-control" style="border:none" value="${item.task}"></td>
				</tr>
				<tr>
					<td style="vertical-align:middle">Status:</td>
					<td><input type="text" name="status" class="form-control" style="border:none" value="${item.status}" readonly></td>
				</tr>
				<tr>
					<td style="vertical-align:middle">Date:</td>
					<td><input type="date" name="end" class="form-control" style="border:none" value="${item.end}" readonly></td>
				</tr>
				<tr>
					<td style="vertical-align:middle" >Comments:</td>
					<td><textarea name="comments" class="form-control" style="border:none" value="${item.comments}">${item.comments}</textarea></td>
				</tr>
				<tr>
					<td style="vertical-align:middle">Action:</td>
					<td>
						<div class="row">
							<div class="col-lg-8">
								<div class="input-group">
									<span class="input-group-addon">
										<form action="WorkflowproTaskStart" method="post">
											<button type="submit" name="start" value="Start" class="btn btn-success">Start</button>
											<input type="hidden" name="id" value="${item.id}">
										</form>
									</span>
									<span class="input-group-addon">
										<form action="WorkflowproTaskEnd" method="post">
											<button type="submit" name="end" value="End" class="btn btn-danger">End</button>
											<input type="hidden" name="id" value="${item.id}">
										</form>
									</span>
								</div><!-- /input-group -->
							</div><!-- /col-lg-6 -->
						</div><!-- /row -->
					</td>
				</tr>
				
				
						<tr>
							<td><input type="hidden" name="id" value="${item.id}"></td>
							<td><input type="submit" value="UPDATE" class="btn btn-warning"></td>
						</tr>
					</table>
				</form>
				<form action="WorkflowproUpdateBack" method="post">
					<input type="submit" value="BACK" class="btn btn-default">
				</form>
		</c:forEach>
	</div>
</center>
</body>
</html>