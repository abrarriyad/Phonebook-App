<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<s:url var="url_css" value="resources/css/style.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css"/>
</head>
<s:url var="url_bg" value="resources/images/bg.jpg"/>

<body background="${url_bg}">
	<table border="1" width="80%" align="center">
	
		<tr>
			<td height="80px">
				<jsp:include page="include/header.jsp"/>
			</td>
		</tr>

		<tr>
			<td height="25px">
				<jsp:include page="include/menu.jsp"/>
			</td>
		</tr>
		<tr>
			<td height="350px" valign="top">
				<h3>User Login</h3>
				<c:if test="${err!=null}">
					<p class="error"> ${err}</p>
				</c:if>
				
				<c:if test="${param.act eq 'lo'}">
					<p class="success">Logout Sucsessfully</p>
				</c:if>
				
				<c:if test="${param.act eq 'reg'}">
					<p class="success"> User Registered Sucsessfully.You can login.</p>
				</c:if>
				
				
				
				<s:url var="url_login" value="/login"></s:url>
				<f:form action="${url_login}" modelAttribute="command">
					<table border="1">
						<tr>
							<td>Username</td>
							<td><f:input path="loginName" /></td>
						</tr>

						<tr>
							<td>Password</td>
							<td><f:password path="password" /></td>
						</tr>

						<tr>
							<td colspan="2" align="right">
							
								<Button>Login</Button> <br/>
								<a href="#">New User Registration</a>
							</td>
						</tr>
						
						
					</table>
				</f:form>
			</td>
		</tr>
		<tr>
			<td height="25px">
				<jsp:include page="include/footer.jsp"/>
			</td>
		</tr>

		
	
	</table>

</body>


