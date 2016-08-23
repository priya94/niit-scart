<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<link href="<c:url value="/resources/css/Navheader.css"/>"
	rel="stylesheet">

<img src="<%=request.getContextPath()%>/resources/images/657.png" />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="<c:url value="/resources/css/Loginstyle.css/" /> "
	rel="stylesheet">

<link href="<c:url value="/resources/images/657.png/" /> "
	rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping cart</title>
</head>
<body>

	<header>
	<body>
		<div id="nav">
			<br>
			<div id="nav_wrapper">
				<br>
				<ul>
					<li><a href="#">Sign In</a></li>
					<li><a href="#">Home</a></li>
					<li><a href="#">Brands</a></li>
					<li><a href="#">Products</a></li>
					<li><a href="#">Contact</a></li>
					<li><a href="#">About Us</a></li>
					<li><a href="#">Sign Up</a></li>
				</ul>
			</div>

		</div>
	</body>
	</header>


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
				<c:if
					test="${isUserClickedLoginHere==true || invalidCredentials==true}">
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
			<c:if test="${isIsadminClickedProducts==true}">
				<%@ include file="adminhome.jsp"%>
				<%@ include file="products.jsp"%>
			</c:if>
		</div>

		<div id="suppliers">
			<c:if test="${isIsadminClickedSuppliers==true}">
				<%@ include file="adminhome.jsp"%>
				<%@ include file="suppliers.jsp"%>
			</c:if>
		</div>
	</div>
	<footer>

	<p>This is my shopping website</p><br><br><br><br><br>

	</footer>
</body>
</html>