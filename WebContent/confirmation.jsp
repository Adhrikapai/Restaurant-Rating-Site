<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new restaurants</title>
<link href="https://fonts.googleapis.com/css?family=Playfair+Display" rel="stylesheet">
<style>
	body {
	font-family: 'Playfair Display', serif;
		border: 3px solid black;
	  width: 50%;
	  margin: 0 auto;
	  margin-left: 25%;
	  display: inline-block;
	  background: white;
	  padding: 10px;
	  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
	}
	table {
	  border-collapse: collapse;
	  width: 100%;
	}

	th, td {
	  text-align: left;
	  padding: 8px;
	}
	
	tr:nth-child(even){background-color: #f2f2f2}
	
	th {
	  background-color: #0B6287;
	  color: white;
	}
	input[type=submit] {
	font-family: 'Playfair Display', serif;
	  background-color: #01CCFE;
	  border: none;
	  color: white;
	  padding: 15px 32px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 16px;
	  margin: 4px 2px;
	  cursor: pointer;
	  -webkit-transition-duration: 0.4s; /* Safari */
	  transition-duration: 0.4s;
	}
	input[type=submit]:hover {
		font-family: 'Playfair Display', serif;
  		box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
	}
	input[type=text], select {
	font-family: 'Playfair Display', serif;
	  width: 100%;
	  padding: 12px 20px;
	  margin: 8px 0;
	  display: inline-block;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
	}
	.search {
	font-family: 'Playfair Display', serif;
	  border-radius: 10px solid #DCDCDC;
		background-color: black;
	  color:white;	  
	  padding: 20px;
	  margin: 0 auto;
	}
	select{
	font-family: 'Playfair Display', serif;
		background-color: black;
	  color:white;	
	}
	header, footer{
		background-color: #DCDCDC;
	}
	
</style>
</head>
<body>
	<center>
		<header>
		    <h1>Inventory Page</h1>
		</header>
		
		<form method="post" action="AddController">
		<section id="content">
				<div id="section">
					<h1>Add Restaurants to inventory</h1>
					Restaurant Name: <input type="text" name="restName" /><br />
					Cuisine Type: <input type="text" name="restType" /><br />
					Price: ($, $$, $$$, $$$$) <input type="text" name="restPrice" /><br />
					Star Rating: (*, **, ***, ****, *****) <input type="text" name="restRate" /><br />
					Additional Notes: <input type="text" name="restNote" /><br />
		
					<input type="submit" name="AddRest" value="Add" />
					<br />
					<br />		
				</div>
			</form>
			<c:if test="${not empty restSearchName}">
				<h3>Already in the inventory, please add another restaurant</h3>
			</c:if>
			<c:if test="${empty restSearchName}">
				<c:if test="${not empty restSearchList}">
						<table>
							<tr>
								<th>Restaurant Name</th>
								<th>Cuisine Type</th> 
								<th>Price</th>
								<th>Star Rating</th>
								<th>Notes</th>
							</tr>
							<c:forEach var="item" items="${restSearchList}">	
								<tr>	
								    <td>${item.restName}</td>
							    	<td>${item.restType}</td>
							    	<td>${item.restPrice}</td>
							    	<td>${item.restRate}</td>
							    	<td><i>${item.restNote}</i></td>
							    </tr>	    	
							</c:forEach>
						</table>
				</c:if>						
			</c:if>
			<form method="post" action="HomeController" target="_self">
				<h2>Back to Restaurant Dashboard</h2>
				<input type="submit" value="Home Page" /> <br /><br /><br />
			</form>
		</section>
		<footer>
			<h3>Midterm| Adhrika Pai | 991451940</h3>
		</footer>
	</center>
</body>
</html>