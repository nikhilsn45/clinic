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
Welcome to your profile ${doctor.fname} ${doctor.lname}!!<br>
Your details are as follows:<br>
<br>
Your License Number: ${doctor.licence_no}<br>
<br>
Your Speciality: ${doctor.speciality}<br>
<br>
Your Contact Number: ${doctor.contact_no}<br>
<br>
Your State: ${doctor.state}<br>
<br>
Your City: ${doctor.city}<br>
<br>

<!-- Doctor's Reviews and handling appointment requests by users part will displayed here -->
<!--When User makes an appointment request for the doctor, Doctor will be able to see here and either accept or reject the request -->
</p>
</body>
</html>