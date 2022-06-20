<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style> 
  h2{text-align: center; }
  
</style>
<meta charset="ISO-8859-1">
<title> Welcome to Academic Classes </title>
</head>
<body>
<h2> Configure Classes </h2>
<form action="AcamdemicClassStroeController" method="post" >

<label> Enter the Class id </label>
<input  type="number"   name="clid"/></br></br> 
<label> Enter the Class Number </label>

<input  type="number"   name="classnum"/></br></br>    

<input type = "submit" value ="Configure Classes"/>
 <input type ="reset" value ="Reset"/></br>   
</form>
</body>
</html>