<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h3>Enter your details...</h3>

	<div id="box">
		<c:url var="action" value="here/register"></c:url>
		<form:form action="${action}" method="post" modelAttribute="user">
			<table>

				<tr>
					<td>ID:</td>
					<td><input type="text" name="id"></td>
				</tr>

				<tr>
					<td>Name:</td>
					<td><input type="text" name="name"></td>
				</tr>

				<tr>
					<td>Password:</td>
					<td><input type="text" name="password" /></td>
				</tr>

				<tr>
					<td>Mobile Number:</td>
					<td><input type="text" name="mobile_number" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="mail_id" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input type="text" name="address" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Register"></td>
				</tr>

			</table>



		</form:form>
	</div>
</body>
</html>