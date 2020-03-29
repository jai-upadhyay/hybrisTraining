<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees</title>
</head>
<body>
<h1>Employees</h1>

				<table>
					<tr>
						<th>Employee Code</th>
						<th>Employee Name</th>
						<th>Date Of Birth</th>
						<th>Location</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					<tr>
						<c:forEach items="${employeesList }" var="list" >
						<tr>
							<td>${list.employeeCode}</td>
							<td>${list.employeeName }</td>
							<td>${list.dateOfBirth }</td>
							<td>${list.location}</td>
							<td>${list.email}</td>
							<td><a href="<c:url value='/${list.employeeCode}' />" >Edit</a></td>
        
						</tr>
						</c:forEach>
					</tr>
				</table>
		
	

</body>
</html>