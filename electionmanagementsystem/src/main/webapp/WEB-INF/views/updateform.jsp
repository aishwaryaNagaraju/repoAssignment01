
<%@page import="com.te.electionmanagement.bean.CandidateDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="navBar.jsp"%>

<%
String msg = (String) request.getAttribute("msg");
String errMsg = (String) request.getAttribute("errMsg");
CandidateDetails details = (CandidateDetails) request.getAttribute("data");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Form</title>
</head>
<body>
	<%
	if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h1><%=errMsg%></h1>
	<%
	}
	%>
	<%if(msg!=null && !msg.isEmpty()){ %>
	<h1><%=msg %></h1>
	<%} %>

	<br>
	<br>
	<fieldset>
		<legend>Update Form</legend>

		<form action="./update" method="post">
			<table>
				<tr>
					<td><label>ID is:</label></td>
					<td><input type="number" name="id"
						value="<%=details.getId()%>" disabled="disabled"></td>
				</tr>

				<tr>
					<td><label>Enter the name</label></td>
					<td><input type="text" name="name"
						value="<%=details.getName()%>"></td>
				</tr>

				<tr>
					<td><label>Enter the address</label></td>
					<td><input type="text" name="address"
						value="<%=details.getAddress()%>"></td>
				</tr>

				<tr>
					<td><label>Enter the password</label></td>
					<td><input type="password" name="password"
						value="<%=details.getPassword()%>"></td>
				</tr>
				
				
				<tr>
					<td><label>Enter the password</label></td>
					<td><input type="number" name="wardNo"
						value="<%=details.getWardNo()%>"></td>
				</tr>
				

			</table>

			<input type="submit" value="update">


		</form>
	</fieldset>

	
</body>
</html>