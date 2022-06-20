<%@page import="java.util.Iterator"%>
<%@page import="com.bean.Teachers"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
h2 {
	text-align: center;
}
</style>
<title>Teacher list page</title>
</head>
<body>
	<h2>Teachers information</h2>


	<table border="1">
		<tr>
			<th>Tid</th>
			<th>TName</th>
		</tr>

		<% 
 Object obj = session.getAttribute("teachers");
 
   if (obj!=null)
   {
	   List<Teachers> listOfTeachers = (List<Teachers>)obj;
	   Iterator<Teachers> li = listOfTeachers.iterator();
	   
	   while (li.hasNext())
	   {
		   Teachers t = li.next();
		 %>

		<tr>
			<td><%=t.getTid()%></td>
			<td><%=t.getTname() %></td>
		</tr>


		<%   
	   } 
	   
   }   
    %>
	</table>

</body>
</html>