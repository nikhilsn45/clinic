<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
			
		<p align="center">
			Welcome to your profile ${user.f_name} ${user.l_name}!!<br>
			Your details are as follows:<br><br>
			
			Your User Name: ${user.user_name}<br><br>
			
			Your Email_Id: ${user.email_id}<br><br>
			
			Your Contact Number: ${user.contact_no}<br>
			<br>
			<br>
			<br>
			<br>
			
			<a href="/home">
				<button>Return To Home Page</button>
			</a>
		</p>
		
		
		
		<!-- Status of your appointment will be displayed here.-->
		<!-- If your appointment gets rejected, you can search for doctors again from below form -->
	
		
		<form action= "/user_search_results" method="post">
		
			<label for="type">Enter the type of Doctor:</label><br>
			<input type="" id="type" name="type"><br><br>
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