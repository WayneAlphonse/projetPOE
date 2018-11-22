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
		
	<link rel="stylesheet" href="css/style.css" type="text/css"/>
<meta charset="ISO-8859-1">

<title>login</title>
</head>
<body>
<h2>Connecte-toi !</h2>

<form action="login" method="post">
	<label for="email">email :</label>
	<input type="email" name="email" id="email"/>
	<br>
	<label for="password">mot de passe :</label>
	<input type="password" name="password" id="password"/>
	<br>
	<input type="submit" value="Connecte-toi !"/>


</form>


</body>
</html>