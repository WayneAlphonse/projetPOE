<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>

<base href="<%=request.getScheme() + "://"
		+ request.getServerName() + ":"
		+ request.getServerPort()
		+ request.getContextPath() + "/"
		%>" />
		
		<link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>

<body>
<div class="bg"><h1 class="titreH1">TAMAGOCHI</h1></div>

<h2 class="titreH2">Inscris-toi!</h2>

<form class="formInscription" method="post" action="inscription">
	<label for="nom">Nom:</label>
	<input type="text" name="nom" id="nom"/>
	<br>
	
	<label for="prenom">Prénom:</label>
	<input type="text" name="prenom" id="prenom"/>
	<br>
	
	<label for="pseudo">Pseudo:</label>
	<input type="text" name="pseudo" id="pseudo"/>
	<br>
	<label for="email">Email:</label>
	<input type="email" name="email" id="email" />
	<br>
	<label for="password">Password:</label>
	<input type="password" name="password" id="password"/>
	<br>
	<label for="age">Age:</label>
	<input type="number" name="age" id="age"/>	
	<br>
	<input type="submit" value="Valider"/>
	<br>
</form>


<form action="login" method="get">
	Déjà inscrit ?
	<input type="submit" value="Connecte-toi!"/>
</form>
</body>
</html>