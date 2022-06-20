<%@page import="java.util.Iterator"%>
<%@page import="com.bean.Subjects"%>
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
<title>Subjects home page</title>
</head>
<body>

	<h2>Subjects Information</h2>

	<table border="1">

		<tr>
			<th bgcolor = #d2d8b0 width = 15%>Subject ID</th>
			<th bgcolor = #d2d8b0 width = 15%>Subject Name</th>
		</tr>

		<%
		Object obj = session.getAttribute("subjs");

		if (obj != null) {
			List<Subjects> listOfSub = (List<Subjects>) obj;
			Iterator<Subjects> li = listOfSub.iterator();
			while (li.hasNext()) {

				Subjects s = li.next();
		%>

		<tr>
			<td bgcolor = white width = 20%><font face = Arial color=#336699>  <%=s.getSubid()%></td>
			<td bgcolor = white width = 20%><font face = Arial color=#336699><%=s.getSubname()%></td>

		</tr>

		<%
		}

		}
		%>


	</table>



</body>
</html>