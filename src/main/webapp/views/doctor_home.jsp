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
Welcome to your profile ${doc.f_name} ${doc.l_name}!!<br>
Your details are as follows:<br>
<br>
Your License Number: ${doc.license_no}<br>
<br>
Your User Name: ${doc.user_name}<br>
<br>
Your specialization: ${doc.specialization}<br>
<br>
Your Contact Number: ${doc.contact_no}<br>
<br>
Your State: ${doc.state}<br>
<br>
Your City: ${doc.city}<br>
<br>
<br>
<br>
<br>
<a href="/home">
<button>Return To Home Page</button>
</a>
<!-- doc's Reviews and handling appointment requests by users part will displayed here -->
<!--When User makes an appointment request for the doc, doc will be able to see here and either accept or reject the request -->
</p>
</body>
</html>