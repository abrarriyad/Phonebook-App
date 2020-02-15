<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>	
<!DOCTYPE html>
<html>
<head>
<s:url var="url_jqlib" value="/resources/js/jquery-3.4.1.js"/>
<script src="${url_jqlib}"></script>
<script>
$(document).ready(function(){
//	alert('Jquery is ready and inetrageted');
	$("#id_get_time").click(function(){
		//alert("Button Clicked");
		$.ajax({
			url : 'get_time',
			success: function(data){
				$("#id_time").html(data);
			}
		})
		
	});
});
</script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajax test page</h1>
	<button id="id_get_time">Get Server Time</button>
	<p id="id_time"></p>
</body>
</html>