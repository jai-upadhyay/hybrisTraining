<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Flights</title>
</head>
<body>
<h1>Available Flights</h1>

				<table>
					<tr>
						<th>Flight Number</th>
						<th>Fare</th>
						<th>Time</th>
						<th>Duration</th>
					</tr>
					<tr>
						<c:forEach items="${availableFlights }" var="flight" >
						<tr>
							<td>${flight.flightNumber }</td>
							<td>${flight.fare }</td>
							<td>${flight.flightTime }</td>
							<td>${flight.flightDuration}</td>
						</tr>
						</c:forEach>
					</tr>
				</table>
		
	

</body>
</html>