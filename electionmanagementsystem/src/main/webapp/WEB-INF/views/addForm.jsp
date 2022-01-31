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
<title>Add Form</title>
</head>
<body>
	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: green"><%=msg%></h1>
	<%
	}%>
	
	<%if(errMsg!=null && !errMsg.isEmpty()){
		%>
		<h1 style="color:red"><%=errMsg %></h1>
	<%}%>
	
	<br>
	<br>

	<fieldset>
		<legend>Add Employee</legend>
		<form action="./add" method="post">
			<table>
				<tr>
					<td><label>Enter Candidate ID:</label></td>
					<td><input type="number" name="id"></td>
				</tr>
				<tr>
					<td><label>Enter Candidate Name:</label></td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td><label>Enter Candidate Password:</label></td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><label>Enter Candidate Address:</label></td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td><label>Candidate Contesting from Ward:</label></td>
					<td><input type="number" name="wardNo"></td>
				</tr>
			</table>
			<input type="submit" value="Add">
		</form>
	</fieldset>

</body>
</html>