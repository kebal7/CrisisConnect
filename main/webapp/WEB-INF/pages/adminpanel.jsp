<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Panel</title>
</head>
<body>
	<form action="addDisaster" method="post">
	
		<label>Disaster Title:</label>
		<input type="text" name="disasterTitle" required>
		
		<label>Disaster Type:</label>
		<input type="text" name="disasterType" required>
		
	</form>
</body>
</html>