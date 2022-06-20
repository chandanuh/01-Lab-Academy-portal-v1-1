<%@page import="java.util.Iterator"%>
<%@page import="com.bean.AcamdemicClass"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style type="text/css">
text-align




:center




;
</style>
<head>
<meta charset="ISO-8859-1">
<title>Display classes configured are</title>
</head>
<body>
	<h2>Classes configured are</h2>

	<table border="1">

		<tr>
			<th bgcolor=#d2d8b0 width=15%>Class ID</th>
			<th bgcolor=#d2d8b0 width=15%>Class Number</th>
		</tr>

		<%
		Object obj = session.getAttribute("acs");

		if (obj != null) {

			List<AcamdemicClass> listOfAca = (List<AcamdemicClass>) obj;
			Iterator<AcamdemicClass> li = listOfAca.iterator();

			while (li.hasNext()) {
				AcamdemicClass a = li.next();
		%>

		<tr>
			<td bgcolor=white width=20%><font face=Arial color=#336699><%=a.getClid()%></td>
			<td bgcolor=white width=20%><font face=Arial color=#336699><%=a.getClassnum()%></td>

		</tr>

		<%
		}

		}
		%>

	</table>

</body>
</html>