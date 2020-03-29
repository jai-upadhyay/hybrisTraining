<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>

<form:form commandName="employee">
<form:label path="">EmployeeCode : </form:label><form:label path= "employeeCode" />

<form:label path="">Name : </form:label><form:input path="employeeName"/>

<form:label path=""> Date of Birth: </form:label><form:input type="date"  path="dateOfBirth"/>

<form:label path="">Location: </form:label><form:input path="location"/>

<form:label path="">Email: </form:label><form:input path="email"/>

<form:button type="submit" value="Update Employee">Update Employee</form:button>

</form:form>

</body>
</html>