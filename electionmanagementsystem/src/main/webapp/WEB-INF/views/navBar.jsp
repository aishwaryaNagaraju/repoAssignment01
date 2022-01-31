<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nav Bar</title>
<style type="text/css">
nav {
	border: 2px solid gray;
	padding: 5px;
	background: black;
	text-align: center;
}

a {
	margin: 20px;
	font-family: sans-serif;
	color: white;
	text-decoration: none;
	font-size: 20px;
}

a:hover {
	color: orange;
}
</style>
</head>

<body>
	<nav>
		<a href="./welcome">Home</a> 
		<a href="./add">Add Employee</a> 
		<a href="./update">Update Employee</a>
		<a href="./delete">Delete Employee</a> 
		<a href="./get">See Employee Details</a>
		<a href="./getall">See	All Employees</a> 
		<a href="./logout">Log Out</a>
	</nav>
</body>
</html>