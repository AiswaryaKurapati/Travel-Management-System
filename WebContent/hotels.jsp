<%@ page import="java.util.*" %>
<%@ page import="com.travel.dao.HotelDAO" %>
<%@ page import="com.travel.model.Hotel" %>

<%
HotelDAO dao = new HotelDAO();
List<Hotel> hotels = dao.getAllHotels();
%>

<html>
<head>
<title>Hotels</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="container">

<h2>Available Hotels</h2>

<%
for(Hotel h : hotels){
%>

<div class="card">

<h3><%= h.getHotelName() %></h3>

<p>Location: <%= h.getLocation() %></p>

<p>Rating: <%= h.getRating() %></p>

<p>Price Per Night:
 <%= h.getPricePerNight() %>
</p>

<p><%= h.getDescription() %></p>

</div>

<%
}
%>

</div>

</body>
</html>