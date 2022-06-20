<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home page</title>

<style>
h2 {
	text-align: center;
}
</style>
</head>
<body>
	<h2>Admin activities</h2>

	<% String admin = (String)session.getAttribute("user"); 
      out.print("Welcome to Admin Home page " + admin );  
    %>
    
    </br>
    </br>
    
    <a href="acamdemicClassStroe.jsp"> Configure classes </a></br>
    <a href= "AcamdemicClassStroeController">View Classes </a></br>
  
    <a href = "TeacherController">  View all Teachers  </a> </br>
    <a href="storeTeachers.jsp"> Configure Teachers </a> </br>    
    <a href="StoreClassRoomTeacher.jsp"> Configure Class Teacher with Subjects</a>
    
    
    </br>
    
    <a href = "SubjectsController">  View all Subjects  </a> </br>
    <a href="storeSubjects.jsp"> Configure Subjects </a> </br>
    <a href ="ClassRoomTeacherController"> View Class Teacher with Subjects By ID </a> </br>
    
    <a href="storeStudents.jsp"> Configure Students  </a> </br>
    <a href="StudentDetsController"> View Students  </a>
    
    <%--  This is commented
    <a href ="ClassTeacherSubjectsController"> Class Teacher with Subjects By Name </a> </br>
    --%>
    

    </br>
    
   

	<a href="index.jsp"> Logout </a>


</body>
</html>