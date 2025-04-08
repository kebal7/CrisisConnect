<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Panel</title>

<style>
	form{
		display: flex;
		flex-direction: column;
		background: purple;
        padding: 20px;
		border-radius: 10px;
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		width: 400px;
		gap: 10px;
	}
	
	label {
	    color: white;
		font-size: 20px;
		font-weight: bold;
	}

</style>

</head>
<body>
	<form id="disasterForm" action="" method="post">
	
		<div>	
			<label>Disaster Title:</label>
			<input type="text" name="disasterTitle" required>
		</div>
		
		<div>
			<label>Disaster Type:</label>
			<input type="text" name="disasterType" required>
		</div>
		
		<button type="submit">Submit</button>
	</form>
</body>
</html>