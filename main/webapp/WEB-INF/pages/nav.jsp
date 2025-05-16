<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nav.css"" />
</head>

<body>
	<nav>
	
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
	</nav>
</body>