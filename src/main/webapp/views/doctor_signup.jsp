<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p align=center >
<b>Welcome Doctor!!</b>
</p>
<div align="center">
<form action= "/save_doctor" method="post">

<label for="license_no">Enter License Number</label><br>
<input type="text" id="license_no" name="license_no"><br>

<label for="user_name">Enter Your User Name which you will use for login</label><br>
<input type="text" id="user_name" name="user_name"><br>


<label for="f_name">Enter Your First_Name</label><br>
<input type="text" id="f_name" name="f_name"><br>

<label for="l_name">Enter Your Last_Name</label><br>
<input type="text" id="l_name" name="l_name"><br>

<label for="specialization">Enter Your specialization</label><br>
<input type="text" id="specialization" name="specialization"><br>

<label for="contact_no">Enter Your Contact Number</label><br>
<input type="text" id="contact_no" name="contact_no"><br>

<label for="state">Enter Your State</label><br>
<input type="text" id="state" name="state"><br>

<label for="city">Enter Your City</label><br>
<input type="text" id="city" name="city"><br>

<label for="password">Enter Your Password</label><br>
<input type="text" id="password" name="password"><br>
<input type="hidden"  name="type" value="doctor"><br>

<button type="submit">SUBMIT</button>
<!-- "save_doctor" will be called from DoctorController-->

</form>
<br>
<br>
<br>
<br>
<a href="/home">
<button>Return To Home Page</button>
</a>
</div>
</body>
</html>