<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="navBar.jsp"%>

<%
String msg = (String) request.getAttribute("msg");
String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Form</title>
</head>
<body>
	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: green;">
		<%=msg%>
	</h1>
	<%
	}
	%>

	<%
	if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h1 style="color: red;">
		<%=errMsg%>
	</h1>
	<%
	}
	%>
	<br>
	<br>

	<form action="./delete" method="post">
		<h1>Enter the id to be deleted<br>
		<input type="number" name="id"><br> <input type="submit"
			value="Delete"></h1>
	</form>
</body>
</html>