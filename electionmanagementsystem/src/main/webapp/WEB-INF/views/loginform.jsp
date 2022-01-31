<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>
		<%
		if (errMsg != null && !errMsg.isEmpty()) {
		%>
		<h1 style="color: red">
			<%=errMsg%>
		</h1>
		<%
		}
		%>	
	</h1>
	
	<fieldset>
		<legend> Login Form</legend>
		<form action="./login" method="post">
			<table>
				<tr>
					<td><label>Enter your ID:</label></td>
					<td><input type="number" name="id"></td>
				</tr>
				<tr>
					<td><label>Enter your Password:</label></td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<button type="submit" value="login">LOGIN</button>

		</form>
	</fieldset>

</body>
</html>