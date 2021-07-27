<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/save_user" method =post>
<label for="id">Enter Your Id</label><br>
<input type="text" id="id" name="id"><br>

<label for="f_name">Enter Your First_Name</label><br>
<input type="text" id="f_name" name="f_name"><br>

<label for="l_name">Enter Your Last_Name</label><br>
<input type="text" id="l_name" name="l_name"><br>

<label for="email_id">Enter Your Email Id</label><br>
<input type="text" id="email_id" name="email_id"><br>

<label for="contact_no">Enter Your Contact Number</label><br>
<input type="text" id="contact_no" name="contact_no"><br>

<label for="password">Enter Your Password</label><br>
<input type="text" id="password" name="password"><br>


<button type="submit">SIGNUP</button>
<!-- "save_user" will be called from UserController-->
</form>
</body>
</html>