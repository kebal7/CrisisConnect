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
    
<script>
    function enableEdit() {
        document.querySelectorAll(".editable").forEach(el => el.style.display = 'none');
        document.querySelectorAll(".edit-input").forEach(el => el.style.display = 'inline-block');
        document.getElementById("saveBtn").style.display = 'inline-block';
        document.getElementById("cancelBtn").style.display = 'inline-block';
        document.getElementById("editBtn").style.display = 'none';
    }

    function cancelEdit() {
        document.querySelectorAll(".editable").forEach(el => el.style.display = 'inline');
        document.querySelectorAll(".edit-input").forEach(el => el.style.display = 'none');
        document.getElementById("saveBtn").style.display = 'none';
        document.getElementById("cancelBtn").style.display = 'none';
        document.getElementById("editBtn").style.display = 'inline-block';
    }
</script>
    
    
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

<jsp:include page="nav.jsp"/>

<div class="container">
    <div class="profile-pic">
        <img src="<%=imagePath != null ? imagePath : "default-profile.png" %>" alt="Profile Picture">
    </div>

	<form action="" method="post">
	    <input type="hidden" name="username" value="<%=username%>">
	    
	    <div class="profile-info">
	    	<label>Username:</label>
	        <span class=""><%=username%></span>
	        
	        <label>Full Name:</label>
	        <span class="editable"><%=fullName%></span>
	        <input class="edit-input" type="text" name="fullName" value="<%=fullName%>" style="display:none;" />
	
	        <label>Email:</label>
	        <span class="editable"><%=email%></span>
	        <input class="edit-input" type="email" name="email" value="<%=email%>" style="display:none;" />
	
	        <label>Password:</label>
	        <span class="editable">*********</span>
	        <input class="edit-input" type="password" name="password" value="<%=password%>" style="display:none;" />
	
	        <label>Phone Number:</label>
	        <span class="editable"><%=phoneNumber%></span>
	        <input class="edit-input" type="text" name="phoneNumber" value="<%=phoneNumber%>" style="display:none;" />
	
	        <label>Date of Birth:</label>
	        <span class="editable"><%=dateOfBirth%></span>
	        <input class="edit-input" type="date" name="dob" value="<%=dateOfBirth%>" style="display:none;" />
	
	        <label>Address:</label>
	        <span class="editable"><%=address%></span>
	        <input class="edit-input" type="text" name="address" value="<%=address%>" style="display:none;" />
	    </div>
	
	    <br/>
	    <div style="text-align:right;">
	        <button type="button" id="editBtn" onclick="enableEdit()">Edit</button>
	        <button type="submit" id="saveBtn" style="display:none;">Save Changes</button>
	        <button type="button" id="cancelBtn" onclick="cancelEdit()" style="display:none;">Cancel</button>
	    </div>
	</form>

</div>
</body>
</html>
