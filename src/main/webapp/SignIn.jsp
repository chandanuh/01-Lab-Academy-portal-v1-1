<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>

<form action="LoginController" method="get">

  <label> Email</label>
  <input type="email" name="email"/> </br> </br>
  <label>  Password </label> 
  <input type="password" name="password"/> </br></br>
    <label> TypeOfuser</label>
    <input type="radio" name= "typeOfUser" value="Admin" > Admin 
     <input type="radio" name= "typeOfUser" value="User" > User </br> </br>
    
    <input type="submit" value="SignIn"/>
    <input type="reset" value="reset"/>
  

</form>  </br>
</br>

<a href="SignUp.jsp">Login Page!</a>

</body>
</html>