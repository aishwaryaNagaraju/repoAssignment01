<%@page import="com.te.electionmanagement.bean.CandidateDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="navBar.jsp"%>
<%
List<CandidateDetails> list = (List<CandidateDetails>) request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get All Details</title>

<style type="text/css">
table, td, th, tr {
	border: 2px solid rgba(0, 0, 0, 0.5);
	border-collapse: collapse;
}
</style>

</head>
<body>
<br><br>
<h1>All Employees</h1>
<br>
	<table>
		<tr>
			<td><label>ID</label></td>
			<td><label>NAME</label></td>
			<td><label>ADDRESS</label></td>
			<td><label>PASSWORD</label></td>
			<td><label>WARD NO.</label>
		</tr>
		<%
		for (CandidateDetails details : list) {
		%>
		<tr>
			<td><%=details.getId()%></td>
			<td><%=details.getName()%></td>
			<td><%=details.getAddress()%></td>
			<td><%=details.getPassword()%></td>
			<td><%=details.getWardNo()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>