<%@page import="fr.dawan.beans.TypeAnimal"%>
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
<title>Page de création d'animaux</title>
</head>
<body>
<form action="creaanimal" method="post">
	
	<label for="nom">Nom de l'animal</label>
	<input type="text" name="nom" id="nom"/>
	<br>
	<label for="gourmand">Taux de satieté :</label>
	<input type="number" name="gourmand" id="gourmand"/>
	<br>
	<label for="sportif">Taux de jeux :</label>
	<input type="number" name="sportif" id="sportif"/>
	<br>
	<label for="marmotte">Taux de sommeil: </label>
	<input type="number" name="marmotte" id="marmotte"/>
	<br>
	<label for="couleur">Couleur :</label>
	<input type="text" name="couleur" id="couleur"/>
	<br>
	<label for="typeAnimal">Type de l'animal :</label>
	<select name="typeAnimal">
	<core:forEach var= "typeAnimal" items="<%=TypeAnimal.values() %>"> 
	 <option value="${ typeAnimal}">${typeAnimal } </option>
	
	</core:forEach>
	
	</select>
	

	<input type="submit" value="Créer !"/>
	




</form>



</body>
</html>