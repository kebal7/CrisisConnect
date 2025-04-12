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
            padding: 0;
            font-family: "Segoe UI", sans-serif;
            background: #f4f4f4;
            display: flex;
            flex-direction: column;
            height: 100vh;
            justify-content: center;
            align-items: center;
        }
        .container {
            text-align: center;
            background: white;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        h1 {
            margin-bottom: 20px;
            color: #333;
        }
        .btn {
            display: inline-block;
            margin: 10px;
            padding: 12px 24px;
            font-size: 16px;
            border-radius: 6px;
            border: none;
            cursor: pointer;
            transition: background 0.3s;
        }
        .btn-login {
            background: #007BFF;
            color: white;
        }
        .btn-register {
            background: #28A745;
            color: white;
        }
        .btn:hover {
            opacity: 0.9;
        }
    </style>
    
</head>


<body>
	    <div class="container">
        <h1>Welcome to Disaster View</h1>
        <p>Please login or register to continue.</p>
        <a href="login"><button class="btn btn-login">Login</button></a>
        <a href="register"><button class="btn btn-register">Register</button></a>
    	</div>
</body>
</html>