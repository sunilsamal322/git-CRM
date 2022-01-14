<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
	<div class="container mt-2 text-center bg-primary text-white"><h2>Customer Relationship Management</h2></div>
	<div class="container">
	<h3 class="bg-secondary text-white">Save Customer</h3>
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		
		<!-- Need to associate this data with customer id for updating propose-->
		<form:hidden path="id"/>
		
			<table>
				<tbody>
					<tr>
						<td><label>First Name: </label></td>
						<td><form:input path="firstName"/></td>
					</tr>
					<tr>
						<td><label>Last Name: </label></td>
						<td><form:input path="lastName"/></td>
					</tr>
					<tr>
						<td><label>Email: </label></td>
						<td><form:input path="email"/></td>
					</tr>
					<tr>
						<td><label> </label></td>
						<td><input class="btn btn-outline-success" type="submit" value="Save" ></td>
					</tr>
				
				</tbody>
			</table>
		</form:form>
		<div><a class="btn btn-outline-warning" href="${pageContext.request.contextPath }/customer/list">Back to List</a></div>
	</div>
</body>
</html>