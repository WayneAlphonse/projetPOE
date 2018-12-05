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
<meta charset="ISO-8859-1">
<title>Ajout d'image</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
					<input type="hidden" name= "id" value= "${ animal.id }"/>	
					<input type="file" name="image_animal"/>
					<input type="submit" value=" Upload d'image d'un animal"/>
				</form>
</body>
</html>