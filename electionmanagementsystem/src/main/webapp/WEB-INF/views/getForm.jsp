<%@page import="com.te.electionmanagement.bean.CandidateDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="navBar.jsp"%>

<%
String details = (String) request.getAttribute("msg");
String errMsg = (String) request.getAttribute("errMsg");
CandidateDetails details2 = (CandidateDetails) request.getAttribute("data");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Data</title>
</head>
<body>

	<%
	if (details != null && !details.isEmpty()) {
	%>
	<h1><%=details%></h1>
	<%
	}
	%>

	<%
	if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h1><%=errMsg%></h1>
	<%
	}
	%>

	<form action="./get" method="post">
		<h3>
			Enter ID:<input type="number" name="id">
		</h3>
		<input type="submit" value="Search">
	</form>

	<%
	if (details2 != null) {
	%>
	<h1>
		Your ID is:<%=details2.getId()%></h1>
	<h1>
		Your Name is:<%=details2.getName()%></h1>
	<h1>
		Your Address is:<%=details2.getAddress()%></h1>
	<h1>
		Your Password is:<%=details2.getPassword()%></h1>
	<h1>
		Your Ward No. is:<%=details2.getWardNo()%></h1>
	<%
	}
	%>

</body>
</html>