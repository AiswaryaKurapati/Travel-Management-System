<%
String packageId = request.getParameter("id");
%>

<html>
<head>
<title>Book Package</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="login-container">

<h2>Book Package</h2>

<form action="BookingServlet" method="post">

<input type="hidden"
       name="packageId"
       value="<%= packageId %>">

<label>Travel Date</label>

<input type="date"
       name="travelDate"
       required>

<label>Number of People</label>

<input type="number"
       name="numPeople"
       required>

<label>Total Price</label>

<input type="number"
       name="totalPrice"
       required>

<button type="submit">
Confirm Booking
</button>

</form>

</div>

</body>
</html>