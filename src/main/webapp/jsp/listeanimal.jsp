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
			<th>Nom Couleur Gourmand Sportif Marmotte</th>
		<!-- 	<th>Taux de gourmandise</th>
			<th>Taux de sportif</th>
			<th>Taux de marmotte</th> -->
			<th>Image</th>
		</tr>
		<core:forEach var="animal" items="${ listeAnimals }">
		
		
		<tr>
			<td>${ animal.nom } ${animal.couleur } ${ animal.gourmand } ${ animal.sportif } ${ animal.marmotte } </td>
			<%-- <td>${ animal.gourmand }</td>
			<td>${ animal.sportif }</td>
			<td>${ animal.marmotte }</td> --%>
			
	
			</core:forEach>
			
			</table>

<core:forEach var ="animal" items="${ listeAnimals }" >		
		<div>
		<img alt="" src="${animal.nomImage }" width="200">
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
		
		
		</div>	
		
		</core:forEach>

${ msg }
</body>
</html>