<%@page import="java.util.Iterator"%>
<%@page import="com.bean.ClassRoomTeacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
text-align




:


 


center




;
</style>
<title>Teachers with Class room</title>
</head>
<body>

	<h2>Class with Teachers and Subjects</h2>

	<table border="1">

		<tr>
			<th bgcolor=#d2d8b0 width=15%>Class</th>
			<th bgcolor=#d2d8b0 width=15%>Subject Id</th>
			<th bgcolor=#d2d8b0 width=15%>Teacher Id</th>
		</tr>

		<%
		Object obj = session.getAttribute("rooms");

		if (obj != null) {
			List<ClassRoomTeacher> l = (List<ClassRoomTeacher>) obj;
			Iterator<ClassRoomTeacher> li = l.iterator();

			while (li.hasNext()) {
				ClassRoomTeacher c = li.next();
		%>

		<tr>
			<td bgcolor=white width=20%><font face=Arial color=#336699>
					<%=c.getClassroomid()%></td>
			<td bgcolor=white width=20%><font face=Arial color=#336699>
					<%=c.getSubid()%></td>
			<td bgcolor=white width=20%><%=c.getTid()%></td>
		</tr>

		<%
		}

		}
		%>


	</table>


</body>
</html>