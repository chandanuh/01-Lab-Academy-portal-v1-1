<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up </title>
</head>
<body>

<form action="LoginController" method="post">

  <label> Email</label>
  <input type="email" name="email"/> </br> </br>
  <label>  Password </label> 
  <input type="password" name="password"/> </br></br>
    <label> TypeOfuser</label>
    <input type="radio" name= "typeOfUser" value="Admin" > Admin 
     <input type="radio" name= "typeOfUser" value="User" > User </br> </br>
    
    <input type="submit" value="SignIn"/>
    <input type="reset" value="reset"/>
  

</form>

<a href ="SignIn.jsp" > Login page! </a>

</body>
</html>