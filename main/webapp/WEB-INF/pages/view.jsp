<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	        <span class="welcome">Welcome, <strong><a href="profile"><%=username%></a></strong> (<%=usertype  %>)</span>
	        <a href="logout" class="logout">Logout</a>
	 </div>
</div>
</body>
</html>