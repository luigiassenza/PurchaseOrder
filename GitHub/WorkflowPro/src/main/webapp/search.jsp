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

<title>Search</title>
</head>
<body>
<center>
<div class="container">
	<h1>Search for...</h1>
	<table>
		<tr>
			<td colspan="2">
				<h5>Search by Name</h5>
			</td>
			<td width="10px">
			</td>
			<td colspan="3">
				<h5>Search by Date: From...              To...</h5>
			</td>
			<td width="10px">
			</td>
			<td colspan="2">
				<h5>Search for Anything...</h5>
			</td>
		</tr>
		<tr>
			<!-- Search by name -->
			<form action="WorkflowproSearchByName" method="get">
				<td>
					<select name="name" class="form-control">
						<option selected disabled>Name</option>
						<c:forEach items="${employees}" var="item">
							<option value="${item.name}">${item.name}</option>
						</c:forEach>
					</select>
				
				</td>		
				<td>
					<button class="btn btn-default" type="submit">Go!</button>	
				</td>
			</form>
			<!-- Black space -->
			<td width="10px">
			</td>
			<!-- Search by date -->
			<form action="WorkflowproSearchByDate" method="get">
				<td>
					<input type="date" name="start" class="form-control">
				</td>
				<td>
					<input type="date" name="end" class="form-control">
				</td>
				<td>
					<button class="btn btn-default" type="submit">Go!</button>	
				</td>
			</form>
			<!-- Black space -->
			<td width="10px">
			</td>
			<!-- Search by anything -->
			<form action="WorkflowproSearchByAll" method="get">
				<td>
					<input type="text" name="value" class="form-control" size="50" placeholder="Search for anything...">			
				</td>
				<td>
					<button class="btn btn-default" type="submit">Go!</button>
				</td>
			</form>
		</tr>
	</table>
<br>

	<!-- Search by Name -->

	<table class="table table-striped table-nonfluid table-bordered" style="width:auto">
		<c:if test="${not empty allName}">
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
		</c:if>
		<c:forEach items="${allName}" var="item">
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
        							<button class="btn btn-success" type="submit">Start</button>
        							<input type="hidden" name="id" value="${item.id}">
      							</span>
      							<span class="input-group-addon">
        							<button class="btn btn-danger" type="submit">End</button>
        							<input type="hidden" name="id" value="${item.id}">
      							</span>
      							<span class="input-group-addon">
      								<form action="WorkflowproUpdate" method="post">
	        							<button class="btn btn-warning" type="submit">Update</button>
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
	
	<!-- End Search by Name -->
	
	<!-- Search by Date -->

	<table class="table table-striped table-nonfluid table-bordered" style="width:auto">
		<c:if test="${not empty allDate}">
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
		</c:if>
		<c:forEach items="${allDate}" var="item">
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
        							<button class="btn btn-success" type="submit">Start</button>
        							<input type="hidden" name="id" value="${item.id}">
      							</span>
      							<span class="input-group-addon">
        							<button class="btn btn-danger" type="submit">End</button>
        							<input type="hidden" name="id" value="${item.id}">
      							</span>
      							<span class="input-group-addon">
      								<form action="WorkflowproUpdate" method="post">
	        							<button class="btn btn-warning" type="submit">Update</button>
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
	
	<!-- End Search by Date -->
	
	<!-- Search by Everything -->
		
	<table class="table table-striped table-nonfluid table-bordered" style="width:auto">
		<c:if test="${not empty all}">
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
		</c:if>
		<c:forEach items="${all}" var="item">
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
        							<button class="btn btn-success" type="submit">Start</button>
        							<input type="hidden" name="id" value="${item.id}">
      							</span>
      							<span class="input-group-addon">
        							<button class="btn btn-danger" type="submit">End</button>
        							<input type="hidden" name="id" value="${item.id}">
      							</span>
      							<span class="input-group-addon">
      								<form action="WorkflowproUpdate" method="post">
	        							<button class="btn btn-warning" type="submit">Update</button>
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
	
	<!-- End Search by Anything -->
	
	<br>
	
	<form action="WorkflowproUpdateBack" method="post">
		<button class="btn btn-default" type="submit">BACK</button>
     </form>
</div>
</center>

</body>
</html>