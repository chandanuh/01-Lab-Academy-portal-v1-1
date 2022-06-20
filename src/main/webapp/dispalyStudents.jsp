<%@page import="java.util.Iterator"%>
<%@page import="com.bean.StudentDets"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
text-align




:


 


center




;
</style>
<meta charset="ISO-8859-1">
<title>Students home page</title>
</head>
<body>

	<h2>Students Details</h2>

	<table border="1">

		<tr>
			<th bgcolor=#d2d8b0 width=15%>Student ID</th>
			<th bgcolor=#d2d8b0 width=15%>Student Name</th>
			<th bgcolor=#d2d8b0 width=15%>Class Num</th>

		</tr>

		<% Object obj = session.getAttribute("stds");
		
		if(obj!=null)
		{
			
			List<StudentDets> listOfStd = (List<StudentDets>) obj;
			Iterator<StudentDets> li = listOfStd.iterator();
			
			while (li.hasNext()) 
			{
				
				StudentDets s = li.next(); 				
				%>

		<tr>
			<td bgcolor=white width=20%><font face=Arial color=#336699>
					<%=s.getStdid()    %></td>
			<td bgcolor=white width=20%><font face=Arial color=#336699><%=s.getStdname()    %></td>
			<td bgcolor=white width=20%><font face=Arial color=#336699>
					<%=s.getClid()    %></td>

		</tr> 


		<%
				
				
				
			}
		}
		
		%>






	</table>
	>


</body>
</html>