<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="login-container">

<h2>Travel Management System</h2>

<form action="LoginServlet" method="post">

<input type="text"
       name="username"
       placeholder="Username"
       required>

<input type="password"
       name="password"
       placeholder="Password"
       required>

<button type="submit">
Login
</button>

</form>

<br>

<a href="register.jsp">
Create Account
</a>

</div>

</body>
</html>