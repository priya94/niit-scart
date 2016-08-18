<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>

</head>
<body>
<h2 style="text-align: center; font-family: verdana; color: #000000">ADD PRODUCT</h2>

	 <c:url var="addAction" value="/product/add"></c:url>
	<form:form action="${addAction}" commandName="product">
	

		<table align="center">
			<tr>
				<td style=" font-family: verdana; color: #000000"><form:label path="id">
						<spring:message text="ID"   />
					</form:label></td>
				<c:choose>

					<c:when test="${!empty product.id}">
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
				<td style=" font-family: verdana; color: #000000"><form:label path="description">
						<spring:message text="Description"></spring:message>
					</form:label></td>
				<td><form:input path="description" required="true"></form:input></td>
			</tr>
			
			<tr>
				<td style=" font-family: verdana; color: #000000"><form:label path="price">
						<spring:message text="Price"></spring:message>
					</form:label></td>
				<td><form:input path="price" required="true"></form:input></td>
			</tr>
			

			<tr>
				<!-- if the category is already exist, then edit -->
				<td colspan="2" align="center"><c:if test="${!empty product.name }">
						<input type="submit"
							value="<spring:message text="Edit"></spring:message>">
					</c:if> <c:if test="${empty product.name}">
						<input type="submit"
							value="<spring:message text="Add"></spring:message>">
					</c:if></td>
			</tr>
		</table>
	</form:form>

	<br>
	
	<h2 style=" font-family: verdana; color: #000000;text-align: center">LIST OF PRODUCTS</h2>
	<c:if test="${!empty productList}">
		<table align="center">
			<tr>
				<th style=" font-family: verdana; color: #000000"> ID</th>
				<th style=" font-family: verdana; color: #000000"> NAME</th>
				<th style=" font-family: verdana; color: #000000"> DESCRIPTION</th>
				<th style=" font-family: verdana; color: #000000"> PRICE</th>
				<th style=" font-family: verdana; color: #000000"> EDIT</th>
				<th style=" font-family: verdana; color: #000000"> DELETE</th>
			</tr>

			<c:forEach items="${productList }" var="product">
				<tr>
					<td style=" font-family: verdana; color: #000000">${product.id}</td>
					<td style=" font-family: verdana; color: #000000">${product.name}</td>
					<td style=" font-family: verdana; color: #000000">${product.description}</td>
					<td style=" font-family: verdana; color: #000000">${product.price}</td>
					<td style=" font-family: verdana; color: #000000"><a href="<c:url value='editProducts/${product.id}' />">Edit</a></td>
					<td style=" font-family: verdana; color: #000000"><a href="<c:url value='deleteProducts/${product.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>



</body>
</html>