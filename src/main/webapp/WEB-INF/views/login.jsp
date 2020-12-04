<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
  <title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv='cache-control' content='no-cache'> 
<meta http-equiv='expires' content='0'> 
<meta http-equiv='pragma' content='no-cache'> 
<link rel="stylesheet" href= "https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

  <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400&display=swap" rel="stylesheet">
  <style>

  </style>
</head>
<body> 
	<%
	response.setHeader("Paragma", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Expires", "0");
	response.setDateHeader("Expires", -1);
	%>
    <div class="container-fluid" style="text-align: center; background-color: #4a148c;color: #ffffff;padding: 8px;font-family: 'Roboto', sans-serif;">
      <h4>TO-DO</h4>
    </div> 

    <div class="container shadow p-3 mb-5  bg-white rounded" style="width: 30%; margin-top: 10%;">
      <h2 style="color: #9c9b9b;margin-bottom: 30px">Sign in</h2>
        <form action="letLogin" method="post">
    <div class="form-group">
      <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
    </div>
    <div class="form-group">
      <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
    </div>
    <button type="submit" class="btn btn-default" style="background-color:#4a148c; color: #ffffff">Submit</button>
  </form>
    </div>
</body>
</html>