<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nav.css" />
    <title>Contact Us - Crisis Connect</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            color: #333;
            margin: 0;
        }
        .container {
            max-width: 700px;
            margin: auto;
        }
        h2 {
            color: #00529B;
        }
        form {
            background: #ffffff;
            padding: 20px;
            margin-top: 20px;
            border-radius: 10px;
            box-shadow: 0 0 5px rgba(0,0,0,0.1);
        }
        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="email"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            resize: vertical;
        }
        textarea {
            height: 120px;
        }
        button {
            margin-top: 15px;
            padding: 10px 20px;
            background-color: #00529B;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .contact-info {
            margin-top: 40px;
            background: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 5px rgba(0,0,0,0.1);
        }
        .contact-info p {
            margin: 10px 0;
        }
    </style>
</head>
<body>
	<jsp:include page="nav.jsp"/>
	
    <div class="container">
        <h2>Contact Us</h2>
        <p>If you have any questions, concerns, or feedback, feel free to reach out using the form below.</p>

        <form method="post" action="#">
            <label for="fullName">Full Name</label>
            <input type="text" id="fullName" name="fullName" required>

            <label for="email">Email Address</label>
            <input type="email" id="email" name="email" required>

            <label for="message">Message</label>
            <textarea id="message" name="message" required></textarea>

            <button type="submit">Submit</button>
        </form>

        <div class="contact-info">
            <p><strong>District Administration Office, Kavrepalanchok</strong></p>
            <p><strong>Address:</strong> Dhulikhel</p>
            <p><strong>Contact No:</strong> +977-011-490223</p>
            <p><strong>Email:</strong> crisisconnect@dao.gov.np</p>
            <p><strong>Office Hours:</strong> Sunday – Friday, 10:00 AM – 5:00 PM</p>
        </div>
    </div>
</body>
</html>
