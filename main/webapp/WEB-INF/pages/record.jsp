<%@ page import="java.util.List, com.crisisconnect.model.DisasterModel" %>

<head>
	<style>
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
	</style>
</head>

<body>
	<%
	    String username = (String) session.getAttribute("username");
	    String  usertype= (String) session.getAttribute("usertype");
	    
	    List<DisasterModel> disasterList = (List<DisasterModel>) request.getAttribute("disasters"); 
	%>
	
	<div>
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
	</div>
</body>