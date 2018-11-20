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
<title>AnimalduJoueur</title>
</head>
<body>
<h1>Bienvenue ${ sessionScope.joueur.pseudo } sur la page de ton Animal !</h1>

<img alt="" src=" ${animal.nomImage}" width="200">

</body>
</html>