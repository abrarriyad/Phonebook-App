<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<s:url var="url_css" value="/resources/css/style.css"/>
	<link href="${url_css}" rel="stylesheet" type="text/css"/>
	<s:url var="url_jqlib" value="/resources/js/jquery-3.4.1.js"/>
	<script src="${url_jqlib}"></script>
	<script>
		function changeStatus(uid,lStatus){
				$.ajax({
					url: 'change_status',
					data:{userId:uid, loginStatus:lStatus} ,
					success: function(data){
						alert(data);
					}
				});
		}
	</script>
	<title>User List</title>
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
				<h3>User List</h3>
				<table border="1">
					<tr>
						<th>SR</th>
						<th>USER ID</th>
						<th>NAME</th>
						<th>PHONE</th>
						<th>EMAIL</th>
						<th>ADDRESS</th>
						<th>USERNAME</th>
						<th>STATUS</th>						
					</tr>
					<c:forEach var="u" items="${userList}" varStatus="st">
						<tr>
						<td>${st.count}</td>
						<td>${u.userId}</td>
						<td>${u.name}</td>
						<td>${u.phone}</td>
						<td>${u.email}</td>
						<td>${u.address}</td>
						<td>${u.loginName}</td>
						<td>
							<select id="id_${u.userId}" onchange="changeStatus(${u.userId},$(this).val())">
								<option value="1">Active</option>
								<option value="2">Block</option>
							</select> 
								<script>
									$('#id_${u.userId}').val(${u.loginStatus});
								</script>
						</td>						
					</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td height="25px">
				<jsp:include page="include/footer.jsp"/>
			</td>
		</tr>

		
	
	</table>

</body>


