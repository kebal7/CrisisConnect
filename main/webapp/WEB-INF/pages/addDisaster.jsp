<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crisis Connect Admin Panel</title>

<style>

       body {
            font-family: "Segoe UI", sans-serif;
            background: #f9f9f9;
            padding: 30px;
        }
        .form-container {
            max-width: 800px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 12px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: 500;
        }
        input, select, textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 6px;
        }
        button {
            padding: 12px 24px;
            background: #007BFF;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            display: block;
            margin: auto;
        }
        button:hover {
            background: #0056b3;
        }

</style>

</head>
<body>
	<div class="form-container">
	    <h2>Report New Disaster</h2>
	    <form action="" method="post">
	        <div class="form-group">
	            <label for="disasterId">Disaster ID *</label>
	            <input type="number" id="disasterId" name="disasterId" required>
	        </div>
	
	        <div class="form-group">
	            <label for="disasterTitle">Disaster Title *</label>
	            <input type="text" id="disasterTitle" name="disasterTitle" required>
	        </div>
	
	        <div class="form-group">
	            <label for="disasterType">Disaster Type</label>
	            <select id="disasterType" name="disasterType">
	                <option value="">-- Select Type --</option>
	                <option value="Flood">Flood</option>
	                <option value="Landslide">Landslide</option>
	                <option value="Earthquake">Earthquake</option>
	                <option value="Fire">Fire</option>
	            </select>
	        </div>
	
	        <div class="form-group">
	            <label for="municipalityOrVdc">Municipality/VDC</label>
	            <select id="municipalityOrVdc" name="municipalityOrVdc">
	                <option value="">-- Select Municipality --</option>
	                <option value="Kathmandu">Kathmandu</option>
	                <option value="Lalitpur">Lalitpur</option>
	                <option value="Pokhara">Pokhara</option>
	            </select>
	        </div>
	
	        <div class="form-group">
	            <label for="ward">Ward No</label>
	            <select id="ward" name="ward">
	                <option value="">-- Select Ward --</option>
	                <% for (int i = 1; i <= 35; i++) { %>
	                    <option value="<%= i %>"><%= i %></option>
	                <% } %>
	            </select>
	        </div>
	
	        <div class="form-group">
	            <label for="longitudeLatitude">Longitude, Latitude</label>
	            <input type="text" id="longitudeLatitude" name="longitudeLatitude">
	        </div>
	
	        <div class="form-group">
	            <label for="dateOfIncident">Date of Incident *</label>
	            <input type="date" id="dateOfIncident" name="dateOfIncident" required>
	        </div>
	
	        <div class="form-group">
	            <label for="reportedBy">Reported By</label>
	            <input type="text" id="reportedBy" name="reportedBy">
	        </div>
	
	        <div class="form-group">
	            <label for="assignedCoordinator">Assigned Coordinator</label>
	            <input type="text" id="assignedCoordinator" name="assignedCoordinator">
	        </div>
	
	        <div class="form-group">
	            <label for="noOfInjuries">No. of Injuries</label>
	            <input type="number" id="noOfInjuries" name="noOfInjuries">
	        </div>
	
	        <div class="form-group">
	            <label for="noOfDeath">No. of Deaths</label>
	            <input type="number" id="noOfDeath" name="noOfDeath">
	        </div>
	
	        <div class="form-group">
	            <label for="noOfMissing">No. of Missing</label>
	            <input type="number" id="noOfMissing" name="noOfMissing">
	        </div>
	
	        <div class="form-group">
	            <label for="estimatedLoss">Estimated Loss (NPR)</label>
	            <input type="number" step="0.01" id="estimatedLoss" name="estimatedLoss">
	        </div>
	
	        <div class="form-group">
	            <label for="otherNotes">Other Notes</label>
	            <textarea id="otherNotes" name="otherNotes" rows="4"></textarea>
	        </div>
	
	        <button type="submit">Submit Disaster Report</button>
	    </form>
    </div>
</body>
</html>