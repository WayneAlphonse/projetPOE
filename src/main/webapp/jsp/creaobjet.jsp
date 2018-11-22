<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<base href="<%=request.getScheme() + "://"
		+ request.getServerName() + ":"
		+ request.getServerPort()
		+ request.getContextPath() + "/"
		%>" />
<title>Création de jeu pour animal</title>
</head>
<body>
<form action="creajeux" method="post">
		
	<label for="typeJeux">Nom du jouet:</label>
	<input type="text" name="typeJeux" id="typeJeux"/>
	<br>
	
	<label for="tauxBonheur">Taux de jeux:</label>
	<input type="number" name="tauxBonheur" id="tauxBonheur"/>
	<br>
	<input type="submit" value="Créer le jeu !"/>
	
</form>

<br>
<br>
<form action="creadodo" method="post" >

	<label for="lieu">Lieu Dodo:</label>
	<input type="text" name="lieu" id="lieu"/>
	<br>
	
	<label for="tauxSommeil">Taux de Sommeil:</label>
	<input type="number" name="tauxSommeil" id="tauxSommeil"/>
	<br>
	<input type="submit" value="Créer dodo !"/>

</form>
<br>
<br>
	
<form action="creanourriture" method="post" >

	<label for="typeNourriture">Nom de la nourriture:</label>
	<input type="text" name="typeNourriture" id="typeNourriture"/>
	<br>
	
	<label for="tauxSatiete">Taux de satiete:</label>
	<input type="number" name="tauxSatiete" id="tauxSatiete"/>
	<br>
	<input type="submit" value="Créer nourriture !"/>

</form>	
<br>
<br>

</body>
</html>