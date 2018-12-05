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
<title>Liste des Animaux</title>
</head>
<body>
<h2>Choisis un animal parmi ceux présentés :</h2>


<core:forEach var ="animal" items="${ listeAnimals }" >		
		<div><img src="upload/${ animal.nomImage }" width="200"/>
		<p>Nom de l'animal</p>
		<p>${animal.nom }</p>
		<p>Couleur de l'animal</p>
		<p>${animal.couleur }</p>
		<p>Taux de gourmandise</p>
		<p>${animal.gourmand }</p>
		<p>Taux de sportif</p>
		<p>${animal.sportif }</p>
		<p>Taux de marmotte</p>
		<p>${animal.marmotte }</p>
		<form action="animaljoueur" method="post">
					<input type="hidden" name= "id" value= "${animal.id}"/>
					<input type="submit" value="Je choisis celui-ci !"/>
				</form>
		</div>	
		
		</core:forEach>

${ msg }
</body>
</html>