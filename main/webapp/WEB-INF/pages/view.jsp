<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.crisisconnect.model.DisasterModel" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Disaster</title>

<style>
        body {
            margin: 0;
            font-family: "Segoe UI", sans-serif;
            background: #f2f6fc;
        }

        .header {
            background: #007BFF;
            color: white;
            padding: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header h1 {
            margin: 0;
        }

        .welcome {
            font-size: 18px;
        }
        
               .container {
            padding: 30px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
            font-size: 14px;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .back-button {
            margin-top: 20px;
            text-align: center;
        }

        .back-button a {
            background-color: #007BFF;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 4px;
            font-weight: bold;
        }

        .back-button a:hover {
            background-color: #0056b3;
        }
</style>
</head>
<body>
	<jsp:include page="nav.jsp"/>
	<%
	    String username = (String) session.getAttribute("username");
	    String  usertype= (String) session.getAttribute("usertype");
	    
	    List<DisasterModel> disasterList = (List<DisasterModel>) request.getAttribute("disasters"); 
	%>

	 
  <div class="container">
        <h2>Disaster Records</h2>
        
		<form method="post" action="" style="margin-bottom: 20px; display: flex; gap: 10px; align-items: center; flex-wrap: wrap;">
		    
		    <!-- Search Bar -->
		    <input type="text" name="searchQuery" placeholder="Search disaster..." 
		           style="padding: 10px; width: 500px; border: 1px solid #ccc; border-radius: 4px;"
		           value="<%= request.getAttribute("searchQuery") != null ? request.getAttribute("searchQuery") : "" %>">
		
		    <button type="submit" name="action" value="search"
		            style="padding: 10px 20px; background-color: #007BFF; color: white; border: none; border-radius: 4px;">
		        Search
		    </button>
		
		    <!-- Sort Dropdown -->
		    <select name="sortBy" style="padding: 10px; border: 1px solid #ccc; border-radius: 4px;">
		        <option value="">Sort by</option>
		        <option value="disasterId">Disaster ID</option>
		        <option value="disasterTitle">Title</option>
		        <option value="dateOfIncident">Date</option>
		        <option value="noOfDeath">Deaths</option>
		        <option value="noOfInjuries">Injuries</option>
		    </select>
		
		    <button type="submit" name="action" value="sort"
		            style="padding: 10px 20px; background-color: #28a745; color: white; border: none; border-radius: 4px;">
		        Sort
		    </button>
		
		</form>
        
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Type</th>
                    <th>Municipality/VDC</th>
                    <th>Ward</th>
                    <th>Coordinates</th>
                    <th>Date</th>
                    <th>Reported By</th>
                    <th>Coordinator</th>
                    <th>Injuries</th>
                    <th>Deaths</th>
                    <th>Missing</th>
                    <th>Loss (Rs)</th>
                    <th>Notes</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    if (disasterList != null && !disasterList.isEmpty()) {
                        for (DisasterModel d : disasterList) {
                %>
                    <tr>
                        <td><%= d.getDisasterId() %></td>
                        <td><%= d.getDisasterTitle() %></td>
                        <td><%= d.getDisasterType() %></td>
                        <td><%= d.getMunicipalityOrVdc() %></td>
                        <td><%= d.getWard() %></td>
                        <td><%= d.getLongitudeLatitude() %></td>
                        <td><%= d.getDateOfIncident() %></td>
                        <td><%= d.getReportedBy() %></td>
                        <td><%= d.getAssignedCoordinator() %></td>
                        <td><%= d.getNoOfInjuries() %></td>
                        <td><%= d.getNoOfDeath() %></td>
                        <td><%= d.getNoOfMissing() %></td>
                        <td><%= d.getEstimatedLoss() %></td>
                        <td><%= d.getOtherNotes() %></td>
                    </tr>
                <% 
                        }
                    } else { 
                %>
                    <tr>
                        <td colspan="14">No disaster records found.</td>
                    </tr>
                <% 
                    }
                %>
            </tbody>
        </table>
        <div class="back-button">
            <a href="home">Back to Home</a>
        </div>
    </div>    
</body>
</html>