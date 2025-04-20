<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crisis Connect</title>

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

        .dashboard {
            padding: 40px;
        }

        .stats {
            display: flex;
            flex-wrap: wrap;
            gap: 30px;
            margin-bottom: 50px;
        }

        .card {
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            width: 250px;
            text-align: center;
        }

        .card h2 {
            margin: 0;
            font-size: 36px;
            color: #007BFF;
        }

        .card p {
            margin: 10px 0 0;
            font-size: 16px;
        }

        .nav-links a {
            margin: 10px;
            padding: 12px 24px;
            background: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            display: inline-block;
        }

        .nav-links a:hover {
            background: #218838;
        }

        .logout {
            color: white;
            text-decoration: underline;
            margin-left: 20px;
        }
        
        .stats {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
    gap: 25px;
    margin-bottom: 40px;
}

.card {
    background: white;
    padding: 20px 25px;
    border-left: 6px solid #007BFF;
    border-radius: 12px;
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.08);
    transition: transform 0.2s ease;
    display: flex;
    align-items: center;
    gap: 15px;
}

.card:hover {
    transform: translateY(-5px);
}

.card-icon {
    font-size: 36px;
    color: #007BFF;
    background: rgba(0,123,255,0.1);
    padding: 10px;
    border-radius: 50%;
}

.card-content h2 {
    margin: 0;
    font-size: 28px;
    color: #333;
}

.card-content p {
    margin: 4px 0 0;
    color: #666;
    font-size: 14px;
}
        

</style>


</head>
<body>
<%
    String username = (String) session.getAttribute("username");
    String  usertype= (String) session.getAttribute("usertype");
%>

<div class="header">
    <h1>CrisisConnect</h1>
    <div>
        <span class="welcome">Welcome, <strong><%=username%></strong> (<%=usertype  %>)</span>
        <a href="logout" class="logout">Logout</a>
    </div>
</div>

<div class="dashboard">
    <div class="stats">
        <div class="card">
            <h2>132</h2>
            <p>Total Disasters</p>
        </div>
        <div class="card">
            <h2>57</h2>
            <p>Total Injuries</p>
        </div>
        <div class="card">
            <h2>14</h2>
            <p>Coordinators Assigned</p>
        </div>
    </div>
    
    <div class="card" style="border-left-color: #007BFF;">
    <div class="card-icon">🌊</div>
    <div class="card-content">
        <h2>40</h2>
        <p>Floods</p>
    </div>
</div>

<div class="card" style="border-left-color: #28A745;">
    <div class="card-icon">⛰️</div>
    <div class="card-content">
        <h2>30</h2>
        <p>Landslides</p>
    </div>
</div>

<div class="card" style="border-left-color: #FFC107;">
    <div class="card-icon">🔥</div>
    <div class="card-content">
        <h2>25</h2>
        <p>Fires</p>
    </div>
</div>

<div class="card" style="border-left-color: #DC3545;">
    <div class="card-icon">🌍</div>
    <div class="card-content">
        <h2>12</h2>
        <p>Earthquakes</p>
    </div>
</div>

    <div class="nav-links">
        <a href="view-disasters.jsp">View Disasters</a>
        <% if ("admin".equalsIgnoreCase("usertype")) { %>
            <a href="add-disaster.jsp">Add Disaster</a>
            <a href="manage-users.jsp">Manage Users</a>
        <% } %>
        <a href="profile.jsp">Your Profile</a>
    </div>
</div>
	
</body>
</html>