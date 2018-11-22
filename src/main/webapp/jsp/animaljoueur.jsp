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

<form action="calculjeu" method="post">
<p>Choisis un jeu :</p>
<select name="typeJeux">
<core:forEach var="jeux" items="${ listeJeux }">
<option>${ jeux.typeJeux }</option>
</core:forEach>
</select>
<label for="dureeJeux">Pendant combien de temps veux-tu jouer avec ${ animal.nom } ?</label>
<input type="number" name="dureeJeux" id="dureeJeux" step="10" min="10" max="1000" required>minutes
<input type="submit" value="Jouer !">
</form>


<form action="calculdodo" method="post">
<p>Choisis un lieu pour faire dormir ton animal :</p>
<select name="dodo">
<core:forEach var="dodo" items="${ listeDodo }">
<option>${ dodo.lieu }</option>
</core:forEach>
</select>
<label for="dureeDodo">Pendant combien de temps veux-tu faire dormir ton animal ?</label>
<input type="number" name="dureeDodo" id="dureeDodo" min="1" max="24">heure(s)
<input type="submit" value="Dormir !">
</form>

<form action="calculnourriture" method="post">
<p>Choisis quelle nourriture ton animal va manger :</p>
<select name="nourriture">
<core:forEach var="nourriture" items="${ listeNourriture }">
<option>${ nourriture.typeNourriture }</option>
</core:forEach>
</select>
<label for="quantiteNourriture">Quelle quantité souhaites-tu donner à ton animal ?</label>
<input type="number" name="quantiteNourriture" id="quantiteNourriture" min="1" max="1000">
<input type="submit" value="Manger!">
</form>


${msg1 }
${msg }

</body>
</html>