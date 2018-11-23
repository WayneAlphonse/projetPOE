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
		
	<link rel="stylesheet" href="css/styleLogin.css" type="text/css"/>
<meta charset="ISO-8859-1">

<title>login</title>
</head>
<body>

<p class="texto">Connecte-toi !</p>
<div class="Registro">
<form method="post" action="https://getform.org/f/70415a77-d632-4883-bf07-2e15d3f557da">


<span class="fontawesome-envelope-alt"></span><input type="text" id="email" required placeholder="Email" autocomplete="off">
<span class="fontawesome-lock"></span><input type="password" name="password" id="password" required placeholder="Password" autocomplete="off"> 
		<input type="submit" value="Valider"/>
</form>




</body>
</html>


