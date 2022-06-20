<%@page import="com.bean.ClassTeacherSubjects"%>
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

	<h2>Class with Teachers and Subjects Details by name</h2>

	<table border="1">

		<tr>
			<th bgcolor=#d2d8b0 width=15%>Class</th>
			<th bgcolor=#d2d8b0 width=15%>Subject Name</th>
			<th bgcolor=#d2d8b0 width=15%>Teacher Name</th>
		</tr>

		<%
		Object obj = session.getAttribute("rooms2");

		if (obj != null) {
			
			List<ClassTeacherSubjects> l = (List<ClassTeacherSubjects>) obj;			
			Iterator<ClassTeacherSubjects> li = l.iterator();

			while (li.hasNext()) {
				ClassTeacherSubjects c = li.next();
		%>

		<tr>
			<td bgcolor=white width=20%><font face=Arial color=#336699>
					<%=c.getClassroomid()%></td>
			<td bgcolor=white width=20%><font face=Arial color=#336699>
					<%=c.getSubname() %></td>
			<td bgcolor=white width=20%><%=c.getTname() %></td>
		</tr>

		<%
		}

		}
		%>


	</table>


</body>
</html>