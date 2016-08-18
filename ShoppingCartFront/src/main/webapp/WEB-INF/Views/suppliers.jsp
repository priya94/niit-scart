<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier</title>

</head>
<body>
<h2 style="text-align: center; font-family: verdana; color: #000000">ADD SUPPLIER</h2>

	 <c:url var="addAction" value="/supplier/add"></c:url>
	<form:form action="${addAction}" commandName="supplier">
	

		<table align="center">
			<tr>
				<td style=" font-family: verdana; color: #000000"><form:label path="id">
						<spring:message text="ID"   />
					</form:label></td>
				<c:choose>

					<c:when test="${!empty supplier.id}">
						<td><form:input path="id" disabled="true" readonly="true" />
						</td>
					</c:when>

					<c:otherwise>
						<td><form:input path="id"  required="true"
								title="Enter a valid id" /></td>
					</c:otherwise>
				</c:choose>
			</tr>

			<tr>
					<form:input path="id" hidden="true"  />
				<td style=" font-family: verdana; color: #000000"><form:label path="name">
						<spring:message text="Name"></spring:message>
					</form:label></td>
				<td><form:input path="name" required="true"></form:input></td>
			</tr>

			<tr>
				<td style=" font-family: verdana; color: #000000"><form:label path="address">
						<spring:message text="Address"></spring:message>
					</form:label></td>
				<td><form:input path="address" required="true"></form:input></td>
			</tr>

			<tr>
				<!-- if the category already exist, then edit -->
				<td colspan="2" align="center"><c:if test="${!empty supplier.name }">
						<input type="submit"
							value="<spring:message text="Edit"></spring:message>">
					</c:if> <c:if test="${empty supplier.name}">
						<input type="submit"
							value="<spring:message text="Add"></spring:message>">
					</c:if></td>
			</tr>
		</table>
	</form:form>

	<br>
	
	<h2 style=" font-family: verdana; color: #000000;text-align: center">LIST OF SUPPLIERS</h2>
	<c:if test="${!empty supplierList}">
		<table align="center">
			<tr>
				<th style=" font-family: verdana; color: #000000"> ID</th>
				<th style=" font-family: verdana; color: #000000"> NAME</th>
				<th style=" font-family: verdana; color: #000000"> ADDRESS</th>
				<th style=" font-family: verdana; color: #000000"> EDIT</th>
				<th style=" font-family: verdana; color: #000000"> DELETE</th>
			</tr>

			<c:forEach items="${supplierList }" var="supplier">
				<tr>
					<td style=" font-family: verdana; color: #000000">${supplier.id}</td>
					<td style=" font-family: verdana; color: #000000">${supplier.name}</td>
					<td style=" font-family: verdana; color: #000000">${supplier.address}</td>
					<td style=" font-family: verdana; color: #000000"><a href="<c:url value='editSuppliers/${supplier.id}' />">Edit</a></td>
					<td style=" font-family: verdana; color: #000000"><a href="<c:url value='deleteSuppliers/${supplier.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>



</body>
</html>*/