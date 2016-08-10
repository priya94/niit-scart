<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="<c:url value="/resources/css/Loginstyle.css/" /> " rel="stylesheet" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping cart</title>
</head>
<body>

<h2>SHOPPINGCART</h2>
	<div class="container">
		<div class="flat-form">
			<ul class="tabs">
				
				<c:choose>
					<c:when test="${empty loggedInUser}">

						<li><a href="loginhere">LOGIN</a></li>

						<li><a href="register">REGISTER</a></li>



					</c:when>
					<c:when test="${not empty loggedInUser}">

						<li><a href="logout">LOGOUT</a></li>

					</c:when>
				</c:choose>
			</ul>


			<div id="loginhere">
				<c:if test="${isUserClickedLoginHere==true}">
					<%@ include file="login.jsp"%>

				</c:if>
			</div>

			<div id="registerhere">
				<c:if test="${isregister==true}">
					<%@ include file="register.jsp"%>

				</c:if>
			</div>



		</div>
	</div>

	<div id="loginhere">
		<c:if test="${islogin==true || invalidCredentials==true}">
			<div id="error">${errorMessage}</div>
			<%@ include file="login.jsp"%>

		</c:if>
	</div>
	
	<div id="registerhere">
		<c:if test="${isregister==true || invalidCredentials==true}">
			<div id="error">${errorMessage}</div>
			<%@ include file="register.jsp"%>

		</c:if>
	</div>

	<div id="logout">
		<c:if test="${not empty loggedInUser}">
			<td>Welcome ${loggedInUser},</td>
		</c:if>
	</div>



	<div id="admin">

		<c:if test="${isIsadmin==true}">

			<%@ include file="adminhome.jsp"%>

		</c:if>

		<div id="categories">
			<c:if test="${isIsadminClickedCategories==true}">
				<%@ include file="adminhome.jsp"%>
				<%@ include file="categories.jsp"%>
			</c:if>
		</div>
		
		<div id="products">
			<c:if test="${isIsadminClickedCategories==true}">
				<%@ include file="adminhome.jsp"%>
				<%@ include file="products.jsp"%>
			</c:if>
		</div>
		
		<div id="suppliers">
			<c:if test="${isIsadminClickedCategories==true}">
				<%@ include file="adminhome.jsp"%>
				<%@ include file="suppliers.jsp"%>
			</c:if>
		</div>
		</div>
		
</body>
</html>