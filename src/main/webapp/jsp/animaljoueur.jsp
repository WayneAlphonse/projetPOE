<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
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


<p>Choisis un jeu :</p>
<select name="jeux">
<core:forEach var="jeux" items="${ listeJeux }">
<option>${ jeux.typeJeux }</option>
</core:forEach>
</select>

<form action="" method="post">
<label for="dureeJeux">Pendant combien de temps veux-tu jouer ?</label>
<input type="number" name="dureeJeux" id="dureeJeux" step="10">
</form> 


${msg }

</body>
</html>