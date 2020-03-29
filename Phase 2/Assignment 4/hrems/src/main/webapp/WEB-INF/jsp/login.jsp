<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<form:form commandName="user"  >
<label>
User Name :
</label>
<form:input path="username" />
<label>
User Name :
</label>
<form:password path="password"/>
<button type ="submit" value = "Login" >Login</button>
</form:form>

</body>
</html>