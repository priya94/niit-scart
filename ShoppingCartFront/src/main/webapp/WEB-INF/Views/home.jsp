<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping cart</title>
</head>
<body>

	


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

	<p></p><br><br><br><br><br>

	</footer>
</body>
</html>