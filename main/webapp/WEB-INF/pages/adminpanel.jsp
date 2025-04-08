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
		<label>Disaster ID:</label>
		<input type="number" name="disasterId" required>
	</div>

	<div>	
		<label>Disaster Title:</label>
		<input type="text" name="disasterTitle" required>
	</div>
	
	<div>
		<label>Disaster Type:</label>
		<input type="text" name="disasterType">
	</div>

	<div>
		<label>Municipality or VDC:</label>
		<input type="text" name="municipalityOrVdc">
	</div>

	<div>
		<label>Ward:</label>
		<input type="number" name="ward">
	</div>

	<div>
		<label>Longitude & Latitude:</label>
		<input type="text" name="longitudeLatitude" placeholder="e.g., 27.700769, 85.300140">
	</div>

	<div>
		<label>Date of Incident:</label>
		<input type="date" name="dateOfIncident" required>
	</div>

	<div>
		<label>Reported By:</label>
		<input type="text" name="reportedBy">
	</div>

	<div>
		<label>Assigned Coordinator:</label>
		<input type="text" name="assignedCoordinator">
	</div>

	<div>
		<label>No. of Injuries:</label>
		<input type="number" name="noOfInjuries" min="0">
	</div>

	<div>
		<label>No. of Deaths:</label>
		<input type="number" name="noOfDeath" min="0">
	</div>

	<div>
		<label>No. of Missing:</label>
		<input type="number" name="noOfMissing" min="0">
	</div>

	<div>
		<label>Estimated Loss (in NPR):</label>
		<input type="number" name="estimatedLoss" step="0.01" min="0">
	</div>

	<div>
		<label>Other Notes:</label>
		<textarea name="otherNotes" rows="4" cols="50"></textarea>
	</div>

	<div>
		<button type="addDisaster">Add Disaster</button>
	</div>
		
	</form>
</body>
</html>