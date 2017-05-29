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

<title>Workflow Pro Management</title>
</head>
<body>
<center>
<div class="container">
<h1>Workflow Management</h1>
	<table>
		<tr>
			<td>
				<form action="WorkflowproNewTask" method="post">
					<input type="submit" class="btn btn-primary" name="newTask" value="New Task" style="width:100px">
				</form>
			</td>
			<td>
				<form action="WorkflowproChartDisplay" method="post" target="_blank">
					<input type="submit" class="btn btn-primary" name="chart" value="Chart" style="width:100px">
				</form>
			</td>
			<td>
				<form action="WorkflowproSearchPage" method="post">
					<input type="submit" class="btn btn-primary" name="search" value="Search" style="width:100px">
				</form>
			</td>
			<td>
				<form action="WorkflowproEmployee" method="post">
					<input type="submit" class="btn btn-primary" name="employee" value="Employee" style="width:100px">
				</form>
			</td>
		</tr>
	</table>	
	<br>
	<table class="table table-striped table-nonfluid table-bordered" style="width:auto">
		
			<tr>
				<th style="vertical-align:middle">ID</th>
				<th style="vertical-align:middle">Name</th>
				<th style="vertical-align:middle">Task</th>
				<th style="vertical-align:middle">Start</th>
				<th style="vertical-align:middle">End</th>
				<th style="vertical-align:middle">Status</th>
				<th style="vertical-align:middle">Comments</th>
				<th style="vertical-align:middle">Action</th>
			</tr>
		<c:forEach items="${workflowspro}" var="item">
			<tr>
				<td style="vertical-align:middle">${item.id}</td>
				<td style="vertical-align:middle">${item.name}</td>
				<td style="vertical-align:middle">${item.task}</td>
				<td style="vertical-align:middle">${item.start}</td>
				<td style="vertical-align:middle">${item.end}</td>
				<td style="vertical-align:middle">${item.status}</td>
				<td style="vertical-align:middle">${item.comments}</td>
				<td>
					<div class="row">
						<div class="col-lg-6">
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
								<span class="input-group-addon">
									<form action="WorkflowproUpdate" method="post">
										<button type="submit" name="update" value="Update" class="btn btn-warning">Update</button>
										<input type="hidden" name="id" value="${item.id}">
									</form>
								</span>
							</div><!-- /input-group -->
						</div><!-- /col-lg-6 -->
					</div><!-- /row -->
				</td>
			</tr>
		</c:forEach>
	</table>
</center>
</div>
</body>
</html>