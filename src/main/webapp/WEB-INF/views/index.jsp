<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
  <title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href= "https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> 
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

  <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400&display=swap" rel="stylesheet">
  <style>

    body
{
    counter-reset: Serial;           /* Set the Serial counter to 0 */
}

table
{
    border-collapse: separate;
}

tr td:first-child:before
{
  counter-increment: Serial;      /* Increment the Serial counter */
  content: counter(Serial); /* Display the counter */
}
  </style>

  <script type="text/javascript">
  function empty() {
	    var x;
	    x = document.getElementById("task").value;
	    if (x == "") {
	        alert("Enter a Valid task");
	        return false;
	    };
	}
  </script>
</head>
<body> 
		<% response.setHeader("Paragma", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Expires", "0");
		response.setDateHeader("Expires", -1);
		%>
		
    <div class="container-fluid " style="text-align: center; background-color: #4a148c;color: #ffffff;padding: 8px;font-family: 'Roboto', sans-serif;">
      <h4>TO-DO</h4>
    </div> 

    <div class="container-fluid shadow p-3 mb-5  bg-white rounded" style="width: 90%; margin-top: 4%;">
                
                <form class="form-inline" action="save" method="POST" style="padding: 1.7%">
                  <div class="form-group" style="width: 70%;margin-right: 2%">
                    <input type="text" class="form-control" name="task" id="task" placeholder="task to be done?" style="width: 100%;">
                  </div>
                  <div class="form-group" style="width:14.5%;margin-right: 2%">
                    <input type="date" name="date" class="form-control" id="date" placeholder="date" style="width: 100%">
                  </div>
                  <button type="submit" class="btn btn-default" onclick="return empty()" style="width: 8%;background-color: #9575cd;color: #ffffff"> <i class="fa fa-plus" aria-hidden="true"></i>
                </button>
                </form>
    </div>
    <div class="container-fluid" style="margin-bottom: 6px;margin-top: -1%">
      <a href="logout"><button type="button" class="btn btn-danger" style="margin-left: 4%;background-color: #F32323">logout</button></a>
    </div>
    <div class="container-fluid shadow-sm p-3 mb-5  bg-white rounded">
          <table class="table table-hover">
    <thead>
      <tr>
        <th>S.no</th>
        <th>Task</th>
        <th>Scheduled Date</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="theTask" items="${tasks}">
        <tr>
        <td></td>
        <td>${theTask.task}</td>
        <td>${theTask.date}</td>
        <td><a href="delete/${theTask.id}" style="color: red"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
      </tr>
</c:forEach>
      
    </tbody>
  </table>
    </div>
</body>
</html>