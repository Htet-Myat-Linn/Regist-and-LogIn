<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
<style type="text/css">
.customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
	.customers th {
	  padding-top: 12px;
	  padding-bottom: 12px;
	  text-align: left;
	  background-color: dodgerblue;
	  
}	

	.customers td, .customers th {
		  border: 1px solid black;
		  padding: 8px;
		  }
		  
	.customers tr:nth-child(even){background-color: #f2f2f2;}

    .customers tr:hover {background-color: #ddd;}
    
    .container{
    	margin:100px;
    }
     a{
    text-decoration: none;
    color:black;
    }
    </style>
</head>
<body>

<br> <div style="color:red">${msg}</div>

		
	<div class="container">	
	<h1 style="color: blue; margin-left: 500px">This is User List</h1>
	<br>
						<a href="Add.jsp">
		 					<button style="border: none; 
		 						background-color: yellow; 
		 						width: 100px;
		 						height: 25px;">
		 							Add
		 					</button>
		 				</a>
		 				<br>
		 				<hr style="border: 1px solid;">
		<table class="customers">
		 <tr>
			 <th>Id</th>
			 <th>UserName</th>
			 <th>PassWord</th>
			  <th>Update</th>
			   <th>Delete</th>
			 
			
		 </tr>
		 <c:forEach items="${list}" var="data">
		 	<tr>
		 		<td>${data.id}</td>
		 		<td>${data.userName}</td>
		 		<td>${data.passWord}</td>
		 		<td>
		 				<a href="UpdateServlet?id=${data.id}" >
		 					<button style="border: none; 
		 						background-color: yellowgreen; 
		 						width: 100px;
		 						height: 25px;">
		 					Update</button>
		 				</a>
		 				
		 		</td>
		 		<td>
		 				<a href="DeleteServlet?id=${data.id}">
		 					<button style="border: none; 
		 						background-color: red; 
		 						width: 100px;
		 						height: 25px;">
		 							Delete
		 					</button>
		 				</a>
		 				
		 		</td>
		 		
		 	</tr>
		 </c:forEach>
		</table>
		</div>
		
</body>
</html>