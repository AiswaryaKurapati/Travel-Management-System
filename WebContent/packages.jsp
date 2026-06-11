<%@ page import="java.util.*" %>
<%@ page import="com.travel.dao.PackageDAO" %>
<%@ page import="com.travel.model.Package" %>

<%
PackageDAO dao = new PackageDAO();
List<Package> packages = dao.getAllPackages();
%>

<html>
<head>
<title>Packages</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="container">

<h2>Available Packages</h2>

<%
for(Package p : packages){
%>

<div class="card">

<h3><%= p.getPackageName() %></h3>

<p>Destination:
<%= p.getDestination() %>
</p>

<p>Duration:
<%= p.getDurationDays() %> Days
</p>

<p>Price:
₹ <%= p.getPrice() %>
</p>

<a href="booking.jsp?id=<%= p.getPackageId() %>">
Book Now
</a>

</div>

<%
}
%>

</div>

</body>
</html>