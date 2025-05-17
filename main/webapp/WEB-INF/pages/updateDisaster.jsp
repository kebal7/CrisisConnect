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
	<jsp:include page="nav.jsp"/>
	
<%
    int disasterId = request.getAttribute("disasterId") != null ? (Integer) request.getAttribute("disasterId") : 0;
    String disasterTitle = request.getAttribute("disasterTitle") != null ? (String) request.getAttribute("disasterTitle") : "";
    String disasterType = request.getAttribute("disasterType") != null ? (String) request.getAttribute("disasterType") : "";
    String municipalityOrVdc = request.getAttribute("municipalityOrVdc") != null ? (String) request.getAttribute("municipalityOrVdc") : "";
    int ward = request.getAttribute("ward") != null ? (Integer) request.getAttribute("ward") : 0;
    String longitudeLatitude = request.getAttribute("longitudeLatitude") != null ? (String) request.getAttribute("longitudeLatitude") : "";
    java.time.LocalDate dateOfIncident = request.getAttribute("dateOfIncident") != null ? (java.time.LocalDate) request.getAttribute("dateOfIncident") : java.time.LocalDate.now();
    String reportedBy = request.getAttribute("reportedBy") != null ? (String) request.getAttribute("reportedBy") : "";
    String assignedCoordinator = request.getAttribute("assignedCoordinator") != null ? (String) request.getAttribute("assignedCoordinator") : "";
    int noOfInjuries = request.getAttribute("noOfInjuries") != null ? (Integer) request.getAttribute("noOfInjuries") : 0;
    int noOfDeath = request.getAttribute("noOfDeath") != null ? (Integer) request.getAttribute("noOfDeath") : 0;
    int noOfMissing = request.getAttribute("noOfMissing") != null ? (Integer) request.getAttribute("noOfMissing") : 0;
    double estimatedLoss = request.getAttribute("estimatedLoss") != null ? (Double) request.getAttribute("estimatedLoss") : 0.0;
    String otherNotes = request.getAttribute("otherNotes") != null ? (String) request.getAttribute("otherNotes") : "";
%>
	
	<div class="form-container">
	
		<% if(request.getAttribute("update_disaster_error") != null) { %>
		    <p style="color: red; text-align: center;">
		        <%= request.getAttribute("update_disaster_error") %>
		    </p>
		<% } %>
		
	    <h2>Update Disaster Record</h2>
	    <form action="" method="post">
	    
	    	<div class="form-group">
	            <label for="disasterTitle">Disaster Id</label>
	            <input type="text" id="disasterId" name="disasterId" value="<%=disasterId%>" readonly>
	        </div>
	        
	        <div class="form-group">
	            <label for="disasterTitle">Disaster Title *</label>
	            <input type="text" id="disasterTitle" name="disasterTitle" value="<%=disasterTitle%>" required>
	        </div>
	
			<div class="form-group">
			    <label for="disasterType">Disaster Type</label>
			    <select id="disasterType" name="disasterType">
			        <option value="">-- Select Type --</option>
			        <option value="Flood" <%= "Flood".equals(disasterType) ? "selected" : "" %>>Flood</option>
			        <option value="Landslide" <%= "Landslide".equals(disasterType) ? "selected" : "" %>>Landslide</option>
			        <option value="Earthquake" <%= "Earthquake".equals(disasterType) ? "selected" : "" %>>Earthquake</option>
			        <option value="Fire" <%= "Fire".equals(disasterType) ? "selected" : "" %>>Fire</option>
			    </select>
			</div>
			
			<div class="form-group">
			    <label for="municipalityOrVdc">Municipality/VDC</label>
			    <select id="municipalityOrVdc" name="municipalityOrVdc">
			        <option value="">-- Select Municipality --</option>
			        <option value="Kathmandu" <%= "Kathmandu".equals(municipalityOrVdc) ? "selected" : "" %>>Kathmandu</option>
			        <option value="Lalitpur" <%= "Lalitpur".equals(municipalityOrVdc) ? "selected" : "" %>>Lalitpur</option>
			        <option value="Pokhara" <%= "Pokhara".equals(municipalityOrVdc) ? "selected" : "" %>>Pokhara</option>
			    </select>
			</div>
			
			<div class="form-group">
			    <label for="ward">Ward No</label>
			    <select id="ward" name="ward">
			        <option value="">-- Select Ward --</option>
			        <% for (int i = 1; i <= 35; i++) { %>
			            <option value="<%= i %>" <%= (i == ward) ? "selected" : "" %>><%= i %></option>
			        <% } %>
			    </select>
			</div>

	
	        <div class="form-group">
	            <label for="longitudeLatitude">Longitude, Latitude</label>
	            <input type="text" id="longitudeLatitude" name="longitudeLatitude" value="<%=longitudeLatitude%>">
	        </div>
	
	        <div class="form-group">
	            <label for="dateOfIncident">Date of Incident *</label>
	            <input type="date" id="dateOfIncident" name="dateOfIncident" value="<%=dateOfIncident%>" required>
	        </div>
	
	        <div class="form-group">
	            <label for="assignedCoordinator">Assigned Coordinator</label>
	            <input type="text" id="assignedCoordinator" name="assignedCoordinator" value="<%=assignedCoordinator%>">
	        </div>
	
	        <div class="form-group">
	            <label for="noOfInjuries">No. of Injuries</label>
	            <input type="number" id="noOfInjuries" name="noOfInjuries" value="<%=noOfInjuries%>">
	        </div>
	
	        <div class="form-group">
	            <label for="noOfDeath">No. of Deaths</label>
	            <input type="number" id="noOfDeath" name="noOfDeath" value="<%=noOfDeath%>">
	        </div>
	
	        <div class="form-group">
	            <label for="noOfMissing">No. of Missing</label>
	            <input type="number" id="noOfMissing" name="noOfMissing" value="<%=noOfMissing%>">
	        </div>
	
	        <div class="form-group">
	            <label for="estimatedLoss">Estimated Loss (NPR)</label>
	            <input type="number" step="0.01" id="estimatedLoss" name="estimatedLoss" value="<%=estimatedLoss%>">
	        </div>
	
	        <div class="form-group">
	            <label for="otherNotes">Other Notes</label>
	            <textarea id="otherNotes" name="otherNotes" rows="4"><%=otherNotes%></textarea>
	        </div>
	
	        <button type="submit">Update Disaster Record</button>
	    </form>
	    
    </div>
    
    	<a href="<%= request.getContextPath() + "/admin/managedisasterrecord" %>" class="button-link">
    		<button type="button" class="back-button">Go to Manage Disaster Page</button>
		</a>
</body>
</html>