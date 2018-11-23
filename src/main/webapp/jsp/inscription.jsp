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


<div class="divInscription">

<form class="formInscription" method="post" action="inscription">
<h2 class="titreH2">Inscris-toi!</h2>
	<input type="text" name="nom" id="nom" placeholder="Nom :"/>
	<br>
	<input type="text" name="prenom" id="prenom" placeholder="Prénom :"/>
	<br>
	<input type="text" name="pseudo" id="pseudo" placeholder="Pseudo :"/>
	<br>
	<input type="email" name="email" id="email" placeholder="Email :"/>
	<br>
	<input type="password" name="password" id="password" placeholder="Password :"/>
	<br>
	<input type="number" name="age" id="age" placeholder="Age :"/>	
	<br>
	<input type="submit" value="Valider" class="boutonValid"/>
</form>
<form action="login" method="get" class="formLogin">
	Déjà inscrit ?
	<input type="submit" value="Connecte-toi!" class="buttonLogin"/>
	</form>
</div>
	
</body>
</html>