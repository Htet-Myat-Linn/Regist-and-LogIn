<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn page</title>
<style>
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
  width:85%;
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
 margin-left:60%;
  border: none;
  cursor: pointer;
  width: 30%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}
.container{
margin-left: 300px;
margin-top: 100px;
}
</style>
</head>
<body>
		<div class="container">
        <h2>Login Form</h2>
        <form method="post" action="LoginServlet">
            <input type="text" name="username" placeholder="Username" required><br>
            <input type="password" name="password" placeholder="Password" required><br>
            <input type="submit" class="registerbtn" value="Login">
        </form>
        </div>

</body>
</html>