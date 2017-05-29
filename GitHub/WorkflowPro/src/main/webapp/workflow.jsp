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

<title>Workflow Management</title>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

      // Load the Visualization API and the controls package.
      google.charts.load('current', {'packages':['corechart', 'controls']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawDashboard);

      // Callback that creates and populates a data table,
      // instantiates a dashboard, a range slider and a pie chart,
      // passes in the data and draws it.
      function drawDashboard() {

        // Create our data table.
        var data = new google.visualization.DataTable();
			data.addColumn({ type: 'string', id: 'Position' });
		  data.addColumn({ type: 'string', id: 'Name' });
		  data.addColumn({ type: 'date', id: 'Start' });
		  data.addColumn({ type: 'date', id: 'End' });
		  <c:forEach items="${workflows}" var="item">
			  data.addRows([
				[ '${item.name}', '${item.task} (${item.status})', new Date(${item.yearStart}, ${item.monthStart}, ${item.dayStart}, ${item.hourStart},${item.minuteStart}), new Date(${item.yearEnd}, ${item.monthEnd}, ${item.dayEnd}, ${item.hourEnd}, ${item.minuteEnd})],
				   ]);
		  </c:forEach>

        // Create a dashboard.
        var dashboard = new google.visualization.Dashboard(
            document.getElementById('dashboard_div'));

        // Create a range slider, passing some options
        var timeRangeSlider = new google.visualization.ControlWrapper({
          'controlType': 'ChartRangeFilter',
          'containerId': 'filter_div',
          'options': {
			
            filterColumnIndex: 2, // filter on start date
            ui: {
                chartOptions: {
                    height: 50,
                    width: '90%'
                },
                chartView: {
                    columns: [2, {
                        // create en empty column to serve as the line series in the control
                        // since there is no real meaning to having a line in here
                        type: 'number',
                        calc: function () {return 0;}
                    }]
                }
            }
          }
        });

        // Create a pie chart, passing some options
        var timeChart = new google.visualization.ChartWrapper({
          'chartType': 'Timeline',
          'containerId': 'chart_div',
          'options': {
            'width': 1300,
            'height': 450,
            'pieSliceText': 'value',
            'legend': 'right'
          }
        });
		var rowHeight  = (data.getNumberOfRows() + 1)  * 50;

        // Establish dependencies, declaring that 'filter' drives 'pieChart',
        // so that the pie chart will only display entries that are let through
        // given the chosen slider range.
        dashboard.bind(timeRangeSlider, timeChart);
		
		
        // Draw the dashboard.
        dashboard.draw(data);
      }
    </script>

</head>
<body>
<center>
<h1>Workflow Management</h1>
</center>
<center>
	<div id="dashboard_div">
      <!--Divs that will hold each control and chart-->
      
      <div id="chart_div"></div>
	  <div id="filter_div"></div>
    </div>
 </center>
 
 <br>
 
<center> 


<br>
<div class="row">
	<div class="col-md-1">
	</div>
    <div class="col-md-3 col-centered" >
    	<h4>Summary by Status</h4>
    	<table class="table table-striped table-nonfluid table-bordered table-condensed text-center" style="width:auto">
    		<tr>
    			<th>Status</th>
    			<th>#</th>
    		</tr>
				<c:forEach items="${statusDetail}" var="item">
					<tr>
 			    		<td>${item.status}</td>
 			    		<td>${item.count}</td>
 			    	</tr>
				</c:forEach>
		</table>
    </div>
    <div class="col-md-3 col-centered col-centered">
    	<h4>Summary by Name and Status</h4>
    	<table class="table table-striped table-nonfluid table-bordered table-condensed text-center" style="width:auto">
			<tr>
				<th>Name</th>
				<th>Status</th>
				<th>#</th>
			</tr>
			<c:forEach items="${statusNameDetail}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.status}</td>
					<td>${item.count}</td>
				</tr>
			</c:forEach>
		</table>
    </div>
    <div class="col-md-3 col-centered">
    	<h4>Summary by Name and Status (Outstanding)</h4>
    	<table class="table table-striped table-nonfluid table-bordered table-condensed text-center" style="width:auto">
			<tr>
				<th>Name</th>
				<th>Status</th>
				<th>#</th>
			</tr>
			<c:forEach items="${statusNameDetailOutstanding}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.status}</td>
					<td>${item.count}</td>
				</tr>
			</c:forEach>
		</table>
    </div>
</div>

</center>
</body>
</html>