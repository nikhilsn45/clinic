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
<form action="/save_user" method =post>

<label for="user_name">Enter Your User Name which you will use for login</label><br>
<input type="text" id="user_name" name="user_name"><br>

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
<input type="hidden"  name="type" value="user"><br>


<button type="submit">SIGNUP</button>
<!-- "save_user" will be called from UserController-->
</form>
<a href="/home">
<button>Return To Home Page</button>
</a>
</div>

</body>
</html>