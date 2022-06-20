<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teachers page</title>
<style> 
  h2{text-align: center; }
  
</style>
</head>
<body>

<form action="TeacherController" method="post" >
<label> Teacher Id</label>
<input type="number" name="tid"/></br></br>
<label> Teacher Name</label>
<input type="text" name="tname"/></br></br>
<input type = "submit" value ="Configure Teacher"/>
<input type ="reset" value ="Reset"/></br>

</form>

</body>
</html>