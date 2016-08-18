<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<title>Trendy Tab Login Form </title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Trendy Tab Login Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<link href="<c:url value="/resources/css/style.css"/>"
	rel="stylesheet">

<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />

<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>

<script src="js/jquery.min.js"></script>
<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>

</head>


<body>
	
   <c:url var="action" value="/login"></c:url>

     <form:form action="${action }" method="post">

	<div class="main">
		<h1>Login Form</h1>
		<div class="login-form">
			<div class="sap_tabs w3ls-tabs">
				<div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
					<ul class="resp-tabs-list">
						<li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>Login</span></li> 
						
					</ul>	
					<div class="clear"> </div>
					<div class="resp-tabs-container">
						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
							<div class="login-agileits-top"> 
								
									<p>User Name </p>
									<input type="text" name="name" />
									<p>Password</p>
									<input type="password" name="password" /><br><br> 
									
									<input type="submit" value="LOGIN">
								 
							</div>
							<div class="login-agileits-bottom"> 
								
							</div> 
						</div> 
						

                                                       
					</div>							
				</div>	 
			</div> 
			
			<script type="text/javascript">
				$(document).ready(function () {
					$('#horizontalTab').easyResponsiveTabs({
						type: 'default', //Types: default, vertical, accordion           
						width: 'auto', //auto or any width like 600px
						fit: true   // 100% fit in a container
					});
				});
			</script>
			
		</div>	
	</div>	
	
	<div class="copyright">
		<p> © 2016 Menonz</p>
	</div>
	</form:form>
</body>
</html>