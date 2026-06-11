<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>Register</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="login-container">

<h2>User Registration</h2>

<form action="RegisterServlet" method="post">

<input type="text"
       name="fullname"
       placeholder="Full Name"
       required>

<input type="text"
       name="username"
       placeholder="Username"
       required>

<input type="email"
       name="email"
       placeholder="Email"
       required>

<input type="password"
       name="password"
       placeholder="Password"
       required>

<input type="text"
       name="phone"
       placeholder="Phone">

<input type="text"
       name="address"
       placeholder="Address">

<button type="submit">
Register
</button>

</form>

</div>

</body>
</html>