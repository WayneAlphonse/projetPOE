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

<table>
		<tr>
			<th>Nom</th>
			<th>Taux de gourmandise</th>
			<th>Taux de sportif</th>
			<th>Taux de marmotte</th>
			<th>Couleur</th>
			<th>Image</th>
		</tr>
		<core:forEach var="animal" items="${ listeAnimals }">
		
		
		<tr>
			<td>${ animal.nom }</td>
			<td>${ animal.gourmand }</td>
			<td>${ animal.sportif }</td>
			<td>${ animal.marmotte }</td>
			<td>${animal.couleur }</td>
	
			</core:forEach>
			
	</table>
			
			

${ msg }
</body>
</html>