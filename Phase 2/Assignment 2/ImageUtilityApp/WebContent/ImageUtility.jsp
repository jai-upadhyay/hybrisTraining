<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import ="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image Login Utility</title>
</head>
<body>
<%  
int userId = (int)session.getAttribute("LoggedInUser");
            Connection connection = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment2", "root", "root");

            Statement statement = connection.createStatement();

          	ResultSet result = statement.executeQuery("select * from users where id = "+userId);
          	String name = result.next() ? result.getString("firstName") : null;
            ResultSet resultset = 
                statement.executeQuery("select * from images where userId = "+userId);
            %>
<h1>Image Management Utility</h1>
<br>

<h4>Hello <%=name %></h4>
<form method="post" action="UploadImage" enctype="multipart/form-data">
<label>Please select the image file to upload (Max Size 1 MB)</label>
<br><br>
<input type="file" name="image" id="image" accept="image/*">
<br>
<br>
<input type="submit" value = "Upload Image">

<input type="button" value= "Cancel">
</form>
<br>
<br>
 
<table border="1">
<tr>
<th>Sr.No.</th>
<th>Name</th>
<th>Photo</th>
<th>Size</th>
<th>User</th>
</tr>
<%
while(resultset.next()){

	%>
	<tr>
	<td><%= resultset.getString(1) %></td>
	<td><%= resultset.getString(2) %></td>	
	<td><%= resultset.getBlob(3) %></td>
	<td><%= resultset.getString(4) %>MB</td>	
	<td><%= resultset.getString(5) %></td>
	</tr>
	<% 
}
connection.close();
%>

</table> 

</body>
</html>
