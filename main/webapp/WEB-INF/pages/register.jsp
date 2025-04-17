<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

   <style>
        body {
            font-family: "Segoe UI", sans-serif;
            background: #f1f8e9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .register-container {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            width: 320px;
        }
        h2 {
            margin-bottom: 20px;
            text-align: center;
            color: #28A745;
        }
        input[type="text"],
        input[type="password"],
        input[type="email"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            background-color: #28A745;
            color: white;
            border: none;
            padding: 10px;
            width: 100%;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px;
        }
        input[type="submit"]:hover {
            opacity: 0.9;
        }
        .back-link {
            display: block;
            margin-top: 15px;
            text-align: center;
            color: #28A745;
            text-decoration: none;
        }
    </style>
    
</head>
<body>
	<div class="register-container">
        <h2>Create Account</h2>
        
        <script>
		    function validateForm() {
		        var password = document.getElementsByName("password")[0].value;
		        var confirmPassword = document.getElementsByName("confirmPassword")[0].value;
		        
		        if (password !== confirmPassword) {
		            alert("Passwords do not match!");
		            return false;
		        }
		        return true;
		    }
		</script>
        
        <form action="" method="post" onsubmit="return validateForm()">
            <input type="text" name="username" placeholder="Username" required />
            <input type="text" name="fullName" placeholder="Full Name" required>
            <input type="email" name="email" placeholder="Email" required />
            <input type="password" name="password" placeholder="Password" required />
            <input type="password" name="confirmPassword" placeholder="Confirm Password" required />
            <input type="number" name="phoneNumber" placeholder = "Phone Number" required/>
            <input type="date" name="dob" placeholder="Date" required/>
            <input type="text" name="address" placeholder="Address" required/>
            
            <select name="usertype" required>
        		<option value="" disabled selected>Select User Type</option>
        		<option value="user">User</option>
        		<option value="admin">Admin</option>
    		</select>
            
            <input type="submit" value="Register" />
        </form>
        <a class="back-link" href="index.html">← Back to Home</a>
    </div>
</body>
</html>