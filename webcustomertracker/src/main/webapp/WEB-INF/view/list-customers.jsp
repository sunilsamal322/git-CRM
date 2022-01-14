<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>
	
	<div class="container">
	<h1 class="text-center bg-primary text-white">Customer Relationship Management</h1>

		<div class="row">
			<div class="container mb-2 p-2 bg-secondary"><input class="btn btn-outline-primary text-white " type="button" value="Add Customer" onclick="window.location.href='showFormForAdd';return false;"></div>
			<div class="container m-2">
				<form:form action="search" method="GET">
					Search Customer: <input type="text" name="theSearchName">
					<input class="btn btn-outline-danger" type="submit" value="search">
				</form:form>
			</div>
			<table class="table">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">Id</th>
			      <th scope="col">First_Name</th>
			      <th scope="col">Last_Name</th>
			      <th scope="col">Email</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			      <c:forEach var="tempCustomer" items="${customers }">
			      
			      <!-- Construct an update link with customer id -->
			      <c:url var="updateLink" value="/customer/showFormForUpdate">
			      	<c:param name="customerId" value="${tempCustomer.id }"></c:param>
			      </c:url>
			      
			      <!-- Construct an delete link with customer id -->
			      <c:url var="deleteLink" value="/customer/delete">
			      	<c:param name="customerId" value="${tempCustomer.id }"></c:param>
			      </c:url>
			      
			      <tr>
			      	<td scope="col">${tempCustomer.id }</td>
			      	<td scope="col">${tempCustomer.firstName }</td>
			      	<td scope="col">${tempCustomer.lastName }</td>
			      	<td scope="col">${tempCustomer.email }</td>
			      	<td scope="col">
			      		<a href="${updateLink }">Update </a>|
			      		<a href="${deleteLink }" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false"> Delete</a>
			      	</td>
			      </tr>
			      </c:forEach>
			   </tbody>
			</table>
		</div>
	</div>
</body>
</html>