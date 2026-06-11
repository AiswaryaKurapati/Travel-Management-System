<%@ page import="com.travel.model.User" %>

<%
User user=(User)session.getAttribute("user");

if(user==null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<html>
<head>
<title>Dashboard</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<nav>

<a href="dashboard.jsp">Home</a>

<a href="packages.jsp">Packages</a>

<a href="hotels.jsp">Hotels</a>

<a href="my_bookings.jsp">Bookings</a>

</nav>

<div class="container">

<h2>
Welcome <%= user.getFullName() %>
</h2>

<p>
Travel Management System Dashboard
</p>

</div>

</body>
</html>