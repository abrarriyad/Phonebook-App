<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<s:url var="url_css" value="resources/css/style.css"/>
	<link href="${url_css}" rel="stylesheet" type="text/css"/>
	
	<title>Admin Dashboard</title>
</head>
<s:url var="url_bg" value="/resources/images/bg.jpg"/>

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
				<h1>Admin Dashboard</h1>
			</td>
		</tr>
		<tr>
			<td height="25px">
				<jsp:include page="include/footer.jsp"/>
			</td>
		</tr>

		
	
	</table>

</body>


