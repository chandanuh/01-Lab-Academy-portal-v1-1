<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Configure Students page</title>
<title>Welcome to Subjects home page</title>
<style> 
  h2{text-align: center; }  
</style>
</head>
<body>

<h2> Configure Students</h2>
<form action="StudentDetsController" method="post">

<label> Enter the Student Id </label>
<input  type="text" name ="stdid"/></br></br>
<label> Enter the Student Name </label>
<input  type="text" name ="stdname"/></br></br>
<label> Enter the Student Class Number </label>
<input  type="text" name ="clid"/></br></br> 
<input type = "submit" value ="Configure Student"/>
 <input type ="reset" value ="Reset"/></br> 

</form>


</body>
</html>