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
<link rel="stylesheet" href="css/animaljoueur.css" type="text/css"/>
</head>

<body>

<div class="conteneur">

<div class="corps">
<h1>Bienvenue ${ sessionScope.joueur.pseudo } sur la page de ton Animal !</h1>

<div class="img"><img alt="" src=" ${animal.nomImage}" width="200"></div>

<form action="calculjeu" method="post">
<p class="titre"><strong> Choisis un jeu : </strong></p>
<select name="typeJeux" class="choix">
<core:forEach var="jeux" items="${ listeJeux }">
<option>${ jeux.typeJeux }</option>
</core:forEach>
</select>
<label for="dureeJeux">Pendant combien de temps veux-tu jouer avec ${ animal.nom } ?</label>
<input type="number" name="dureeJeux" id="dureeJeux" step="10" min="10" max="1000" required class="choix">minutes
<input type="submit" value="Jouer !" class="button">
</form>


<form action="calculdodo" method="post">
<p>Choisis un lieu pour faire dormir ton animal :</p>
<select name="lieu" class="choix">
<core:forEach var="dodo" items="${ listeDodo }">
<option>${ dodo.lieu }</option>
</core:forEach>
</select>
<label for="dureeDodo">Pendant combien de temps veux-tu faire dormir ton animal ?</label>
<input type="number" name="dureeDodo" id="dureeDodo" min="1" max="24" required class="choix">heure(s)
<input type="submit" value="Dormir !" class="button">
</form>

<form action="calculnourriture" method="post">
<p>Choisis quelle nourriture ton animal va manger :</p>
<select name="typeNourriture" class="choix">
<core:forEach var="nourriture" items="${ listeNourriture }">
<option>${ nourriture.typeNourriture }</option>
</core:forEach>
</select>
<label for="quantiteNourriture">Quelle quantité souhaites-tu donner à ton animal ?</label>
<input type="number" name="quantiteNourriture" id="quantiteNourriture" min="1" max="1000" required class="choix">
<input type="submit" value="Manger!" class="button">
</form>

<p>${msg }</p>
</div>
</div>
</body>
</html>