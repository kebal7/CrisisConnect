<body>
<nav>
    <%
        String username = (String) session.getAttribute("username");
        String usertype = (String) session.getAttribute("usertype");
    %>
    <div class="header">
        <h1 class="logo">CrisisConnect</h1>

        <!-- Navigation Links -->
        <ul class="nav-links">
            <% if ("admin".equalsIgnoreCase(usertype)) { %>
                <li><a href="${pageContext.request.contextPath}/adminhome">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/managedisasterrecord">Manage Disaster</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/adddisaster">Add Disaster</a></li>
                <li><a href="${pageContext.request.contextPath}/view">View Disaster</a></li>
            <% } else { %>
                <li><a href="${pageContext.request.contextPath}/userhome">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/view">View Disaster</a></li>
                <li><a href="${pageContext.request.contextPath}/userhome">About Us</a></li>
                <li><a href="${pageContext.request.contextPath}/userhome">Contact Us</a></li>
            <% } %>
        </ul>

        <!-- User Info & Logout -->
        <div class="user-info">
            <span class="welcome">
                Welcome, <strong><a style = "color: floralwhite" href="${pageContext.request.contextPath}/profile"><%= username %></a></strong> (<%= usertype %>)
            </span>
            <a href="logout" class="logout">Logout</a>
        </div>
    </div>
</nav>

</body>