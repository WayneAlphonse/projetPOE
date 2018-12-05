<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<base href="<%=request.getScheme() + "://"

        + request.getServerName() + ":"

        + request.getServerPort()

        + request.getContextPath() + "/"

        %>" />

<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styleLogin.css" type="text/css" />
<meta charset="ISO-8859-1">

<title>login</title>

</head>

<body>

<h2 class="texto">Connecte-toi !</h2>
<div class="Registro">
<form action="login" method="post">

    <span class="fontawesome-envelope-alt" ></span>
    <input type="email" name="email" id="email" placeholder="Email" required/>
	<span class="fontawesome-lock"></span>
    <input type="password" name="password" id="password" placeholder="Password" required/>
    <input type="submit" value="Connecte-toi !"/>

</form>
</div>
</body>

</html>