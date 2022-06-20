<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class with teachers </title>
<style> 
  h2{text-align: center; }  
</style>
</head>
<body>

<form action="ClassRoomTeacherController" method="post">


 <label> Enter Class </label>
 <input type ="number"  name ="classroomid"/></br></br>
 <label> Enter Subject Id </label>
 <input type ="number" name = "subid"/></br></br>
 <label> Enter Teacher Id </label>
 <input type ="number" name ="tid"/></br></br>
 <input type="submit" value ="Config Teachers N Subjects"/> 
 <input type="reset" value ="Reset">

</form>

</body>
</html>