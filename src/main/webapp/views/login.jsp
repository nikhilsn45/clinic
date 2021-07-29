<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action= "/login_user" method="post">

<label for="user_name">Enter Your User Name</label><br>
<input type="text" id="user_name" name="user_name"><br>

<label for="password">Enter Your Password</label><br>
<input type="text" id="password" name="password"><br>

Select User:
<input type="radio" id="patient" name="type" value="patient">
<label for="patient">Patient</label><br>  
<input type="radio" id="doctor" name="type" value="doctor">
<label for="doctor">Doctor</label><br>    

<button type="submit">SUBMIT</button>

</form>
</div>
</body>
</html>