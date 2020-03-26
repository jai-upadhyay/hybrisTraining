<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flight</title>
</head>
<body>
<h1>Hello ${ user.username}</h1>

<form:form commandName="flight">
<form:label path="">Departure Location : </form:label><form:input path="departureLocation"/>

<form:label path="">Arrival Location : </form:label><form:input path="arrivalLocation"/>

<form:label path="">Flight Date: </form:label><form:input type="date"  path="validTill"/>

<form:label path="">Flight Class: </form:label><form:radiobutton path="flightClass" title="B" value="B"/><form:radiobutton path="flightClass" title="E" value="E"/>

<form:button type="submit" value="Search Flights">Search Flights</form:button>

</form:form>

</body>
</html>