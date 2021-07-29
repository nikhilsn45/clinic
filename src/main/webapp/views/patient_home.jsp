<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- %@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %-->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- <sf:form action="/profile" method="get" modelAttribute="uInfo">
			<button>My Profile</button>
		</sf:form>-->
			
		<p align="center">
			Welcome to your profile ${pat.f_name} ${pat.l_name}!!<br>
			Your details are as follows:<br><br>
			
			Your User Name: ${pat.user_name}<br><br>
			
			Your Email_Id: ${pat.email_id}<br><br>
			
			Your Contact Number: ${pat.contact_no}<br>
			
			
			<br>
			<br>
			<br>
			<br>
			
			<a href="/home">
				<button>Return To Home Page</button>
			</a>
		</p>
	
		
		<form action= "/search" method="post">
		
			<label for="type">Enter the type of Doctor:</label><br>
			<input type="text" id="type" name="type"><br><br>
			<!-- A drop down list of Cardiologist, Dentist, Physician,Gynecologist, Pediatrician,Psychiatrist,Veterinarian etc   -->
			
			<label for="state">Enter Your State</label><br>
			<input type="text" id="state" name="state"><br><br>
			
			<label for="city">Enter Your City</label><br><br>
			<input type="text" id="city" name="city"><br><br>
			
			<button type="submit">SEARCH DOCTOR</button>
		<!-- This will be handled by "user_search_results" in Doctor Controller-->
		</form>
		
		<div id="searchResultList">
			<div id="list">
			
			</div>
		</div>
	</body>
</html>