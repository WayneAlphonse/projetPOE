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
<link rel="stylesheet" href="css/listeanimal.css" type="text/css"/>
</head>
<body>
<h2>Choisis un animal parmi ceux présentés :</h2>

<core:forEach var ="animal" items="${ listeAnimals }" >	
	<div class="responsive">
		<div class="gallery"><img src="${ animal.nomImage }" width="200"/>
		<div class="desc">
		<p><strong>${animal.nom }</strong></p>
		<p>${animal.couleur }</p>
		<p>Taux de gourmandise :</p>
		<p>${animal.gourmand }</p>
		<p>Taux de sportif :</p>
		<p>${animal.sportif }</p>
		<p>Taux de marmotte :</p>
		<p>${animal.marmotte }</p></div>
		<form action="animaljoueur" method="post">
					<input type="hidden" name= "id" value= "${animal.id}"/>
					<input type="submit" value="Je choisis celui-ci !" class="button"/>
				</form></div>
		</div>	
		</div>
		
		</core:forEach>

${ msg }
</body>
</html>