<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nav.css" />

    <title>About Us - Crisis Connect</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            color: #333;
            margin: 0;
        }
        .container {
            max-width: 800px;
            margin: auto;
        }
        h2 {
            color: #00529B;
        }
    </style>
</head>
<body>
	<jsp:include page="nav.jsp"/>
	
    <div class="container">
        <h2>About Crisis Connect</h2>
        <p>
            <strong>Crisis Connect</strong> is a centralized disaster reporting and response coordination platform developed to improve communication and data handling during natural and man-made crises across the district.
        </p>
        <p>
            Managed by the <strong>District Administration Office (DAO)</strong>, Crisis Connect allows verified officials and the general public to report incidents, monitor disaster data, and ensure a rapid, coordinated response.
        </p>
        <p>
            The platform aims to:
            <ul>
                <li>Enhance transparency in disaster response and resource allocation</li>
                <li>Enable real-time reporting of incidents</li>
                <li>Ensure accurate tracking of damages and losses</li>
                <li>Foster collaboration among responders and government agencies</li>
            </ul>
        </p>
        <p>
            Through modern technology and accessible design, Crisis Connect empowers both citizens and authorities to take proactive action in times of crisis.
        </p>
    </div>
</body>
</html>
