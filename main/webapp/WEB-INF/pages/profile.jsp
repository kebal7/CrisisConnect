<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Profile</title>
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
            max-width: 800px;
            margin: 40px auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.08);
        }

        .profile-info {
            display: grid;
            grid-template-columns: 1fr 2fr;
            gap: 15px 25px;
            margin-top: 20px;
        }

        .profile-info label {
            font-weight: bold;
            color: #333;
        }

        .profile-info span {
            color: #555;
        }

        .profile-pic {
            text-align: center;
            margin-bottom: 30px;
        }

        .profile-pic img {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            object-fit: cover;
            border: 4px solid #007BFF;
        }

    </style>
</head>
<body>
<%
    String username = (String) request.getAttribute("username");
	String fullName = (String) request.getAttribute("fullName");
    String usertype = (String) request.getAttribute("usertype");
    String email = (String) request.getAttribute("email");
    String password = (String) request.getAttribute("password");
    String phoneNumber = (String) request.getAttribute("phoneNumber");
    String dateOfBirth = (String) request.getAttribute("dateOfBirth");
    String address = (String) request.getAttribute("address");
    String imagePath = (String) request.getAttribute("imagePath");
%>

<div class="header">
    <h1>CrisisConnect</h1>
    <div>
        <span class="welcome">Welcome, <strong><%=username%></strong> (<%=usertype%>)</span>
        <a href="logout" class="logout" style="color:white; margin-left:20px; text-decoration:underline;">Logout</a>
    </div>
</div>

<div class="container">
    <div class="profile-pic">
        <img src="<%=imagePath != null ? imagePath : "default-profile.png" %>" alt="Profile Picture">
    </div>

    <div class="profile-info">
    	<label>Username:</label>
        <span><%=username%></span>
        
        <label>Full Name:</label>
        <span><%=fullName%></span>

        <label>User Type:</label>
        <span><%=usertype%></span>

        <label>Email:</label>
        <span><%=email%></span>

		<label>Password:</label>
        <span><%=password%></span>
        
        <label>Phone Number:</label>
        <span><%=phoneNumber%></span>

        <label>Date of Birth:</label>
        <span><%=dateOfBirth%></span>

        <label>Address:</label>
        <span><%=address%></span>

    </div>
</div>
</body>
</html>
