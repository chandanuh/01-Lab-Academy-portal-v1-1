<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Subjects home page</title>
<style> 
  h2{text-align: center; }
  
</style>
</head>
<body>

<form action="SubjectsController" method="post">
  
  <label> Subject Id </label>
  <input type="number" name="subid"/></br></br>
  <label> Subject Name</label>
  <input type="string" name="subname"/></br></br>
  <input type = "submit" value ="Configure Subject"/>
  <input type ="reset" value ="Reset"/></br>
 

</form>

</body>
</html>