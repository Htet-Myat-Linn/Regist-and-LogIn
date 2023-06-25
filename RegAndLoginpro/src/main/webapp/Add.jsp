<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<style type="text/css">
  

*{
	 box-sizing: border-box;
}
body{
	font-family: Arial, Helvetica, sans-serif;
	background-color: white;
}
.container {
  padding: 16px;
  background-color: LightGray;
  margin-left: 400px;
  width: 500px

}
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}
input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

.registerbtn {
  background-color: #2196F3;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

</style>
</head>
<body>
	
	<h2>User Registration</h2>
    <form action="AddServlet" method="POST">
        <label for="id">ID:</label>
        <input type="text"  name="id" required><br><br>
        <label for="username">Username:</label>
        <input type="text" name="username" required><br><br>
        <label for="password">Password:</label>
        <input type="password" name="password" required><br><br>
        <input type="submit" class="registerbtn" value="Register">
    </form>
</body>
</html>