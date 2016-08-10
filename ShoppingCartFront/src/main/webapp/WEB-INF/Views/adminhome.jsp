<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin home</title>
</head>
<body>
<c:url var="action" value="here/register"></c:url>
		<form:form action="${action}" method="post" modelAttribute="user">
	
 <table>
 <tr>
 <td align="left"><a href="categories"
 style="textfont-size: 200%; font-family:verdana; color:#FFFFFF">Manage Categories</a>
</td>

<td align="left"><a href="products"
 style="textfont-size: 200%; font-family:verdana; color:#FFFFFF">Manage Categories</a>
</td>

<td align="left"><a href="suppliers"
 style="textfont-size: 200%; font-family:verdana; color:#FFFFFF">Manage Categories</a>
</td>
 
 
 </tr>
 
 
 
 </table>
 </form:form>
</body>
</html>